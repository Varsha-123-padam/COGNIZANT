import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecuterServiceCallable {
    static class FactorialCalculator implements Callable<Long> {
        private final int number;

        public FactorialCalculator(int number) {
            this.number = number;
        }

        @Override
        public Long call() {
            return calculateFactorial();
        }

        private Long calculateFactorial() {
            long result = 1;
            for (int i = 2; i <= number; i++) {
                result *= i;
                // Simulate some work
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Create a list to hold the Future objects
        List<Future<Long>> futures = new ArrayList<>();
        
        // Submit tasks for calculating factorials of numbers 1 to 5
        for (int i = 1; i <= 5; i++) {
            Callable<Long> task = new FactorialCalculator(i);
            Future<Long> future = executor.submit(task);
            futures.add(future);
        }
        
        // Collect and print results
        try {
            for (int i = 0; i < futures.size(); i++) {
                Long result = futures.get(i).get();
                System.out.printf("Factorial of %d is: %d%n", i + 1, result);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor
            executor.shutdown();
            try {
                // Wait for all tasks to complete or timeout after 1 minute
                if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }
}

