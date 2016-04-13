package br.pi.boalista.Modelo.Dao;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DaoManagerHiber {
    private static DaoManagerHiber myself = null;
    
    private SessionFactory sessionFactory;
    private Session s;

    private DaoManagerHiber(){

    try{

        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
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
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
            
        
         
            
        
        s.save(o);
        
        tr.commit();
        
        s.flush();
    }
    
    public Object recover(Class classe, Long id){
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
         
        Object registroRecuperado = s.get(classe, id);
        //Query query = s.createQuery(hql);
        
        s.flush();
        return registroRecuperado;
        //return query.list();
    }
    
    public List recoverSQL(String sql){
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
         
        
        Query query = s.createSQLQuery(sql);
        
        s.flush();
        
        return query.list();
    }
    
    public List recover(Object o){
        
        Criteria c = s.createCriteria(o.getClass());
        
        c.add(Example.create(o).enableLike(MatchMode.ANYWHERE).ignoreCase().excludeProperty("codigo"));
        
        List l = c.list();
        s.flush();
        
        return l;
    }
    
    public void update(Object o){
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
         
        
        s.update(o);
        
        tr.commit();
        
        s.flush();
    }
    
     public List recoverAll(String hql){
        Transaction tr = null;
        try{
           
            s = sessionFactory.openSession();
            tr = s.beginTransaction();  
        }catch(org.hibernate.exception.JDBCConnectionException ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();  
        }
         
        
        Query query = s.createQuery(hql);
        
        s.flush();
        
        return query.list();
    }
    
    public void delete(Object o){
        Transaction tr = null;
        try{
            s.clear();
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
        }catch(Exception ex){
            s.close();
            s=sessionFactory.openSession();
            tr = s.beginTransaction();
        }
        
        
        s.delete(o);
        
        tr.commit();
        
        s.flush();
    }
    
    public static void main(String args[]){
        SchemaExport se = new SchemaExport(new AnnotationConfiguration().configure());
		se.create(true, true);
                
       
    }
    
}

