import java.sql.*;

public class Transaction {
    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password"; // Replace with your password

    public boolean transferMoney(int fromAccount, int toAccount, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false); // Start transaction

            // Prepare debit statement
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.setDouble(3, amount);
                int rowsAffected = debitStmt.executeUpdate();

                if (rowsAffected == 0) {
                    throw new SQLException("Insufficient funds or invalid account");
                }
            }

            // Prepare credit statement
            try (PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                int rowsAffected = creditStmt.executeUpdate();

                if (rowsAffected == 0) {
                    throw new SQLException("Invalid destination account");
                }
            }

            // If both operations succeed, commit the transaction
            conn.commit();
            return true;

        } catch (SQLException e) {
            // If any operation fails, rollback the transaction
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Rollback failed: " + rollbackEx.getMessage());
            }
            System.err.println("Transaction failed: " + e.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true); // Reset auto-commit
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public void displayBalance(int accountId) {
        String sql = "SELECT balance FROM accounts WHERE account_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.printf("Account %d balance: $%.2f%n", accountId, rs.getDouble("balance"));
            } else {
                System.out.println("Account not found");
            }
        } catch (SQLException e) {
            System.err.println("Error checking balance: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Transaction bank = new Transaction();
        
        // Display initial balances
        System.out.println("Initial balances:");
        bank.displayBalance(1);
        bank.displayBalance(2);

        // Perform transfer
        System.out.println("\nTransferring $500 from account 1 to account 2...");
        boolean success = bank.transferMoney(1, 2, 500.00);
        System.out.println("Transfer " + (success ? "successful" : "failed"));

        // Display final balances
        System.out.println("\nFinal balances:");
        bank.displayBalance(1);
        bank.displayBalance(2);
    }
}