package dataBase;


import domain.User;

public interface DAO {
    User getUserById(long userId);
    boolean creat(User user);
    boolean delete(long id);
    boolean update(User user,long id);
}
