package main;

import io.AlkConsole;
import io.BufferedIOWrapper;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;

public class DriverHelper
{
   /**
    * Method used for initializing and linking the managers
    *
    * @param args
    * The command line arguments. Useful when constructing the OptionProvider.
    */
   public static Configuration initManagers(String[] args)
   {
      return initManagers(args, false);
   }


   /**
    * Method used for initializing and linking the managers
    *
    * @param args
    * The command line arguments. Useful when constructing the OptionProvider.
    */
   public static Configuration initManagers(String[] args, boolean buffered)
   {
      // setup the managers
      AlkConsole io = new AlkConsole(args);
      ErrorManager em = new ErrorManager();
      Configuration config = new Configuration();

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
