package rocks.ninjachen.other;

public class OddEvenThread  {
    public static void main(String[] args) {
        printSequence();
//        PriorityQueue q = null;
//        q.poll();
//        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
//        lock.unlock();
    }

    private static void printSequence() {
        OddEven oddEven = new OddEven();
        Thread thread1 = new Thread(oddEven, "odd");
        Thread thread2 = new Thread(oddEven, "even");
        thread1.start();
        thread2.start();
    }

    public static class OddEven implements Runnable{

        @Override
        public synchronized void run() {
            if (Thread.currentThread().getName().equals("odd")) {
                for (int i = 1; i <= 10; i += 2) {
                    System.out.println(i);
                    if (i ==1){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    notify();
                    try {
                        wait(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else if (Thread.currentThread().getName().equals("even")) {
                for (int i = 2; i <= 10; i += 2) {

                    if (i ==2){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    notify();
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
