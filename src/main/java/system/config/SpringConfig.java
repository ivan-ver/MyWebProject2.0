package system.config;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import system.dao.DAO;
import system.dao.DAOimpl;
import system.dao.HibernateSessionFactory;
import system.service.AppService;
import system.service.AppServiceImpl;

@Configuration
public class SpringConfig {

    @Bean
    public Session getSession(){
        HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();
        return hibernateSessionFactory.getSession();
    }
    @Bean
    public DAO getDAO(){
        return new DAOimpl(getSession());
    }
    @Bean
    public AppService getAppService(){
        return new AppServiceImpl();
    }
}
