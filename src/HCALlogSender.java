package HCALlogSender;

import org.apache.log4j.PropertyConfigurator;
import rcms.util.logger.RCMSLogger; // reuse the RCMS implementation for log4j

/**
 * @author John Hakala
 * 6/1/2018
 * standalone class for sending arbitrary log messages to the logs
 * see README.md for instructions for building and running
 */

public class HCALlogSender {
  RCMSLogger logger;
  /**
   * constructor to set up the log sender, specifying what application name will appear next to the log message
   */
  public HCALlogSender(String name) {
    this.logger = new RCMSLogger(name);
  }

  /**
   * main method of the class -- gets called when you invoke this program from the command line
   * @param args: one argument, the message to send to the logs
   */
  public static void main(String[] args) {
    HCALlogSender logSender = new HCALlogSender("John_test"); // TODO: John_test is the name of the app sending the log. 
                                                              // This could be changed to HCALlogSender or a user-defined name (e.g. ngccmserver)
    PropertyConfigurator.configure("/nfshome0/johakala/test/RCMS.properties"); //TODO unhardcode/refactor this
    String message = args[0];
    logSender.logger.error(message); // TODO: maybe enable different log levels
  }
}
