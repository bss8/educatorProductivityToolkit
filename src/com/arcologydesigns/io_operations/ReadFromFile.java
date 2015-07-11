package com.arcologydesigns.io_operations;

/**
 * Created by bss64 ajn21 on 7/9/2015.
 */
import java.io.*;

public class ReadFromFile {

    private String fileName;
    private String path;

    public ReadFromFile(String filePath) {
        path = filePath;
    }

    public String OpenFile() throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader lineReader = new BufferedReader(fileReader);
        String fileData;

        fileData = lineReader.readLine();
        System.out.print("1st line: " + fileData);

        lineReader.close();

        return fileData;
    }

}
