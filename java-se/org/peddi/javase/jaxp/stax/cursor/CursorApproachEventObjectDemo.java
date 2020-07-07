package org.peddi.javase.jaxp.stax.cursor;

/**
 * * To Run
 * * ------
 * * IntelliJIDEA==> Run ==> Edit Configurations ==> Application ==> CursorApproachEventObjectDemo
 *  VM Options = --add-exports=java.xml/com.sun.xml.internal.stream.events=javase
 *
 */
public class CursorApproachEventObjectDemo {

    public static void main(String[] args){
        CursorApproachEventObject app = new CursorApproachEventObject();
        app.read();
    }
}
