package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws IOException
	{
		System.out.println( "Project started" );
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		System.out.println(factory);
		Student st=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your city Name");
		String cityName=sc.next();
		st.setCity(cityName);
		st.setId(101);
		st.setName("Zeeshan Ali");
		
		System.out.println(st);
		System.out.println("");
		
		Address add=new Address();
		add.setStreet("strret1");
		add.setCity("Bhadohi");
		add.setOpen(true);
		add.setAddedDate(new Date());
		add.setX(13.32);
		//Reading image
		 
		FileInputStream f=new FileInputStream("src/main/java/ZeeshanPic.jpg");
		byte[] data=new byte[f.available()];
		f.read(data);
		add.setImage(data);
		
		 Session session=factory.openSession(); 
		/* Session session=factory.getCurrentSession(); */
		Transaction tx=session.beginTransaction();
		session.save(st);
		session.save(add);
		
		tx.commit();
		
		
		session.close();
		System.out.println("Done");
		
	}
}
