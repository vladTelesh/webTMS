package service;


import dataBase.DAO;
import dataBase.DAOImpl;


public class ServiceImpl<T> implements Service<T> {
    DAO<T> dao;

    @Override
    public T getUserById(Class<T> type,int userId) {
        dao = new DAOImpl<>();
        return dao.getUserById(type,userId);
    }

    @Override
    public boolean creat(T entity) {
        dao = new DAOImpl<>();
        return dao.creat(entity);
    }

    @Override
    public boolean delete(T entity) {
        dao = new DAOImpl<>();
        return dao.delete(entity);
    }

    @Override
    public boolean update(T entity) {
        dao = new DAOImpl<>();
        return   dao.update(entity);
    }


    /* @Override
    public User getUserById(long userId) {
        dao = new DAOImpl();
        return dao.getUserById(userId);
    }*/

}
