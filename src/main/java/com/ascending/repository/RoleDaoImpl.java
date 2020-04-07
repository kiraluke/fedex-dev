package com.ascending.repository;

import com.ascending.model.Role;
import com.ascending.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{
    private SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Role getRoleByName(String name) {
        if(name == null) return null;
        String hql = "FROM Role as r where lower(r.name) = :name";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("name", name.toLowerCase());
            return (Role) query.uniqueResult();
        }
    }
}
