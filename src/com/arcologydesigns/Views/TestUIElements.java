package com.arcologydesigns.Views;

/**
 * TestUIElements created by Borislav S. on 7/29/2015 @ 10:09 PM.
 */
import java.util.Enumeration;
import javax.swing.UIManager;

public class TestUIElements {

   public static void main(String[] args) {
      printUIManagerKeys("close");
   }

//   public TestUIElements(String _filter) {
//      //filter = _filter;
//      printUIManagerKeys(_filter);
//   }

   private static void printUIManagerKeys(String filter) {

      String filterToLowerCase = filter.toLowerCase();

      Enumeration<?> keys = UIManager.getDefaults().keys();

      while (keys.hasMoreElements()) {

         Object key = keys.nextElement();
         String keyToString = key.toString().toLowerCase();

         if (filter != null && keyToString.contains(filterToLowerCase)) {
            System.out.println(key + " ( " + UIManager.getDefaults().get(key) + " )");
         }
      }
   }
}
