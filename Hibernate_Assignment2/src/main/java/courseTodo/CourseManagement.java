package courseTodo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.ExceptionConverterImpl;
import org.hibernate.query.Query;
public class CourseManagement {
	public static void getHighCostCourses() {
		try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSession = hibernateFctory.openSession();
				){
			String hqlQuery = "select new management.CourseNameAndProvider(c.courseTitle, c.courseProvider) from Course c where cost>1500";
			Query<CourseNameAndProvider> queryRef = hibernateSession.createQuery(hqlQuery);
			List<CourseNameAndProvider> courseList = queryRef.list();
			for(CourseNameAndProvider nameAndProvider : courseList)
				System.out.println("High cost courses name = "+nameAndProvider.getCourseTitle()+" and provider = "+nameAndProvider.getCourseProvider());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void getLongDurationCourses() {
		try(
				SessionFactory hibernateFctory = HibernateUtils.getSessionFactory();
				Session hibernateSession = hibernateFctory.openSession();
				){
			String hqlQuery = "select c.title from Course c where c.duration>200";
			Query<String> queryRef = hibernateSession.createQuery(hqlQuery); 
			List<String> titleList = queryRef.list();
			for(String title : titleList)
				System.out.println("Long duration courses = "+title);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
	CourseProcessor process = new CourseProcessor();
	process.menu();
		getLongDurationCourses();
		//getHighCostCourses();
	}
}
