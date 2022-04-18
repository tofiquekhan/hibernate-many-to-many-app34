package myproject.manytomany.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import myproject.manytomany.entity.Course;
import myproject.manytomany.entity.Student;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/myproject/manytomany/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = cfg.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Course c1 = new Course();
			c1.setCid("C-111");
			c1.setCname("C");
			c1.setCcost(1000);
			
			Course c2 = new Course();
			c2.setCid("C-222");
			c2.setCname("C++");
			c2.setCcost(2000);
			
			Course c3 = new Course();
			c3.setCid("C-333");
			c3.setCname("Java");
			c3.setCcost(3000);
			
			Set<Course> courses = new HashSet<Course>();
			courses.add(c1);
			courses.add(c2);
			courses.add(c3);
			
			Student s1 = new Student();
			s1.setSid("S-111");
			s1.setSname("AAA");
			s1.setSaddr("Indore");
			s1.setCourses(courses);
			
			Student s2 = new Student();
			s2.setSid("S-222");
			s2.setSname("BBB");
			s2.setSaddr("Bhopal");
			s2.setCourses(courses);
			
			Student s3 = new Student();
			s3.setSid("S-333");
			s3.setSname("CCC");
			s3.setSaddr("Mumbai");
			s3.setCourses(courses);
			
			String pk1 = (String) session.save(s1);
			String pk2 = (String)session.save(s2);
			String pk3 =(String)session.save(s3);
			tx.commit();
			System.out.println(pk1+" "+pk2+" "+pk3);
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
