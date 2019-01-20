package ru.job4j.tracker;
/**
 *  Class
 *  @author Buryachenko
 *  @since 20.01.2019
 *  @version 1
 */
public class MenuOutException extends RuntimeException {
    
    public MenuOutException(String error) {
        super(error);
    }
}
