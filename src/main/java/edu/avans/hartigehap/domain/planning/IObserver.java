package edu.avans.hartigehap.domain.planning;

/**
 * Created by Mark on 9-3-2015.
 */
public interface IObserver {
    public abstract void update (Employee employee, Employee supervisor, String subject, String message);
}
