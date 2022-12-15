package com.example.laboratorywork3.observer;

public interface Observable {
    void registerObserver(Observer o);
    void notifyObservers(String message);
}
