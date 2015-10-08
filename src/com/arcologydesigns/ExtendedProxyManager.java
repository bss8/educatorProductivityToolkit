package com.arcologydesigns;

/**
 * Created by VZ9YFG on 9/2/2015.
 * https://stackoverflow.com/questions/120797/how-do-i-set-the-proxy-to-be-used-by-the-jvm
 * ExtendedProxyManager created by user dma_k (March 9, 2010)
 */
import com.sun.deploy.net.proxy.DeployProxySelector;
import com.sun.deploy.services.PlatformType;
import com.sun.deploy.services.ServiceManager;
import org.apache.commons.logging.LogFactory;


public abstract class ExtendedProxyManager {

   private static final org.apache.commons.logging.Log logger = LogFactory.getLog(ExtendedProxyManager.class);

   /**
    * After calling this method, proxy settings can be magically retrieved from default browser settings.
    */
   public static boolean init() {
      logger.debug("Init started");

      // Initialization code was taken from com.sun.deploy.ClientContainer:
      ServiceManager
              .setService(System.getProperty("os.name").toLowerCase().indexOf("windows") != -1 ? PlatformType.STANDALONE_TIGER_WIN32
                      : PlatformType.STANDALONE_TIGER_UNIX);

      try {
         // This will call ProxySelector.setDefault():
         DeployProxySelector.reset();
      } catch (Throwable throwable) {
         logger.error("Unable to initialize extended dynamic browser proxy settings support.", throwable);

         return false;
      }

      return true;
   }
}
