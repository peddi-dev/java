package org.peddi.javase.jaxp.xslt.arbitrary;

import org.xml.sax.*;
import org.xml.sax.helpers.AttributesImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddressBookReader implements XMLReader {
    private org.xml.sax.ContentHandler contentHandler;
    private String nsURI = "";
    Attributes attributes = new AttributesImpl();
    String rootElement = "addressbook";
    String indent = "\n ";

    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        return false;
    }

    @Override
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {

    }

    @Override
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        return null;
    }

    @Override
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {

    }

    @Override
    public void setEntityResolver(EntityResolver resolver) {

    }

    @Override
    public EntityResolver getEntityResolver() {
        return null;
    }

    @Override
    public void setDTDHandler(DTDHandler handler) {

    }

    @Override
    public DTDHandler getDTDHandler() {
        return null;
    }

    @Override
    public void setContentHandler(ContentHandler handler) {
        this.contentHandler = handler;

    }

    @Override
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override
    public void setErrorHandler(ErrorHandler handler) {

    }

    @Override
    public ErrorHandler getErrorHandler() {
        return null;
    }

    @Override
    public void parse(InputSource input) throws IOException, SAXException {

        try(var br = new BufferedReader(input.getCharacterStream());){

            String line = null;

            while((line = br.readLine()) != null) {

                if (line.startsWith("xmozillanickname: ")) {
                    break;
                }
            }


                output("nickname", "xmozillanickname", line);
                line = br.readLine();
                output("email",  "mail", line);

                line = br.readLine();
                output("html", "xmozillausehtmlmail", line);

                line = br.readLine();
                output("firstname","givenname", line);

                line = br.readLine();
                output("lastname", "sn", line);

                line = br.readLine();
                output("work", "telephonenumber", line);

                line = br.readLine();
                output("home", "homephone", line);

                line = br.readLine();
                output("fax", "facsimiletelephonenumber", line);

                line = br.readLine();
                output("pager", "pagerphone", line);

                line = br.readLine();
                output("cell", "cellphone", line);

                if(contentHandler == null){
                    throw new SAXException("No Content Handler");

                }
                contentHandler.startDocument();
                contentHandler.startElement(nsURI,
                                            rootElement,
                                            rootElement,
                                            attributes);

                contentHandler.ignorableWhitespace("\n".toCharArray(), 0 , 1);
                contentHandler.endElement(nsURI,
                        rootElement,
                        rootElement);
                contentHandler.endDocument();



        }

    }

    @Override
    public void parse(String systemId) throws IOException, SAXException {

    }

    public void output(String name,
                       String prefix,
                       String line) throws SAXException {


        int startIndex = prefix.length() + 2;
        String text = line.substring(startIndex);
        int textLenght = line.length() - startIndex;
        contentHandler.ignorableWhitespace(indent.toCharArray(), 0, indent.length());
        contentHandler.startElement(nsURI, name, name, attributes);
        contentHandler.characters(line.toCharArray(),
                startIndex,
                textLenght);
        contentHandler.endElement(nsURI, name, name);

    }
}
