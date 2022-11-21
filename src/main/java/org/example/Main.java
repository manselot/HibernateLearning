package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main( String[] args ) {
        Car camri = new Car();
        camri.setName("camri 3.5");
        camri.setMaxSpeed(228);

        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(Car.class);
        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());

        SessionFactory sf = cfg.buildSessionFactory(sBuilder.build());
        //create
        Session sessionCreate = sf.openSession();
        Transaction Ttcreate = sessionCreate.beginTransaction();
        sessionCreate.save(camri);
        Ttcreate.commit();
        sessionCreate.close();
        //read
        Session SessionRead = sf.openSession();
        Transaction TtRead = SessionRead.beginTransaction();
        Car toyata = SessionRead.find(Car.class,5);
        System.out.println(toyata.toString());
        TtRead.commit();
        SessionRead.close();
        //update
        Session sessionUpdate = sf.openSession();
        Transaction TtUpdate = sessionUpdate.beginTransaction();
        Car car = sessionUpdate.find(Car.class,6);
        car.setName("abobaMobile");
        car.setMaxSpeed(332);
        sessionUpdate.update(car);
        TtUpdate.commit();
        sessionUpdate.close();
        //delete
        Session SessionDelete = sf.openSession();
        Transaction TtDelete = SessionDelete.beginTransaction();
        SessionDelete.delete(car);
        TtDelete.commit();
        SessionDelete.close();





    }
}
