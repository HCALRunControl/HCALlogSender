Simple script to send messages to the logCollector 
to build, go on a teststand machine with RCMS installed:
```
    daqowner:~ $ cd /home/daqowner/TriDAS
    daqowner:~/TriDAS # git clone git@github.com:HCALRunControl/HCALlogSender.git
    daqowner:~/TriDAS # cd HCALlogSender
    daqowner:~/TriDAS # ant
```
  the compiled library will show up in the `jars` subdirectory
 
  to run, copy ~daqowner/TriDAS/jars/HCALlogSender.jar to your home directory on cmsusr
  it needs to be run, on a machine on the cmsusr network with java1.8 installed (e.g. x2go01).
  then to send e.g. the message "this is a test error!" to the logCollector logs:
```
    myusername@x2go01 ~ # java -jar HCALlogSender.jar 'this is a test error!'
```
