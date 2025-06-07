package com.logistica.tracking.config;

import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.logistica.tracking.model.exception.PackageNotFoundException;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "tracking")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema trackingSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PackageTrackingPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://logistica.com/ws/tracking");
        wsdl11Definition.setSchema(trackingSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema trackingSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/tracking.xsd"));
    }

    @Bean
public SoapExceptionHandler exceptionHandler() {
    SoapExceptionHandler exceptionHandler = new SoapExceptionHandler();
    
    SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
    faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
    exceptionHandler.setDefaultFault(faultDefinition);
    
    Properties errorMappings = new Properties();
    errorMappings.setProperty(PackageNotFoundException.class.getName(), "SERVER,Paquete no encontrado");
    exceptionHandler.setExceptionMappings(errorMappings);
    exceptionHandler.setOrder(1);
    
    return exceptionHandler;
}
}