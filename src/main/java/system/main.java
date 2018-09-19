package system;

import org.hibernate.Session;
import system.dao.DAO;
import system.dao.DAOimpl;
import system.dao.HibernateSessionFactory;
import system.entity.Detail;
import system.entity.Type;
import system.service.AppService;
import system.service.AppServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class main {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();
        List<Detail> det = session.createQuery("from Detail").list();
        //det.stream().forEach(x -> System.out.println(x));
        Detail d = session.get(Detail.class,2);
        d.setName("rrrrrrrrrr");
        session.update(d);

    }



}

