package com.MainApp;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.Model.Developer;
import com.Model.Employee;
import com.Model.SalesPerson;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Properties p = new Properties();
    	p.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
    	p.put(Environment.URL, "jdbc:mysql://localhost:3306/seed");
    	p.put(Environment.USER, "root");
    	p.put(Environment.PASS,"");
    	
    	p.put(Environment.SHOW_SQL, true);
    	p.put(Environment.HBM2DDL_AUTO, "update");
    	
    	
    	Configuration cfg = new Configuration();
    	cfg.setProperties(p);
    	
    	cfg.addAnnotatedClass(Employee.class);
    	cfg.addAnnotatedClass(Developer.class);
    	cfg.addAnnotatedClass(SalesPerson.class);
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session s = sf.openSession();
    	Transaction t = s.beginTransaction();
    	
    	Developer d = new Developer();
    	d.setId(101);
    	d.setName("Ram");
    	d.setSalary(45000);
    	d.setTech("Back-end");
    	d.setProject("E-Commerce");	
    	s.save(d);
    	t.commit();
    	
    	
//    	SalesPerson sp = new SalesPerson();
//    	sp.setId(102);
//    	sp.setName("Shaym");
//    	sp.setSalary(4300);
//    	sp.setClient("xyz");
//    	sp.setTarget("1 Lakh");
//    	s.save(sp);
//    	t.commit();
    	
    	//Read 
//    	Developer d = s.get(Developer.class, 101);
//    	System.out.println(d.getId());
//    	System.out.println(d.getName());
//    	System.out.println(d.getSalary());
//    	System.out.println(d.getTech());
//    	System.out.println(d.getProject());
    	
    	//update
//    	Developer d = s.get(Developer.class,101);
//    	d.setName("devesh");
//    	d.setSalary(4567);
//    	d.setTech("Front-end");
//    	s.update(d);
//    	t.commit();
    }
}
