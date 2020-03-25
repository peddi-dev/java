package org.peddi.java.se13.textblock;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Text block is a multi-line string literal that avoids the need for most escape sequences, 
 * automatically formats the string in a predictable way, and gives the developer control over 
 * format when desired.
 */

public class TextBlockDemo {

    public String textBlockSimple(){

        String textBlock = """
        line 1
        line 2
        line 3
        """;

        return textBlock;
    }

    public String htmlTextBlock(){
        
        String htmlTextBlock = """
        <html>
            <body>
                <p> Hello, World!</p>
            </body>
        </html>
        """;

        return htmlTextBlock;
    }


    public String sqlTextBlock(){

        String sqlTextBlock = """
        SELECT `COL1`, `COL2` FROM `TABLE1`
        WHERE `COL1` = `VAL1`
        """;
        return sqlTextBlock;
    }

    public void javaScriptTextBlock() throws ScriptException{

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Object obj = engine.eval("""
        function hello() {
            print('"Hello World"');
        }
        hello();
        """);
    }

}