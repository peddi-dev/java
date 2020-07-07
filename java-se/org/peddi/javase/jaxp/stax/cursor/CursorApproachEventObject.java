package org.peddi.javase.jaxp.stax.cursor;

import org.peddi.javase.common.CommonConstants;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventAllocator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//NOTE: following VM option needs to the java runtime
// --add-exports=java.xml/com.sun.xml.internal.stream.events=javase
/**Eclise IDE==>Project Properties==>Java Build Path ==> 
*Select java.xml from All Modules ==> Expose Package ==>
*copy java.xml/com.sun.xml.internal.stream.events 
*/

/*
* To Compile
* ----------
* IntellIDEA ==> Preferences ==>
* Override compiler parameters per-module ==> add module(+)
* ==> provide the following value for the compiler option
*  --add-exports=java.xml/com.sun.xml.internal.stream.events=javase
*
*
*/
import com.sun.xml.internal.stream.events.XMLEventAllocatorImpl;

import static java.lang.System.out;

public class CursorApproachEventObject {

    String fileName = CommonConstants.BASE_PATH + "org/peddi/javase/jaxp/stax/cursor/BookCatalog.xml";
    XMLStreamReader xmlStreamReader;
    XMLEventAllocator xmlEventAllocator;

    public void read(){

        try {
            XMLInputFactory xif = XMLInputFactory.newInstance();

             xif.setEventAllocator(new XMLEventAllocatorImpl());

            xif.setProperty(XMLInputFactory.IS_COALESCING, true);
            xmlStreamReader = xif.createXMLStreamReader(fileName, new FileInputStream(fileName));
            xmlEventAllocator = xif.getEventAllocator();


            int eventType;

            while(xmlStreamReader.hasNext()){
                eventType = xmlStreamReader.next();
                XMLEvent xmlEventObject;

                if (eventType == XMLEvent.START_ELEMENT){
                    xmlEventObject = xmlEventAllocator.allocate(xmlStreamReader);
                    StartElement startElement = xmlEventObject.asStartElement();
                    out.printf("EVENT:%s%n", startElement.toString());
                }else if(eventType == XMLEvent.CHARACTERS && !xmlStreamReader.isWhiteSpace()){
                     xmlEventObject = xmlEventAllocator.allocate(xmlStreamReader);
                     Characters chars = xmlEventObject.asCharacters();
                     out.printf("EVENT:%s%n", chars.getData());                }
                }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
