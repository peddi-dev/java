package org.peddi.javase.jaxp.sax;

import org.peddi.javase.common.CommonConstants;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


public class SAXDemo {

    public String getFileURL(){

        String url = "file://" + CommonConstants.BASE_PATH + "/org/peddi/javase/jaxp/sax/saxSample1.xml";

        return url;
    }

    public void saxParserDemo(){

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);

            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new SAXLocalNameCountHandler());
            xmlReader.parse(getFileURL());
            xmlReader.setErrorHandler(new SAXErrorHandler(System.err));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        SAXDemo app = new SAXDemo();
        app.saxParserDemo();

    }
}
