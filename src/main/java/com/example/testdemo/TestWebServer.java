package com.example.testdemo;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;

import java.io.IOException;
import java.util.Set;

public class TestWebServer {

    public static Tomcat getTomcat() {
        Tomcat tomcat = new Tomcat();
        System.out.println(tomcat.getHost());
        return tomcat;

    }

    @Test
    public void test() throws Exception {

    }

    class MyTomcatStarter implements ServletContainerInitializer {

        @Override
        public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
//            servletContext.addServlet()
        }
    }

    class MyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("myget");
            super.doGet(req, resp);
        }
    }

    public static void main(String[] args) throws Exception {
        HttpServlet httpServlet = new HttpServlet() {
            @Override
            public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
                res.getWriter().write("my tomcat");
            }
        };
        Tomcat tomcat = new Tomcat();  //嵌入式Tomcat
        tomcat.getConnector();
        Context context = tomcat.addContext("/demo",null);
        tomcat.addServlet(context,"hello",httpServlet);
        context.addServletMappingDecoded("/hello","hello");
        tomcat.start();
        tomcat.getServer().await();//用于阻塞Tomcat,等待请求过来
    }

    @Test
    public void test2() throws Exception {
        Tomcat tomcat = getTomcat();
        tomcat.setPort(8080);
        tomcat.start();
        tomcat.getServer().await();
    }
}
