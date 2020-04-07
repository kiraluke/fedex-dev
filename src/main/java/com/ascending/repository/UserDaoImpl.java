package com.ascending.repository;

import com.ascending.model.Pack;
import com.ascending.model.User;
import com.ascending.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<User> getUsers() {
        String hql = "FROM User";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<User> query = session.createQuery(hql);
            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

    public User save(User user) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(User user) {
        String hql = "DELETE User";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery(hql);
            deletedCount = query.executeUpdate();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The route %s was deleted"));
        return deletedCount >=1 ? true : false;
    }

    public User update(User user){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pack> getUserInfoAndPacksBy(String userName) {
        if(userName == null) return null;
        String hql = "FROM User as recp left join fetch recp.packs where lower(recp.name) = :userName1";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery(hql);
            query.setParameter("userName1",userName.toLowerCase());

            List<Pack> resultList = query.list();
            return resultList;
        }
    }

    @Override
    public User getUserByName(String userName) {
        if(userName == null) return null;
        String hql = "FROM User as recp left join fetch recp.packs where lower(recp.name) = :userName2";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("userName2", userName.toLowerCase());

            return (User) query.uniqueResult();
        }
    }

    @Override
    public User getUserById(Long Id) {
        String hql = "FROM User as recp where Id = :id1";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("id1", Id);

            return (User) query.uniqueResult();
        }
    }
    @Override
    public boolean deleteBy(String userName) {
        String hql = "DELETE User as recp where name = :userName3";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery(hql);
            query.setParameter("userName3", userName);
            deletedCount = query.executeUpdate();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The route %s was deleted",userName));
        return deletedCount >=1 ? true : false;
    }
    @Override
    public User getUserByCredentials(String email, String password) {
        String hql = "FROM User as u where lower(u.email) = :email and u.password = :password";
        logger.debug(String.format("User email: %s, password: %s", email, password));

        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase().trim());
            query.setParameter("password", password);

            return query.uniqueResult();
        }
    }

}
