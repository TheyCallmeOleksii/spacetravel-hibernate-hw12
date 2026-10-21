package org.example.dao;

import org.example.HibernateUtil;
import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetDaoServiceImpl implements PlanetDaoService {

    @Override
    public void create(Planet planet) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Помилка при створенні планети", e);
        }
    }

    @Override
    public Planet getById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    @Override
    public void update(Planet planet) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(planet);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Помилка при оновленні планети", e);
        }
    }

    @Override
    public void delete(Planet planet) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(planet);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Помилка при видаленні планети", e);
        }
    }
}