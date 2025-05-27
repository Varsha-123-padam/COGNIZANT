public class ThreadCreation {
    // First thread class using Thread extension
    static class MessageThread extends Thread {
        private final String message;
        private final int count;
        
        public MessageThread(String message, int count) {
            this.message = message;
            this.count = count;
        }
        
        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                System.out.println("Thread " + Thread.currentThread().threadId() + ": " + message);
            }
            try {
                Thread.sleep(500 * count); // Pause for total time after loop
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
    
    // Second thread class using Runnable implementation
    static class MessageRunnable implements Runnable {
        private final String message;
        private final int count;
        
        public MessageRunnable(String message, int count) {
            this.message = message;
            this.count = count;
        }
        
        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                System.out.println("Thread " + Thread.currentThread().threadId() + ": " + message);
            }
            try {
                Thread.sleep(500 * count); // Pause for total time after loop
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
    
    public static void main(String[] args) {
        // Create and start first thread using Thread class
        MessageThread thread1 = new MessageThread("Hello from Thread class!", 5);
        
        // Create and start second thread using Runnable
        Thread thread2 = new Thread(new MessageRunnable("Hello from Runnable!", 5));
        
        System.out.println("Starting threads...\n");
        thread1.start();
        thread2.start();
    }
}

