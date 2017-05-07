/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.listeners;

import dasi.web.modelo.Dao;
import dasi.web.modelo.DaoOracle;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Web application lifecycle listener.
 *
 * @author Estela
 */

public class InitializerListener implements ServletContextListener {

    
    @Resource(lookup = "jdbc/cocinita")
    private DataSource dataSource;
     
    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        ServletContext servletContext = sce.getServletContext();
                
          Dao dao = new DaoOracle();
          dao.init(dataSource);
          servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {        
    }
}
