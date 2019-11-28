package service;



public interface Service<T> {
    T getUserById(Class<T> type,int userId);
    boolean creat(T entity);
    boolean delete(T entity);
    boolean update(T entity);
}
