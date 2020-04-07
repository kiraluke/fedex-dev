package com.ascending.repository;

import com.ascending.model.Pack;
import com.ascending.model.User;
import com.ascending.model.Routing;
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
public class RoutingDaoImpl implements RoutingDao {
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public List<Routing> getRoutings() {
        String hql = "FROM Routing";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Routing> query = session.createQuery(hql);
            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

    @Override
    public Routing save(Routing routing) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(routing);
            transaction.commit();
            return routing;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Routing update(Routing routing) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(routing);
            transaction.commit();
            return routing;
        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Routing routing) {
        String hql = "DELETE Routing";
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

    @Override
    public Routing getRoutingByPirority(String pirority) {
        if (pirority == null) return null;
        String hql = "FROM Routing as rout left join fetch rout.packs where lower(rout.pirority) = :routName2";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("routName2", pirority.toLowerCase());
            return (Routing) query.uniqueResult();
        }
    }

    @Override
    public List<Pack> getRoutingAndPack(String pirority) {
        if(pirority == null) return null;
        String hql = "FROM Routing as rout left join fetch rout.packs where lower(rout.pirority) = :routName3";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("routName3",pirority.toLowerCase());

            List<Pack> resultList = query.list();
            return resultList;
        }
    }
    @Override
    public boolean deleteBy(String pirority) {
        String hql = "DELETE Routing where name = :routName1";
        int deletedCount = 0;
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<Routing> query = session.createQuery(hql);
            query.setParameter("routName1",pirority);
            deletedCount = query.executeUpdate();

        }
        catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The route %s was deleted",pirority));
        return deletedCount >=1 ? true : false;
    }
}
