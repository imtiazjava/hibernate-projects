package com.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.main.pojo.Employee;

public class ClientCode {

	public static void main(String[] args) throws IOException {
		//Step1: Create the Configuration object
	    Configuration cfg=new Configuration();
	    System.out.println(cfg);
	    //Step2: Invoke the configure method
	    //In order to load the hibernate configuration file
	     cfg.configure();//It is reading hibernate.cfg.xml file and employee.hbm.xml file and storing in configuration object
	     //Step3: Get the SessionFactory Object
	     SessionFactory sf = cfg.buildSessionFactory();
	     //Step4: Get the Session Object (FLC)
	     Session session = sf.openSession();
	     //Step5: Get the Transaction object(Insert,update,delete)
	     Transaction tx =session.beginTransaction();
	     
	     //Step6: Create Object for POJO class and store the data
	     Employee emp=new Employee(1002, "RAMESH", 80000);
	     
	     //Step7: Invoke the save method
	      session.save(emp);
	      //System.out.println(session.contains(emp));
	      //Step8: Commit the transaction
	     tx.commit();
	     //Step9: Close the Session object and SessionFactory object
	    session.close();
	    sf.close();

	}

}
