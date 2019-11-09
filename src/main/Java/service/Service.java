package service;

import domain.User;


public interface Service {
    User getUserById(long userId);
    boolean creat(User user);
    boolean delete(User user);
    boolean update(User user);
}
