package dataBase;


import domain.User;

public interface DAO {
    User getUserById(long userId);
    boolean creat(User user);
    boolean delete(User user);
    boolean update(User user);
}
