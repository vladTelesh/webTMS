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
        if(dao.creat(user)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        dao = new DAOImpl();
        if(dao.delete(id)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(User user, long id) {
        dao = new DAOImpl();
        if(dao.update(user,id)){
            return true;
        }else {
            return false;
        }
    }
}
