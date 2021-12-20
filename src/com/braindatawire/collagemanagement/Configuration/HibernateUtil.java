package com.braindatawire.collagemanagement.Configuration;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.braindatawire.collagemanagement.model.Batch;
import com.braindatawire.collagemanagement.model.Course;
import com.braindatawire.collagemanagement.model.Faculty;
import com.braindatawire.collagemanagement.model.Student;


public class HibernateUtil 
{
	static SessionFactory sf;
	
	public static SessionFactory getSessionFactory()
	{
		
		try
		{
			Map<String, Object> settings = new HashMap<>();
			
			//connection Properties
			settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Collage_Management");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			//Hibernate Properties
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.SHOW_SQL, true);
			
			StandardServiceRegistryBuilder ssrb= new StandardServiceRegistryBuilder();
			ssrb.applySettings(settings);
			StandardServiceRegistry ssRegistry=	ssrb.build();
			MetadataSources mds= new MetadataSources(ssRegistry);
			mds.addAnnotatedClass(Batch.class);
			mds.addAnnotatedClass(Course.class);
			mds.addAnnotatedClass(Faculty.class);
			mds.addAnnotatedClass(Student.class);
			MetadataBuilder mdb= mds.getMetadataBuilder();
			Metadata md= mdb.build();
			
			sf=md.getSessionFactoryBuilder().build();
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sf;
	}
}
