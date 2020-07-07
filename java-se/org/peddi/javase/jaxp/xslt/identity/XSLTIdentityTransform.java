package org.peddi.javase.jaxp.xslt.identity;

import org.peddi.javase.common.CommonConstants;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 *  Writing DOM as an XML file
 *  XSLT transformer taskes DOMSource with DOM document as input and
 *  provides StreamResult with PrintWriter Stream as an output
 *
 *  It does not modify the input, hence it is called identity transformation
 *
 */
public class XSLTIdentityTransform {

   private String fileURI = String.format("%s%s%s",
            "file://",
            CommonConstants.BASE_PATH ,
            "org/peddi/javase/jaxp/xslt/identity/xslt_xml_sample.xml");

    public void xsltIdentityTransform(){


       try{
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
           Document document = documentBuilder.parse(fileURI);

           TransformerFactory tf = TransformerFactory.newInstance();
           Transformer transformer = tf.newTransformer();
           if(document.getDoctype() != null){
               String systemValue = (new File(document.getDoctype().getSystemId())).getName();
               transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, systemValue);
           }
           transformer.setOutputProperty(OutputKeys.INDENT, "yes");

           DOMSource domSource = new DOMSource(document);
           StreamResult streamResult = new StreamResult(System.out);
           transformer.transform(domSource, streamResult);

       } catch (ParserConfigurationException e) {
           e.printStackTrace();
       } catch (SAXException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (TransformerConfigurationException e) {
           e.printStackTrace();
       } catch (TransformerException e) {
           e.printStackTrace();
       }

    }
}
