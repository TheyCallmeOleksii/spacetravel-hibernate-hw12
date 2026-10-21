package org.example.dao;

import org.example.HibernateUtil;
import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDaoServiceImpl implements ClientDaoService {

    @Override
    public void create(Client client) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Помилка при створенні клієнта", e);
        }
    }

    @Override
    public Client getById(Long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    @Override
    public void update(Client client) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Помилка при оновленні клієнта", e);
        }
    }

    @Override
    public void delete(Client client) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Помилка при видаленні клієнта", e);
        }
    }
}