package com.arcologydesigns.io_operations;

/**
 * Created by bss64 ajn21 on 7/9/2015.
 * This file is currently not being used as local data is not supported in the current release version of the app.
 * Support is planned for the next release - once integrated, users will be able to read in data from a local flat file
 * following the contract outlined in the SpreadsheetIntegration class documentation.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {

    private String fileName;
    private String path;
    private boolean appendToFile;

    public FileIO(String filePath) {
        path = filePath;
    }

    public FileIO(String filePath, boolean appendValue) {
       path = filePath;
       appendToFile = appendValue;
    }

    public void WriteOperation(String textLine) throws IOException {
       FileWriter writer = new FileWriter(path, appendToFile);
       PrintWriter printWriter = new PrintWriter(writer);

       printWriter.printf("%s" + "%n", textLine);
       printWriter.close();
    }

    public String ReadOneLine() throws IOException {
       FileReader fileReader = new FileReader(path);
       BufferedReader lineReader = new BufferedReader(fileReader);
       String fileData;

       lineReader.readLine();  // temporary code to skip first line containing headers

       fileData = lineReader.readLine();
       System.out.print("1st line: " + fileData + "\n");

       lineReader.close();
       return fileData;
    }

    public String ReadAll() throws IOException {
       return "";
    }
} //end class FileIO
