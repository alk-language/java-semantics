# Downloading and Running the Interpreter

1. Be sure you have installed the latest version of Java. Alk interpreter works now on Java 1.8.
2. Download the Java interpreter of Alk:
* if you have git on your system, then the best is to make a clone of the JAVA definition of alk from https://github.com/alk-language/java-semantics
* otherwise, you may download a zip archive from https://github.com/alk-language/java-semantics/releases/download/v2.0/alki-v2.0.zip
3. Test the Alk interpreter:
* Go to the `examples/miscelanea` folder and test some examples:

  * an example that does not require the input state:

    * Linux/Mac OS:
    ```
    ../../Linux_Mac/alki.sh -a gcd-no-input.alk
    4
    ```
    * Windows:
    ```
    ..\..\Windows\alki.bat -a gcd-no-input.alk
    4
    ```
  * an example that does require the input state:
    * Linux/Mac OS:
    ```
    ../../Linux_Mac/alki.sh -a gcd.alk -i gcd.in
    14
    ```
    * Windows:
    ```
    ..\..\Windows\alki.bat -a gcd.alk -i gcd.in
    14
    ```
It is strongly recommended to include the folder `Linux_Mac` or `Windows` in the PATH environment variable. This allow to call the the interpreter without mentioning the path to its location.
    
Read the [manual](doc/alk.pdf) to learn how to write Alk programs.
The Java interpreter for Alk is in progress, therefore we strongly advise you to weekly update it.

# Set Alk in PATH system variable
* Linux:
  ```
  mkdir -p ~/bin
  ln -s [PATH]/bin/alki.sh ~/bin/alki
  alki -h
  ```
  Note that ```[ALK-PATH]``` is a placeholder for the actual place where ```java-semantics``` is. For example: ```~/Alk/java-semantics```.
* Linux/Mac OS:
  ```
  export PATH=[ALK-PATH]/bin:$PATH
  ```
  Note that ```[ALK-PATH]``` is a placeholder for the actual place where ```java-semantics``` is. For example: ```~/Alk/java-semantics```.
* Windows
  * Search for ```Edit the system environment variables```
  * Open the ```System Properties``` window and press ```Environment variables...```
  * Select in the bottom grid (```System variables```) the ```Path``` variable and press ```Edit...```
  * Press ```New...``` in order to set up a new path toward the ```bin``` folder of ```java-semantics```. Example: ```C:\Alk\java-semantics\bin```
  ```
  alki -h
  ```

# Building from sources

1. Be sure you have installed the latest version of Java. Alk interpreter works now on Java 1.8.
2. Alk development is based on Maven as automatic building tool, thus having Maven installed is a prerequisite condition in order to build the Alk sources.
   * Linux:
   ```
   sudo apt-get install maven
   mvn -v
   ```
   * Mac OS:
   ```
   /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
   brew install maven
   mvn -v
   ```
   * Windows:
      * Download the latest Maven Binary zip archive from ```https://maven.apache.org/download.cgi```
      * Unzip the downloaded archive
      * Presuming that the unzipped folder is ```%PATH%\apache-maven```, add the ```%PATH%\apache-maven\bin``` folder to the path system variable.
      * Make sure that the ```JAVA_HOME``` system variable is also set correctly.
      ```
      mvn -v
      ```
3. Download the sources of the Alk Java interpreter from https://github.com/alk-language/java-semantics
4. Build the sources using Maven:
   * Linux/Mac OS:
   ```
   cd java-semantics
   mvn package
   cd bin
   ./alki.sh -a example.alk -i input.in
   ```
   * Windows:
   ```
   cd java-semantics
   mvn package
   cd bin
   alki.bat -a example.alk -i input.in
   ```
   
   
