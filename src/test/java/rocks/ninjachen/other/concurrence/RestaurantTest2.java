package rocks.ninjachen.other.concurrence;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A simple producer and consumer case
 * Use reentrantLock.lock() and reentrantLock.newCondition();
 */
public class RestaurantTest2 {
    /**
     * Run this plz!
     * @param args
     */
    public static void main(String[] args) {
        new Restaurant();
    }

    /**
     * I don't know why this can not work properly
     */
    @Test
    @Deprecated
    public void testcase1() {
        new Restaurant();
    }

    public static class Restaurant {
        Meal meal;
        ExecutorService exec = Executors.newCachedThreadPool();
        WaitPerson waitPerson = new WaitPerson(this);
        Chef chef = new Chef(this);

        public Restaurant() {
            exec.execute(chef);
            exec.execute(waitPerson);
        }

    }

    static class Meal {
        private final int orderNum;

        public Meal(int orderNum) {
            this.orderNum = orderNum;
        }

        @Override
        public String toString() {
            return "meal" + orderNum;
        }
    }

    static class WaitPerson implements Runnable {
        private Restaurant restaurant;
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public WaitPerson(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    lock.lock();
                    try {
                        while (restaurant.meal == null) {
                            condition.await();
                        }
                        System.out.println("Waiter got " + restaurant.meal);
                    } finally {
                        lock.unlock();
                    }
                    restaurant.chef.lock.lock();
                    try {
                        restaurant.meal = null;
                        restaurant.chef.condition.signal();
                    }finally {
                        restaurant.chef.lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("WaitPerson interrupted");
            }
        }
    }

    static class Chef implements Runnable {
        private Restaurant restaurant;
        private int count = 0;
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public Chef(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    lock.lock();
                    try {
                        while (restaurant.meal != null) {
                            condition.await();
                        }
                    }finally {
                        lock.unlock();
                    }
                    if (++count == 10) {
                        System.out.println("Out of food. Closing.");
                        restaurant.exec.shutdownNow();
                    }
                    System.out.print("Order up!  ");
                    restaurant.waitPerson.lock.lock();
                    try {
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.condition.signal();
                    } finally {
                        restaurant.waitPerson.lock.unlock();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Chef interrupted.");
            }
        }
    }
}