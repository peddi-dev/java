package org.peddi.javase.jaxp.xslt.arbitrary;

import org.peddi.javase.common.CommonConstants;
import org.xml.sax.InputSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArbitraryDataTransform {

    public void transformArbitraryDataToStream(){
        String fileURI = String.format("%s%s",
                CommonConstants.BASE_PATH,
                "org/peddi/javase/jaxp/xslt/arbitrary/addressBookData.ldif");

        try {

            AddressBookReader saxReader = new AddressBookReader();
            BufferedReader br = new BufferedReader(new FileReader(fileURI));
            InputSource inputSource = new InputSource(br);
            SAXSource saxSource = new SAXSource(saxReader, inputSource);
            StreamResult streamResult = new StreamResult(System.out);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(saxSource, streamResult);

        }  catch(TransformerConfigurationException e) {
            e.printStackTrace();
        }catch (FileNotFoundException  e) {
            e.printStackTrace();
            e.getSuppressed().toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }



    }
}
