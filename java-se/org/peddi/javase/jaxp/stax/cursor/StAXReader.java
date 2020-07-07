package org.peddi.javase.jaxp.stax.cursor;

import org.peddi.javase.common.CommonConstants;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.System.out;

public class StAXReader {

    XMLStreamReader xmlStreamReader;
    String fileName = CommonConstants.BASE_PATH + "org/peddi/javase/jaxp/stax/cursor/BookCatalog.xml";

    public void read(){

        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        xmlif.setProperty(XMLInputFactory.IS_COALESCING, true);
        try {
            xmlStreamReader = xmlif.createXMLStreamReader(new FileInputStream(fileName));

            int eventType;
            while(xmlStreamReader.hasNext()){

                eventType = xmlStreamReader.next();

                switch (eventType){

                    case XMLEvent.START_ELEMENT: {

                        readStartElement();
                        break;
                    }
                    case XMLEvent.CHARACTERS:{

                        readCharacters();
                        break;
                    }

                    case XMLEvent.COMMENT: {
                        readComment();
                        break;
                    }

                }

            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void readStartElement(){

       out.printf("ElementName: %s%n", xmlStreamReader.getLocalName());

       if(xmlStreamReader.getAttributeCount()  > 0){
           out.println("    Attributes");
           for ( int i=0; i<xmlStreamReader.getAttributeCount(); i++){

               out.printf("     %s: %s,  %s",
                       xmlStreamReader.getAttributeLocalName(i),
                       xmlStreamReader.getAttributeValue(i),
                       xmlStreamReader.getAttributeType(i)
               );

           }
           try {
               out.println("**" + xmlStreamReader.getElementText());
           } catch (XMLStreamException e) {
               e.printStackTrace();
           }
       }
    }

    public void readCharacters(){

        if(xmlStreamReader.hasText()){
           String text = xmlStreamReader.getText();
           if(text != null && !text.isBlank()) {
               out.printf("ElementValue: %s%n", text);
           }
        }
    }

    public void readComment(){
            out.printf("Comment: %s%n", xmlStreamReader.getText());
    }
}
