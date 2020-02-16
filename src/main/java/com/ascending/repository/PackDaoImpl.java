package com.ascending.repository;

import com.ascending.model.Pack;
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
public class PackDaoImpl implements PackDao {
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Pack> getPacks() {
        String hql = "FROM Pack";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Pack> query = session.createQuery(hql);
            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

    @Override
    public Pack save(Pack pack) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(pack);
            transaction.commit();
            return pack;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Pack update(Pack pack) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(pack);
            transaction.commit();
            return pack;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteBy(String destination) {
        String hql = "DELETE Pack where name = :pack1";
        int deletedCount = 0;
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<Pack> query = session.createQuery(hql);
            query.setParameter("pack1",destination);
            deletedCount = query.executeUpdate();
//            Pack pack = getPackByDestination(destination);
//            sesssion.delete(pack);
//            transaction.commit();
//            deletedCount = 1;
            return true;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The package %s was deleted",destination));
        return deletedCount>=1 ? true : false;
    }

    @Override
    public boolean delete(Pack pack) {
        String hql = "DELETE Pack";
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
        logger.debug(String.format("The packages %s was deleted"));
        return deletedCount >=1 ? true : false;
    }

}
