package org.peddi.javase.jaxp.sax;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.PrintStream;

public class SAXErrorHandler implements  org.xml.sax.ErrorHandler{

    private PrintStream out;

    public SAXErrorHandler(PrintStream ps){
        this.out = ps;
    }

    private String getParseExceptionInfo(SAXParseException spe){

        return String.format("URL= %s; Line= %d;  %s",
                spe.getSystemId(), spe.getLineNumber(), spe.getMessage() );
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
            out.printf("Warning: %s", getParseExceptionInfo(exception));
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        String msg = String.format("Error: %s", getParseExceptionInfo(exception));
        throw new  SAXException(msg);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        String msg = String.format("Fatal Error: %s", getParseExceptionInfo(exception));
        throw new  SAXException(msg);
    }
}
