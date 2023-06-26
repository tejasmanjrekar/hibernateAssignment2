package courseTodo;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
public class CourseInDBDao implements DaoInterface<Course,Integer>{
	@Override
	public void createNew(Course newCourse) {
		try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSassion = hibernateFctory.openSession();
				){
			Transaction hibernateTransaction = hibernateSassion.beginTransaction();
			hibernateSassion.save(newCourse);
			hibernateTransaction.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override	
	public Collection<Course> getAll() {
	 	Collection <Course> allCourses = new ArrayList<>();
	 	try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSassion = hibernateFctory.openSession();
				){
	 		String hqlQuery = "from Course course";
	 		Query<Course> queryRef = hibernateSassion.createQuery(hqlQuery);
	 		List<Course> courseList = queryRef.list();
	 		for(Course course : courseList)
	 			System.out.println(course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCourses;
	}


	@Override
	public Course getOneById(Integer id) {
		Course foundCourse=null;
		try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSassion = hibernateFctory.openSession();
				){
			Class<Course> courseClass = Course.class;
			Serializable ID = id;
			foundCourse = hibernateSassion.load(courseClass,ID);
			System.out.println(foundCourse);
			}
		  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundCourse;
	}

	@Override
	public void update(Integer id) {
		try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSassion = hibernateFctory.openSession();
				){
			Class<Course> courseClass = Course.class;
			Serializable ID = id;
			Course foundCourse = hibernateSassion.load(courseClass,ID);
			System.out.println("Enter updated cost = ");
			Scanner sc = new Scanner(System.in);
			double cost = sc.nextInt();
			Transaction hibernateTransaction = hibernateSassion.beginTransaction();
			foundCourse.setCost(cost);
			hibernateTransaction.commit();
			System.out.println("Record updated.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSassion = hibernateFctory.openSession();
				){
			Class<Course> courseClass = Course.class;
			Serializable ID = id;
			Course foundCourse = hibernateSassion.load(courseClass,ID);
			
			Transaction hibernateTransaction = hibernateSassion.beginTransaction();
			hibernateSassion.delete(foundCourse);
			hibernateTransaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
