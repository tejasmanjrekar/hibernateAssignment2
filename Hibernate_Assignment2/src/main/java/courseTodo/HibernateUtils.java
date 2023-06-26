package courseTodo;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		hibernateProperties.put(Environment.URL, "jdbc:mysql://localhost:3306/navimumbai?useSSL=false");
		hibernateProperties.put(Environment.USER, "tejas");
		hibernateProperties.put(Environment.PASS, "tejasm");
		hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		hibernateProperties.put(Environment.SHOW_SQL, "true");
		hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");
		
		Configuration conf = new Configuration();
		conf.setProperties(hibernateProperties);
		
		Class<Course> entityClass = Course.class;
		conf.addAnnotatedClass(entityClass);
		
		SessionFactory hibernateFactory = conf.buildSessionFactory();
		return hibernateFactory;
	}
}
