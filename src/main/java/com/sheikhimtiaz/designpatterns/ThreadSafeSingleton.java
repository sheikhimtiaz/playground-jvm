package com.sheikhimtiaz.designpatterns;

import java.io.Serializable;

public class ThreadSafeSingleton implements Serializable, Cloneable{
    // initialize the instance as null.
    private static ThreadSafeSingleton instance = null;

    // private constructor, so it cannot be instantiated outside this class.
    private ThreadSafeSingleton() {  }

    // check if the instance is null, within a synchronized block. If so, create the object
    // double locking is used to reduce the overhead of the synchronized method
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // This method is called during deserialization to return the existing instance.
    public Object readResolve() {
        return instance;
    }

    // Prevent cloning by throwing CloneNotSupportedException.
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}