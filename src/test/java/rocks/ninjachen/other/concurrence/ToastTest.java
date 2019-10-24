package rocks.ninjachen.other.concurrence;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ToastTest {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

    public static class Toast {
        public enum Status {DRY, BUTTERED, JAMMED}
        private final int id;
        private Status status = Status.DRY;
        public Toast(int idn) { id = idn; }
        public void butter() { status = Status.BUTTERED; }
        public void jam() { status = Status.JAMMED; }
        public Status getStatus() {return status;}
        public int getId() {return id;}
        public String toString() {
            return "Toast " + id + ": " + status;
        }
    }
    public static class ToastQueue extends LinkedBlockingQueue<Toast> {}

    public static class Toaster implements Runnable {
        private ToastQueue toastQueue;
        private int count = 0;
        private Random rand = new Random(47);

        public Toaster(ToastQueue toastQueue) {
            this.toastQueue = toastQueue;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                    // Make toast
                    Toast t = new Toast(count++);
                    System.out.println(t);
                    // Insert into queue
                    toastQueue.put(t);
                }
            } catch (InterruptedException e) {
                System.out.println("Toast interrupted.");
            }
            System.out.println("Toast off.");
        }
    }

    public static class Butterer implements Runnable {
        private ToastQueue dryQueue, butteredQueue;
        public Butterer(ToastQueue dry, ToastQueue buttered) {
            dryQueue = dry;
            butteredQueue = buttered;
        }
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    // Blocks until next piece of toast is available:
                    Toast t = dryQueue.take();
                    t.butter();
                    butteredQueue.put(t);
                }
            } catch (InterruptedException e) {
                System.out.println("Butterer interrupted");
            }
            System.out.println("Butterer off");
        }
    }

    public static class Jammer implements Runnable {
        private ToastQueue butteredQueue, finishedQueue;
        public Jammer(ToastQueue buttered, ToastQueue finished) {
            butteredQueue = buttered;
            finishedQueue = finished;
        }
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    // Blocks until next piece of toast is available:
                    Toast t = butteredQueue.take();
                    t.jam();
                    finishedQueue.put(t);
                }
            } catch (InterruptedException e) {
                System.out.println("Jammer interrupted");
            }
            System.out.println("Jammer off");
        }
    }

    public static class Eater implements Runnable {
        private ToastQueue finishedQueue;
        private int counter = 0;

        public Eater(ToastQueue finished) {
            this.finishedQueue = finished;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Toast t = finishedQueue.take();
                    if(t.getId() != counter++ ||
                    t.getStatus() != Toast.Status.JAMMED) {
                        System.out.println(">>>>Error: " + t);
                        System.exit(1);
                    } else {
                        System.out.println("Chomp! " + t);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Eater interrupted.");
            }
            System.out.println("Eater off");
        }
    }
}
