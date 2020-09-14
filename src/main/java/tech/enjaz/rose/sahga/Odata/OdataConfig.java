package tech.enjaz.rose.sahga.Odata;

import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
class OdataConfig {

    static final String NAMESPACE = "tech.enjaz.rose.sahga.entity";
    static final String SERVICE_URL = "/odata/v2/";

    @Bean
    ServletRegistrationBean<Servlet> odataServlet(EntityManagerFactory emf) {
        JpaOdataServiceFactory jpaOdataServiceFactory = new JpaOdataServiceFactory(emf, NAMESPACE);
        return new ServletRegistrationBean<>(
                (Servlet) new JpaODataServlet(jpaOdataServiceFactory), SERVICE_URL + "*");
    }


    static class JpaODataServlet extends ODataServlet {
        private final JpaOdataServiceFactory jpaOdataServiceFactory;

        public JpaODataServlet(JpaOdataServiceFactory jpaOdataServiceFactory) {
            this.jpaOdataServiceFactory = jpaOdataServiceFactory;

        }

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            req.setAttribute(ODataServiceFactory.FACTORY_INSTANCE_LABEL, jpaOdataServiceFactory);
            super.service(req, resp);
        }
    }
}
