package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Uther on 2016/4/9.
 */
public class Dao {
    public static SessionFactory sf = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.out.println("创建SessionFactory时出错！" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static final ThreadLocal session = new ThreadLocal();
    private static final Logger log = Logger.getAnonymousLogger();

    public static Session getSession() {
        Session session = (Session) Dao.session.get();
        if (session == null) {
            session = sf.openSession();
            Dao.session.set(session);
        }
        return session;
    }

    public void begin() {
        getSession().beginTransaction();
    }

    // ppt screen code log dev-doc

    public void commit() {
        getSession().getTransaction().commit();
        close();
    }

    public void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "can not rollback", e);
        }

        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "can not close", e);
        }
        Dao.session.set(null);
    }

    public static void close() {
        getSession().close();
        Dao.session.set(null);
    }

    public void save(Object o) {
        try {
            begin();
            getSession().save(o);
            commit();
        } catch (HibernateException e) {
            rollback();
            log.log(Level.WARNING, "can not save object", e);
        }
    }

    public void delete(Object o) {
        try {
            begin();
            getSession().delete(o);
            commit();
        } catch (HibernateException e) {
            rollback();
            log.log(Level.WARNING, "can not delete object", e);
        }
    }

    public void update(Object o) {
        try {
            begin();
            getSession().update(o);
            commit();
        } catch (HibernateException e) {
            rollback();
            log.log(Level.WARNING, "can not update object", e);
        }
    }
}
