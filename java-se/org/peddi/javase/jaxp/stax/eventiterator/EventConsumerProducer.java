package org.peddi.javase.jaxp.stax.eventiterator;

import org.peddi.javase.common.CommonConstants;

import javax.xml.stream.*;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;

/**
 * The StAX XMLEventWriter API extends from the XMLEventConsumer interface, and is referred to as an event consumer.
 * By contrast, XMLEventReader is an event producer. StAX supports simultaneous reading and writing,
 * such that it is possible to read from one XML stream sequentially and simultaneously write to another stream.
 */
public class EventConsumerProducer {

    String filename = CommonConstants.BASE_PATH + "org/peddi/javase/jaxp/stax/eventiterator/BookCatalog2.xml";
    XMLEventReader xmlEventReader;
    XMLEventWriter xmlEventWriter;
    XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();

    public void readWrite(){

        try{
            XMLInputFactory xif = XMLInputFactory.newInstance();
            xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);
            xif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);
            xmlEventReader = xif.createXMLEventReader(filename, new FileInputStream(filename));
            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            xmlEventWriter = xof.createXMLEventWriter(System.out);

            XMLEvent xmlEvent;
            while(xmlEventReader.hasNext()){
                xmlEvent = xmlEventReader.nextEvent();
                if(xmlEvent.isCharacters() && !xmlEvent.asCharacters().isWhiteSpace()){
                    xmlEventWriter.add(getNewCharactersEvent(xmlEvent.asCharacters()));
                }else{
                    xmlEventWriter.add(xmlEvent);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            try {
                xmlEventWriter.flush();
                xmlEventWriter.close();
                xmlEventReader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

    }

    public XMLEvent getNewCharactersEvent(Characters event){
        if(event.getData().equalsIgnoreCase("Name1")){

           return xmlEventFactory.createCharacters(ZonedDateTime.now().toString());

        }else{
            return event;
        }
    }

    public static  void main(String... args){
        EventConsumerProducer ecp = new EventConsumerProducer();
        ecp.readWrite();
    }
}
