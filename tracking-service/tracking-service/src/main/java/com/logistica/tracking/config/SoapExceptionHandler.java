package com.logistica.tracking.config;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import com.logistica.tracking.model.exception.PackageNotFoundException;
import com.logistica.tracking.model.response.TrackingError;

public class SoapExceptionHandler extends SoapFaultMappingExceptionResolver {

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        if (ex instanceof PackageNotFoundException) {
            TrackingError error = new TrackingError();
            error.setErrorCode(404);
            error.setErrorMessage(ex.getMessage());
            error.setInvalidField("trackingNumber");
            
            QName faultCode = new QName("http://logistica.com/ws/tracking", "TrackingError");
            fault.addFaultDetail().addFaultDetailElement(faultCode).addText(error.toString());
        }
    }
}