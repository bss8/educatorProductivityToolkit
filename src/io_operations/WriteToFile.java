package io_operations;

/**
 * WriteToFile created by Borislav S. on 7/8/2015 @ 11:28 PM.
 */
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteToFile {
   private String path;
   private boolean appendToFile;

   public WriteToFile(String filePath) {
      path = filePath;
   }

   public WriteToFile(String filePath, boolean appendValue) {
      path = filePath;
      appendToFile = appendValue;
   }

   public void WriteOperation(String textline) throws IOException {
      FileWriter writer = new FileWriter(path, appendToFile);
      PrintWriter printWriter = new PrintWriter(writer);

      printWriter.printf("%s" + "%n", textline);

      printWriter.close();
   }
}
