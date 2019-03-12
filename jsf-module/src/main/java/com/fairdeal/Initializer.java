//package com.fairdeal;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//import org.springframework.boot.web.servlet.ServletContextInitializer;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Initializer implements ServletContextInitializer {
//
//  @Override
//  public void onStartup(ServletContext sc) throws ServletException {
//    sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
//    sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
//    //sc.addFilter("PrimeFaces FileUpload Filter", org.primefaces.webapp.filter.FileUploadFilter.class);
//    
//    //sc.setInitParameter("contextConfigLocation", "/WEB-INF/spring/servlet-context.xml");
//    //sc.addListener(org.apache.myfaces.webapp.StartupServletContextListener.class);
//    //sc.addListener("org.springframework.web.context.request.RequestContextListener");
//  }
//}
