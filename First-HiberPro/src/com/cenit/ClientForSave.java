package com.cenit;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientForSave {
	public static void main(String[] args)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		   /*Query qry = session.createQuery("select p.productId from Product p");

				   		List l =qry.list();
				   		System.out.println("Total Number Of Records : "+l.size());
				   		Iterator it = l.iterator();

				   		while(it.hasNext())
				   		{
				   			Integer i = (Integer)it.next();
				   			System.out.println("Product id : "+i.intValue());
				   			System.out.println("---------------------------");

				   		}	*/	
		
		
		Query qry = session.createQuery("from Product p");

		List l =qry.list();
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();

		while(it.hasNext())
		{
			Object o = (Object)it.next();
			Product p = (Product)o;
			System.out.println("Product id : "+p.getProductId());
			System.out.println("Product Name : "+p.getProName());
			System.out.println("Product Price : "+p.getPrice());
			System.out.println("----------------------");
		}		

		
		
		/*Object o=session.load(Product.class,new Integer(104));
		Product p=(Product) o;*/
		
		
		/*Product p=new Product();
		p.setProductId(104);
		p.setProName("Honor");
		p.setPrice(16000);
		Transaction tx = session.beginTransaction();
		session.save(p);*/
		/*Transaction tx = session.beginTransaction();
		//p.setProName("intel");
		p.setPrice(9500);
		//Transaction tx = session.beginTransaction();
		//session.delete(p);
		//System.out.println("Product deleted name is---->"+p);
		System.out.println("Object saved successfully.....!!");
		tx.commit();*/
		
				   		
				   		
				   		
				   		
		session.close();
		factory.close();
	}

}
