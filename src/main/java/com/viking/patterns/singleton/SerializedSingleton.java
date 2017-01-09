package com.viking.patterns.singleton;

import java.io.Serializable;

/**
 *
 * Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that
 * we can store it’s state in file system and retrieve it at later point of time.
 */
public class SerializedSingleton implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}
    
    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }
    
    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }

    protected Object readResolve() {
        return getInstance();
    }
    
}