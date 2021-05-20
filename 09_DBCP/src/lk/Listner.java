package lk;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listner implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Was Created");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/kade");
        dataSource.setUsername("root");
        dataSource.setPassword("1023");
        dataSource.setMaxTotal(2);
        dataSource.setInitialSize(2);
        servletContextEvent.getServletContext().setAttribute("ds", dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Was Destroyed");
    }

}
