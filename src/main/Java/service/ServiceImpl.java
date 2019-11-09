package service;


import dataBase.DAO;
import dataBase.DAOImpl;
import domain.User;

public class ServiceImpl implements Service {
    DAO dao;


    @Override
    public User getUserById(long userId) {
        dao = new DAOImpl();
        return dao.getUserById(userId);
    }

    @Override
    public boolean creat(User user) {
        dao = new DAOImpl();
        return dao.creat(user);

    }

    @Override
    public boolean delete(User user) {
        dao = new DAOImpl();
        return dao.delete(user);

    }

    @Override
    public boolean update(User user) {
        dao = new DAOImpl();
        return   dao.update(user);
    }
}
