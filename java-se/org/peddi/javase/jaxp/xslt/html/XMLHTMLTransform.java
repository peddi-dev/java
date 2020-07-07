package org.peddi.javase.jaxp.xslt.html;

import org.peddi.javase.common.CommonConstants;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class XMLHTMLTransform {
    String dataFile = String.format("%s%s%s",
            "file://",
            CommonConstants.BASE_PATH,
            "org/peddi/javase/jaxp/xslt/html/article.xml");

    String stylesheetFile= String.format("%s%s%s",
            "file://",
            CommonConstants.BASE_PATH,
            "org/peddi/javase/jaxp/xslt/html/article.xsl");

    public void transformXMLHTML()  {

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(dataFile);
            DOMSource domSource = new DOMSource(document);

            StreamSource streamSource = new StreamSource(stylesheetFile);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(streamSource);

            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(domSource, streamResult);

        } catch (TransformerConfigurationException | ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }
}
