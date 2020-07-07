package org.peddi.javase.jaxp.dom;

public class DOMDemo {

   public void domParserDemo(){
        DOMReader reader = new DOMReader();
        reader.initDocBuilder();
        reader.readDoc();
    }

    public static void main(String[] args){
        DOMDemo app = new DOMDemo();
        app.domParserDemo();
    }
}
