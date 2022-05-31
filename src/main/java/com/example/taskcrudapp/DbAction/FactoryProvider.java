package com.example.taskcrudapp.DbAction;


import com.example.taskcrudapp.modal.Task;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class FactoryProvider {
    private  static SessionFactory sessionFactory=null;
    private static ServiceRegistry serviceRegistry=null;

        public static SessionFactory getFactory(){
            Configuration configuration = new Configuration();
            if (sessionFactory == null)
            {
                sessionFactory=configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Task.class).buildSessionFactory();
            }
            return sessionFactory;
        }
        public void closeFactory()
        {
            if (sessionFactory.isOpen())
                sessionFactory.close();
        }


}
