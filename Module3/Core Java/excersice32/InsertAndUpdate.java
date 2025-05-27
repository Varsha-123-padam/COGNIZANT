public class InsertAndUpdate {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Test insert operation
        System.out.println("Inserting new student...");
        boolean insertSuccess = dao.insertStudent("Alice Cooper", 23);
        System.out.println("Insert " + (insertSuccess ? "successful" : "failed"));

        // Test update operation
        System.out.println("\nUpdating student...");
        boolean updateSuccess = dao.updateStudent(1, "John Smith", 21);
        System.out.println("Update " + (updateSuccess ? "successful" : "failed"));
    }
}