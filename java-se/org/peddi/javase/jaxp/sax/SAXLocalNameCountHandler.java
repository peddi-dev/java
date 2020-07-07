package org.peddi.javase.jaxp.sax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.System.out;

public class SAXLocalNameCountHandler extends  DefaultHandler {
    Map<String, Integer> tags;
    String value = null;




    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        out.printf("%nElementName: %s%n", localName);
        int ac = attributes.getLength();
        if(ac>0) {
            out.println("Attributes:");
            for (int i = 0; i < ac; i++) {
                out.printf("%s = %s%n", attributes.getLocalName(i), attributes.getValue(i));
            }
        }


        String key = localName;
        Integer value = tags.get(key);
        value = (value == null)? 1 : (value + 1);
        tags.put(key, value);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(value != null && !value.isBlank()) {
            out.printf("%nElement Value: %s%n", value);
        }
        value = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        value = new String(ch, start, length);

    }

    @Override
    public void startDocument() throws SAXException {

        tags = new HashMap<>();
    }

    @Override
    public void endDocument() throws SAXException {

        Iterator<String> keyIter =  tags.keySet().iterator();
        while(keyIter.hasNext()){
            String tag =  keyIter.next();
            Integer count = tags.get(tag);
            System.out.printf("%nLocal Name %s occurs %d times%n", tag, count);
        }
    }
}
