package org.peddi.javase.jaxp.stax.eventiterator;

import org.peddi.javase.common.CommonConstants;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.System.out;

public class EventIteratorReader {
    String fileName  = CommonConstants.BASE_PATH + "org/peddi/javase/jaxp/stax/cursor/BookCatalog.xml";
    XMLEventReader xmlEventReader;

    public void read(){
        try {
            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);
            xmlEventReader = xif.createXMLEventReader(fileName, new FileInputStream(fileName));
            XMLEvent xmlEvent;
            while(xmlEventReader.hasNext()){
                xmlEvent = xmlEventReader.nextEvent();
                out.println(xmlEvent.toString());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
