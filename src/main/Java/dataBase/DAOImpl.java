package dataBase;


import domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;


public class DAOImpl implements DAO {
    private Transaction transaction = null;

    public User getUserById(long userId) {
        User user = null;
     try(Session session = HibernateUtil.getSessionFactory().openSession()) {
         user = session.get(User.class,userId);
     }catch (Exception e) {
         if (transaction != null) {
             transaction.rollback();
         }
         e.printStackTrace();

     }
        return user;
    }

    @Override
    public boolean creat(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(user);
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
    public boolean delete(User user) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();

        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User user) {
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
           transaction = session.beginTransaction();
           session.update(user);
           transaction.commit();

       }catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           e.printStackTrace();
           return false;
       }
        return true;
    }

    //test method
    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (List<User>) session.createQuery("from domain.User ").list();
        }

    }

}
