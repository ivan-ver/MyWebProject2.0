package system.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import system.entity.Detail;

import java.util.List;

public class DAOimpl implements DAO {
    public final Session session;

    @Autowired
    public DAOimpl(Session sessionFactory) {
        this.session = sessionFactory;
        session.beginTransaction();
    }

    @Override
    public void addDetail(Detail detail) {
        session.save(detail);
    }

    @Override
    public void deleteDetail(Integer id) {
        Detail detail = (Detail) session.load(Detail.class,id);
        session.delete(detail);
    }

    @Override
    public void updateDetail(Detail detail) {
        session.merge("Detail",detail);
    }

    @Override
    public Detail getById(Integer id) {
        return (Detail) session.get(Detail.class,id);
    }

    public List<Detail> findAll() {
        return session.createQuery("FROM Detail").list();
    }
}
