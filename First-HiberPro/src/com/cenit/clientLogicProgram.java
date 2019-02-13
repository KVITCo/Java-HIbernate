package com.cenit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class clientLogicProgram {

	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf=conf.buildSessionFactory();
		Session ss1=sf.openSession();
		
		Product p=null;        //P is transistient state
		Object o=ss1.get(Product.class,new Integer(101));
		p=(Product) o;         //now P is Persistient state
		
		ss1.close();
		
		p.setPrice(36000);       // p is in Detached state
		
		Session ss2=sf.openSession();
		Transaction tx=ss2.beginTransaction();
		
		ss2.update(p);           // now p reached to Persistent state
		
		tx.commit();
		
		ss2.close();
		
		sf.close();
	}

}
