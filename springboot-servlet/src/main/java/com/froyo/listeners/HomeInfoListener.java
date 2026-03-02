package com.froyo.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HomeInfoListener implements ServletContextListener {

    private static final Logger log = LogManager.getLogger(HomeInfoListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("ServletContextEvent initialized.");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("user", "[USUARIO]");
        sc.setAttribute("name", "[NOMBRE DEL USUARIO]");
        sc.setAttribute("dato", "éste dato es obtenido desde la clase @WebListener (HomeInfoListener) ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.removeAttribute("user");
        sc.removeAttribute("name");
        sc.removeAttribute("dato");
        log.info("ServletContextEvent destroyed.");
    }
}

