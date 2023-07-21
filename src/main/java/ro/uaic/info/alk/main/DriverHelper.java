package ro.uaic.info.alk.main;

import ro.uaic.info.alk.io.AlkConsole;
import ro.uaic.info.alk.io.BufferedIOWrapper;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.ErrorManager;
import ro.uaic.info.alk.util.OptionProvider;

public class DriverHelper
{
   /**
    * Method used for initializing and linking the managers
    *
    * @param args
    * The command line arguments. Useful when constructing the OptionProvider.
    */
   public static AlkConfiguration initManagers(String[] args)
   {
      return initManagers(args, false);
   }


   /**
    * Method used for initializing and linking the managers
    *
    * @param args
    * The command line arguments. Useful when constructing the OptionProvider.
    */
   public static AlkConfiguration initManagers(String[] args, boolean buffered)
   {
      // setup the managers
      AlkConsole io = new AlkConsole(args);
      ErrorManager em = new ErrorManager();
      AlkConfiguration config = new AlkConfiguration();

      IOManager ioManager = io;
      if (buffered)
      {
         // setup buffered input
         ioManager = new BufferedIOWrapper(ioManager);
      }

      // attach interfaces to the managers
      em.attach(ioManager);
      em.attach((OptionProvider) io);
      config.attach(em);
      config.attach(ioManager);
      config.importOptions(io);

      return config;
   }
}
