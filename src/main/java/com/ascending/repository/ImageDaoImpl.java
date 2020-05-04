package com.ascending.repository;

import com.ascending.model.Image;
import com.ascending.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl implements ImageDao {
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Image save(Image image) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(image);
            transaction.commit();
            return image;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
            return null;
        }
    }
}
