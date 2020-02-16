package com.ascending.repository;

import com.ascending.model.Recipient;
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
public class RecipientDaoImpl implements RecipientDao {
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Recipient> getRecipients() {
        String hql = "FROM Recipient";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Recipient> query = session.createQuery(hql);
            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

    public Recipient save(Recipient recipient) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(recipient);
            transaction.commit();
            return recipient;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Recipient recipient) {
        String hql = "DELETE Recipient";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Recipient> query = session.createQuery(hql);
            deletedCount = query.executeUpdate();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The route %s was deleted"));
        return deletedCount >=1 ? true : false;
    }

    public Recipient update(Recipient recipient){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(recipient);
            transaction.commit();
            return recipient;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Recipient> getRecipientsAndPacksBy(String recipientName) {
        if(recipientName == null)return null;
        String hql = "FROM Recipient as recp left join fetch recp.pack where lower(recp.name) = :recipientName1";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery(hql);
            query.setParameter("recipientName1",recipientName.toLowerCase());

            List<Recipient> resultList = query.list();
            return resultList;
        }
    }

    @Override
    public Recipient getRecipientByName(String recipientName) {
        if(recipientName == null) return null;
        String hql = "FROM Recipient as recp left join fetch recp.pack where lower(recp.name) = :recipientName2";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("recipientName2", recipientName.toLowerCase());

            return (Recipient) query.uniqueResult();
        }
    }

    public boolean deleteBy(String recipientName) {
        String hql = "DELETE Recipient as recp where name = :recipientName3";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Recipient> query = session.createQuery(hql);
            query.setParameter("recipientName3", recipientName);
            deletedCount = query.executeUpdate();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The route %s was deleted",recipientName));
        return deletedCount >=1 ? true : false;
    }

}
