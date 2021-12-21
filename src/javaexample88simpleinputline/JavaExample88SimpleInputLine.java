package javaexample88simpleinputline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaExample88SimpleInputLine {

    public static void main(String[] args) {

        try {

            // To read one char for-example-> (char) isr.read();
            InputStreamReader isr = new InputStreamReader(System.in);

            // BufferedReader:
            // Reads text from a character-input stream, buffering characters so as 
            // to provide for the efficient reading of characters, arrays, and lines.
            // ----
            // In general, each read request made of a Reader causes a corresponding 
            // read request to be made of the underlying character or byte stream. 
            // It is therefore advisable to wrap a BufferedReader around any Reader 
            // whose read() operations may be costly, such as FileReaders and InputStreamReaders.
            BufferedReader sin = new BufferedReader(isr);
            // will buffer the input from the specified InputStreamReader. Without buffering, 
            // each invocation of read() or readLine() could cause bytes to be read 
            // from the InputStreamReader, converted into characters, and then returned, 
            // which can be very inefficient.

            // Remark! we can use Scanner. In this case we do not need try-catch structure.
            System.out.print("Enter a line: ");

            String str = sin.readLine();

            System.out.println("Your Line is: "+ str);
            
            //lineEnd: depends on OS
            // \r\n in Windows  \n in Unix  \r in Mac
            String lineEnd = System.getProperty("line.separator");
            
            System.out.println("Enter a text ends with empty line....");
            
            StringBuilder text = new StringBuilder("");

            String line = sin.readLine();
            // In case of Scanner, we use nextLine()
            
            while (!(line.equals(""))) 
            {                
                // add submitted line to the text
                text.append(line + lineEnd);
                
                // get the next line
                line=sin.readLine();
                // In case of Scanner, we use nextLine()
            } // end-while
            
            System.out.println("The submitted text....");
            System.out.println(text);
            
            // close the stream
            sin.close();
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }

    }// end-main

}
