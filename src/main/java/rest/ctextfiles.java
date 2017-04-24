package rest;

import java.io.*;

/**
 * Created by khanami on 24.04.2017.
 */
public class ctextfiles {

    public static void writeTextFile(String vsFileName, String vsMode, String vsData) throws IOException {
        BufferedWriter voWriter = null;
        PrintWriter voPrinter = null;
        FileWriter voFile = null;


        if (vsMode == "NEW") {
            voFile = new FileWriter(vsFileName);
            voWriter = new BufferedWriter(voFile);
            voPrinter = new PrintWriter(voWriter);
        }

        if (vsMode == "APPEND") {
            voFile = new FileWriter(vsFileName, true);
            voWriter = new BufferedWriter(voFile);
            voPrinter = new PrintWriter(voWriter);
          }
        voPrinter.println(vsData);
        voPrinter.close();
        voWriter.close();
        voFile.close();



    }
}
