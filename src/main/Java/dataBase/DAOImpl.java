package dataBase;


import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;


public class DAOImpl<T> implements DAO<T> {
    private Transaction transaction = null;

    @Override
    public T getUserById(Class<T> type, int userId) {
        T user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.get(type, userId);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return user;
    }

    @Override
    public boolean creat(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(entity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
   /*   public T getUserById(Id id) {
        T entity = null;
     try(Session session = HibernateUtil.getSessionFactory().openSession()) {
         entity = session.get(id);
     }catch (Exception e) {
         if (transaction != null) {
             transaction.rollback();
         }
         e.printStackTrace();

     }
        return entity;
    }
*/

    //test method
    public List<T> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<T>) session.createQuery("from domain.T ").list();
        }

    }

}
