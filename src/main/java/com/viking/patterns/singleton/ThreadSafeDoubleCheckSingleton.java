package com.viking.patterns.singleton;

/**
 * To avoid this extra overhead every time, double checked locking principle is used.
 * In this approach, the synchronized block is used inside the if condition with an
 * additional check to ensure that only one instance of singleton class is created.
 *
 * Below code snippet provides the double checked locking implementation.
 */
public class ThreadSafeDoubleCheckSingleton {

    private static ThreadSafeDoubleCheckSingleton instance;

    private ThreadSafeDoubleCheckSingleton(){}

    public static ThreadSafeDoubleCheckSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
