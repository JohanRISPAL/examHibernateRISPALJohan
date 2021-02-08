package services;

import models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class CarService {

    private SessionFactory sessionFactory;

    public CarService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List getMarque() {
        Session session = this.sessionFactory.getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Car c GROUP BY marque";

        Query query = session.createQuery(hql);

        List marques = query.getResultList();

        session.close();

        return marques;
    }

    public Integer getNumberOfCarsByMarque(String marque){
        Integer nbCars = 0;

        Session session = this.sessionFactory.getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Car c WHERE marque = :marque";

        Query query = session.createQuery(hql);
        query.setParameter("marque", marque);

        List cars = query.getResultList();

        for (Integer i = 0; i < cars.size(); i++){
            nbCars++;
        }

        session.close();
        return nbCars;
    }


    public Integer getNumberOfCars(){
        Integer nbCars = 0;

        Session session = this.sessionFactory.getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Car c";

        Query query = session.createQuery(hql);

        List cars = query.getResultList();

        for (Integer i = 0; i < cars.size(); i++){
            nbCars++;
        }

        session.close();
        return nbCars;
    }

    public List getTenLastCarAdded(){
        Session session = this.sessionFactory.getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Car c ORDER BY id DESC";

        Query query = session.createQuery(hql);
        query.setMaxResults(10);

        List cars = query.getResultList();

        session.close();

        return cars;
    }
}
