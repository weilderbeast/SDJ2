package utils.catalog;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Catalog {
    private static Catalog catalog;
    private static Lock lock = new ReentrantLock();

    private Catalog() {

    }

    public static Catalog getInstance() {
        if (catalog == null) {
            synchronized (lock) {
                if (catalog == null)
                    catalog = new Catalog();
            }
        }
        return catalog;
    }

    public void log(String log) {
        System.out.println(log);
    }
}
