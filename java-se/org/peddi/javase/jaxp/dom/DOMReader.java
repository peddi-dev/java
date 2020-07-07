package org.peddi.javase.jaxp.dom;

import org.peddi.javase.common.CommonConstants;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static java.lang.System.out;

public class DOMReader {

    private String fileURI = String.format("%s%s%s",
            "file://",
            CommonConstants.BASE_PATH,
            "org/peddi/javase/jaxp/sax/saxSample1.xml"
            ) ;

    private DocumentBuilder docBuilder;
    private Document doc;

    public DOMReader(){

    }

    public void initDocBuilder(){

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            docBuilder = dbf.newDocumentBuilder();
            doc = docBuilder.parse(fileURI);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDoc(){

       Element docElem = doc.getDocumentElement();
       traverseDOM(docElem);
    }

    public void traverseDOM(Node node) {

        displayNode(node);

        if ( node.hasAttributes()){
            NamedNodeMap attributes = node.getAttributes();
            for(int i=0; i<attributes.getLength(); i++){
                Node attr = attributes.item(i);
                out.printf("%s = %s%n",attr.getNodeName(), attr.getNodeValue());
            }
        }
        if ( node.hasChildNodes() ){
            NodeList children = node.getChildNodes();
            for(int i=0; i<children.getLength(); i++){
                Node child = children.item(i);
                traverseDOM(child);
            }
        }

    }

    public void displayNode(Node node){

       out.printf("%n%s ", node.getNodeName());
       String val = node.getNodeValue();
       if( val != null){
           out.printf(" = %s%n", val);
       }else{
           out.println();
       }

  }

    private void displayAttribute(Node attr){
        out.printf("%s = %s%n", attr.getNodeName(), attr.getNodeValue());
    }
}

