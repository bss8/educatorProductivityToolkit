package com.arcologydesigns.io_operations;

/**
 * Created by bss64 ajn21 on 7/9/2015.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {

    private String fileName;
    private static String path;
    private static boolean appendToFile;

    public FileIO(String filePath) {
        path = filePath;
    }

    public FileIO(String filePath, boolean appendValue) {
        path = filePath;
        appendToFile = appendValue;
    }

    public static String setFilePath(String filepath) throws IOException {
        path = filepath;
        return path;
    }

    public void WriteOperation(String textLine) throws IOException {
        FileWriter writer = new FileWriter(path, appendToFile);
        PrintWriter printWriter = new PrintWriter(writer);

        printWriter.printf("%s" + "%n", textLine);

        printWriter.close();
    }

    public static boolean appendCheck() throws IOException {
        return appendToFile;
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

}
