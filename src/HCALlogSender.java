package HCALlogSender;

import org.apache.log4j.PropertyConfigurator;
import rcms.util.logger.RCMSLogger; // reuse the RCMS implementation for log4j

/**
 * Simple script to send messages to the logCollector 
 * to build, go on a teststand machine with RCMS installed:
 *   -------
 *   daqowner:~ $ cd /home/daqowner/TriDAS
 *   daqowner:~/TriDAS $ git clone git@github.com:HCALRunControl/HCALlogSender.git
 *   daqowner:~/TriDAS $ cd HCALlogSender
 *   ant
 *   -------
 * the compiled library will show up in the `jars` subdirectory
 *
 * to run, copy ~daqowner/TriDAS/jars/HCALlogSender.jar to your home directory on cmsusr
 * it needs to be run, on a machine on the cmsusr network with java1.8 installed (e.g. x2go01).
 * then to send e.g. the message "this is a test error!" to the logCollector logs:
 *   -------
 *   myusername@x2go01 ~ # java -jar HCALlogSender.jar 'this is a test error!'
 *   -------
 */


/**
 * @author johakala
 * 6/1/2018
 * standalone class for sending arbitrary log messages to the logs
 */
public class HCALlogSender {
  RCMSLogger logger;
  /**
   * constructor to set up the log sender, specifying what application name will appear next to the log message
   */
  public HCALlogSender(String name) {
    // TODO Auto-generated constructor stub
    this.logger=new RCMSLogger(name);
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
