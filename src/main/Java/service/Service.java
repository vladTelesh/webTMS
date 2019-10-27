package service;

import domain.User;


public interface Service {
    User getUserById(long userId);
    boolean creat(User user);
    boolean delete(long id);
    boolean update(User user,long id);
}
