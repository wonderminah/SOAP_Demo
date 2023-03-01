package com.example;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.dom.DOMSource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource; 

/*
 * SOAP Request Test
 * 
 * Postman Public SOAP Apis for Test
 * https://documenter.getpostman.com/view/8854915/Szf26WHn#2b41412f-4ed1-43fd-b2de-e73e5ddf77ae
 *
 */
public class SOAPClient 
{
    public static void main( String[] args )
    {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
            factory.setNamespaceAware(true);             
            DocumentBuilder parser = factory.newDocumentBuilder();
     
            //SOAP API Endpoint
            String requestURL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";

            //Request SOAP message DOMSource create (Search capital city of JP)
            String sendMessage = 
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + 
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" + 
                "    <soap:Body>" + 
                "        <CapitalCity xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">" + 
                "            <sCountryISOCode>JP</sCountryISOCode>" + 
                "        </CapitalCity>" + 
                "    </soap:Body>" + 
                "</soap:Envelope>";
                
            //Parse string as DOMSource
            StringReader reader = new StringReader(sendMessage);
            InputSource is = new InputSource(reader);
            Document document = parser.parse(is);
            DOMSource requestSource = new DOMSource(document);
     
            //SOAP Message create
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage requestSoapMessage = messageFactory.createMessage(); 
            SOAPPart requestSoapPart = requestSoapMessage.getSOAPPart(); 
            requestSoapPart.setContent(requestSource);
     
            //SOAP Connection create instance
            SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = scf.createConnection();
     
            //SOAP Send Message
            SOAPMessage responseSoapMessage = connection.call(requestSoapMessage, requestURL);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            responseSoapMessage.writeTo(out);

            //Print SOAP Response as string
            String soapResult = new String(out.toByteArray(), "UTF-8");
            System.out.println(soapResult);
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
}