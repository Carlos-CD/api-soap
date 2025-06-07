# Servicio SOAP para Seguimiento de Paquetes - EnvíosExpress S.A.C.

[![Java](https://img.shields.io/badge/Java-17-blue.svg)]()  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green.svg)]()  
[![SOAP](https://img.shields.io/badge/Protocol-SOAP-orange.svg)]()  

Servicio web SOAP para consultar el estado de paquetes mediante número de tracking.

## Características Principales

- Consulta de estado de paquetes por número de tracking  
- Información detallada del paquete (estado, ubicación, fecha estimada de entrega)  
- Historial completo de eventos del paquete  
- Manejo estandarizado de errores  
- Documentación WSDL automática  

## Requisitos

- Java 17  
- Maven 3.8+  
- Spring Boot 3.2.0  

## Instalación

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/envios-express-soap.git
   cd envios-express-soap

2. Compilar el proyecto:

   ```bash
   mvn clean install


3.Ejecutar la aplicación:

    ```bash
    mvn spring-boot:run

Uso del Servicio
El servicio estará disponible en:
http://localhost:8080/ws

WSDL
Accede al WSDL en:
http://localhost:8080/ws/tracking.wsdl

Ejemplo de Solicitud SOAP

     ```bash
      <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:log="http://logistica.com/ws/tracking">
    <soapenv:Header/>
    <soapenv:Body>
      <log:GetTrackingStatusRequest>
         <log:trackingNumber>PE1234567890</log:trackingNumber>
      </log:GetTrackingStatusRequest>
    </soapenv:Body>
    </soapenv:Envelope>
    
Ejemplo de Respuesta SOAP

         ```bash

    <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
      <ns2:GetTrackingStatusResponse xmlns:ns2="http://logistica.com/ws/tracking">
         <ns2:status>En tránsito</ns2:status>
         <ns2:currentLocation>Lima, Perú</ns2:currentLocation>
         <ns2:estimatedDeliveryDate>2023-12-15</ns2:estimatedDeliveryDate>
         <ns2:history>
            <ns2:date>2023-12-01T10:00:00Z</ns2:date>
            <ns2:description>Paquete recibido en bodega central</ns2:description>
            <ns2:location>Arequipa</ns2:location>
         </ns2:history>
      </ns2:GetTrackingStatusResponse>
    </SOAP-ENV:Body>
    </SOAP-ENV:Envelope>
    
Pruebas
Puedes probar el servicio usando:

SoapUI: Importa el WSDL y crea una nueva solicitud

Postman: Configura una solicitud POST 
