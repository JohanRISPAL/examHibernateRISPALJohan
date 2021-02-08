package services;

import org.hibernate.SessionFactory;
import utils.HibernateUtil;

public class ColorService {

    private SessionFactory sessionFactory;

    public ColorService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
}
