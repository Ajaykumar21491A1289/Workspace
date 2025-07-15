package com.jocata.warranty_system.Dao.impl;

import com.jocata.warranty_system.Dao.CarWarrantiesDao;
import com.jocata.warranty_system.entity.CarModels;
import com.jocata.warranty_system.entity.CarWarranties;
import com.jocata.warranty_system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CarrWarrantiesDaoImpl implements CarWarrantiesDao {
    @Override
    public CarWarranties addCarWarranties(CarWarranties entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(entity);
        tx.commit();
        session.close();
        return entity;
    }

    @Override
    public List<CarWarranties> getCarWarranties(Integer carSaleId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();


        List<CarWarranties> warranties = session.createQuery("FROM CarWarranties cw WHERE cw.carSales.carSaleId = :carSaleId ORDER BY cw.carWarrantyId DESC",
                CarWarranties.class)
.setParameter("carSaleId", carSaleId)
.list();


        tx.commit();
        session.close();
        return warranties;
    }



}
