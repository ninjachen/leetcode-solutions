package rocks.ninjachen.other.concurrence;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A simple producer and consumer case
 */
public class RestaurantTest {

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

        public WaitPerson(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (restaurant.meal == null) {
                            wait();
                        }
                        System.out.println("Waiter got " + restaurant.meal);
                    }
                    synchronized (restaurant.chef) {
                        restaurant.meal = null;
                        restaurant.chef.notify();
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

        public Chef(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (restaurant.meal != null) {
                            wait();
                        }
                    }
                    if (++count == 10) {
                        System.out.println("Out of food. Closing.");
                        restaurant.exec.shutdownNow();
                    }
                    System.out.print("Order up!  ");
                    synchronized (restaurant.waitPerson) {
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.notify();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Chef interrupted.");
            }
        }
    }
}