package org.peddi.java.se13.textblock;

import javax.script.ScriptException;

import  org.junit.Assert;

import org.junit.Test;

public class  TextBlockDemoTest {

    @Test
    public void testTextBlockSimple(){
        var app  = new TextBlockDemo();

        String tb = app.textBlockSimple();
        System.out.println("==> " + tb);

        Assert.assertNotNull(tb);
    }

    @Test
    public void testHtmlTextBlock(){
        var app  = new TextBlockDemo();

        String htb = app.htmlTextBlock();
        System.out.println("==> " + htb);

        Assert.assertNotNull(htb);
    }

    @Test
    public void testSqlTextBlock(){
        var app  = new TextBlockDemo();

        String stb = app.sqlTextBlock();
        System.out.println("==> " + stb);

        Assert.assertNotNull(stb);
    }

    @Test
    public void testJavaScriptTextBlock(){
        var app  = new TextBlockDemo();
        
        System.out.println("==> JavaScript Block"  );

        try{

         app.javaScriptTextBlock();
        }
        catch(ScriptException e){
            System.out.println(e.toString());
        }
       
        Assert.assertTrue(true);
    }
    

}