package br.pi.boalista.Modelo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Eduardo
 */
public class DaoManagerHiber {
    private static DaoManagerHiber myself = null;
    
    private SessionFactory sessionFactory;
    private Session s;

    private DaoManagerHiber(){

    try{

        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        s = sessionFactory.openSession();
        

    }catch(Throwable th){

        System.err.println("Enitial SessionFactory creation failed"+th);

        throw new ExceptionInInitializerError(th);

    }

  }
    
    public static DaoManagerHiber getInstance(){
        if(myself==null)
            myself = new DaoManagerHiber();
        
        return myself;
    }
  
    public void persist(Object o){
        
        Transaction tr = null;
        
        s.close();
        
        s = sessionFactory.openSession();
        
        tr = s.beginTransaction();
        
        s.save(o);
        
        tr.commit();
        
        //s.close();
    }
    
    public List recover(String hql){
        Transaction tr = null;
        
        s.close();
        
         s = sessionFactory.openSession();
         
         tr = s.beginTransaction();
        
        Query query = s.createQuery(hql);
        
        //s.close();
        
        return query.list();
    }
    
    public List recoverSQL(String sql){
        Transaction tr = null;
        
        s.close();
        
        s = sessionFactory.openSession();
        
        tr = s.beginTransaction();  
        
        Query query = s.createSQLQuery(sql);
        
        return query.list();
    }
    
    public List recover(Object o){
        
        Criteria c = s.createCriteria(o.getClass());
        
        c.add(Example.create(o).enableLike(MatchMode.ANYWHERE).ignoreCase().excludeProperty("codigo"));
        
        List l = c.list();
        s.close();
        
        return l;
    }
    
    public void update(Object o) {
        Transaction tr = null;
        
            s.close();
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        
        
        s.update(o);
        
        //s.close();
        
        tr.commit();
        
        
    }
    
    public void delete(Object o){
        Transaction tr = null;
        
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();
        
        //s.close();
        
        s.delete(o);
        
        tr.commit();
        
        //s.close();
    }
    
    public static void main(String args[]){
        SchemaExport se = new SchemaExport(new AnnotationConfiguration().configure());
		se.create(true, true);
    }
    
}

