package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.CarModelsDao;
import com.jocata.warranty_system.entity.CarModels;
import com.jocata.warranty_system.form.CarModelsReqForm;
import com.jocata.warranty_system.form.CarModelsResForm;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Repository
public class CarModelsDaoImpl implements CarModelsDao {
    @Override
    public CarModels createCarModels(CarModels entity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    public CarModels updateCarModels(CarModels entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarModels carModels = session.merge(entity);
        session.flush();
        session.refresh(carModels);
        tx.commit();
        session.close();
        return carModels;
    }

    public CarModels getCarModels(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CarModels models = session.find(CarModels.class,id);
        tx.commit();
        session.close();
        return models;
    }

    public List<CarModels> getAllCarModels(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<CarModels> models= session.createQuery("FROM CarModels",CarModels.class).getResultList();
        tx.commit();
        session.close();
        return models;

    }

    public String deleteCarModels(CarModels entity){
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
        return "Customer Deleted Successfully";
    }
}
