package org.peddi.javase.jaxp.stax.cursor;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class StreamWriter {
    String fileName ="StAXHTMLSample.html" ;
    XMLStreamWriter xmlStreamWriter;

    public void write(){

        try {
            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            xmlStreamWriter = xof.createXMLStreamWriter(new FileOutputStream(fileName));
            System.out.println(xmlStreamWriter.getClass());

            xmlStreamWriter.writeComment("all elements here are explicitly in the HTML namespace");

            xmlStreamWriter.writeStartDocument("utf-8","1.0");
            xmlStreamWriter.setPrefix("html", "http://www.w3.org/TR/REC-html40");

            xmlStreamWriter.writeStartElement("http://www.w3.org/TR/REC-html40","html");
            xmlStreamWriter.writeNamespace("html","http://www.w3.org/TR/REC-html40");

            xmlStreamWriter.writeStartElement("http://www.w3.org/TR/REC-html40","head");
            xmlStreamWriter.writeStartElement("http://www.w3.org/TR/REC-html40", "title");
            xmlStreamWriter.writeCharacters("Frobnostication");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement("http://www.w3.org/TR/REC-html40","body");
            xmlStreamWriter.writeStartElement("http://www.w3.org/TR/REC-html40", "p");
            xmlStreamWriter.writeCharacters("Move to");
            xmlStreamWriter.writeStartElement("http://www.w3.org/TR/REC-html40", "a");
            xmlStreamWriter.writeAttribute("href", "http://frob.com");
            xmlStreamWriter.writeCharacters("here");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndDocument();

            System.out.println("XML Writer Complete");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }finally {
            if (xmlStreamWriter != null){
                try {
                    xmlStreamWriter.flush();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                try {
                    xmlStreamWriter.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
