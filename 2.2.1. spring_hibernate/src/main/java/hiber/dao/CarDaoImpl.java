package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
    @Override
    public Object getUser(String model, int serial){
        try(Session ses = sessionFactory.openSession()) {
            Transaction tx = ses.beginTransaction();
            Query query = ses.createQuery(" from User where id = (select id from Car where model = :model and serial = :serial)");
            query.setParameter("model", model);
            query.setParameter("serial", serial);
            return query.getSingleResult();
        }
//        }catch (Exception e){
//            System.out.println(" Не вышло не получилось");
//        }
//        return null;
    }
}
