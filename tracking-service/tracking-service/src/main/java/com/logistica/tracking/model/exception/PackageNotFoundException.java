package com.logistica.tracking.model.exception;

public class PackageNotFoundException extends RuntimeException {
    public PackageNotFoundException(String trackingNumber) {
        super("Paquete con número de tracking " + trackingNumber + " no encontrado");
    }
}