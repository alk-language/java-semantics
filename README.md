# Introduction
This repository includes Alk, an educational platform designed to help in learning algorithms and acquiring algorithmic thinking.
Some references:
1. Lungu, A., Lucanu, D.: _A matching logic foundation for Alk_. In: Seidl, H., Liu, Z., Pasareanu, C.S. (eds.) Theoretical Aspects of Computing -
ICTAC 2022 - 19th International Colloquium, Tbilisi, Georgia, September 27-29, 2022, Proceedings. Lecture Notes in Computer Science, vol. 13572, pp. 290–304. Springer (2022). https://doi.org/10.1007/978-3-031-17715-6“ ̇19
2. Lungu, A., Lucanu, D.: _Supporting algorithm analysis with symbolic execution in Alk_. In: Ameur, Y.A., Craciun, F. (eds.) Theoretical Aspects of Software Engineering - 16th International Symposium, TASE 2022, Proceedings. Lecture Notes in Computer Science, vol. 13299, pp. 406–423. Springer (2022), https://doi.org/10.1007/978-3-031-10363-6 27

Read the [reference manual](../../wiki/Reference-Manual) to review the Alk syntax.
Also consider the [Alk-by example](../../wiki/Alk-by-examples) wiki to understand how Alk behaves in real-scenarios.

# Using the Alk VS Code Extension
1. Install VS Code from the official [page](https://code.visualstudio.com/download).
2. In the Extensions tag in the left side, check for the "Alk Visual Studio Code Extension" and install.
3. Enter the [Alk VS Code Extension](https://github.com/Andreizabo/alk-vscode-extension) repository and check the usage manual.

# Downloading and Running the Interpreter

1. Be sure you have installed the latest version of Java. Alk interpreter works now on Java 1.8.
2. Download the Java interpreter of Alk:
* if you have git on your system, then the best is to make a clone of the JAVA definition of alk from https://github.com/alk-language/java-semantics
* otherwise, you may download a zip archive from https://github.com/alk-language/java-semantics/releases/download/v4.0/alki-v4.0.zip
3. Make sure you have rights to execute the scripts:
  * Linux/Mac OS:
  ```
  chmod +x alki.sh
  ```
4. Test the Alk interpreter:
* Go to the `examples/miscelanea` folder and test some examples:

  * an example that does not require the input state:

    * Linux/Mac OS:
    ```
    ../../bin/alki.sh -a gcd-no-input.alk
    4
    ```
    * Windows:
    ```
    ..\..\bin\alki.bat -a gcd-no-input.alk
    4
    ```
  * an example that does require the input state:
    * Linux/Mac OS:
    ```
    ../../bin/alki.sh -a gcd.alk -i gcd.in
    14
    ```
    * Windows:
    ```
    ..\..\bin\alki.bat -a gcd.alk -i gcd.in
    14
    ```
It is strongly recommended to include the folder `Linux_Mac` or `Windows` in the PATH environment variable. This allow to call the the interpreter without mentioning the path to its location.

Optionally (and remmended) is to create a symbolic link named `alki`:
* Linux/Mac OS:
    ```
    ln -s ../../bin/alki.sh ../../bin/alki
    ```

# Set Alk in PATH system variable
* Linux/Mac OS:
  ```
  export PATH=[ALK-PATH]/bin:$PATH
  alki.sh -h
  ```
  Note that this will set the PATH only for the current shell. Opening another shell will not have Alk set in PATH. For pesistent set, use:
  ```
  echo 'PATH=[ALK-PATH]/bin:$PATH' >> ~/.bashrc
  alki.sh -h
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
   chmod +x alki.sh
   ./alki.sh -a example.alk -i input.in
   ```
   * Windows:
   ```
   cd java-semantics
   mvn package
   cd bin
   alki.bat -a example.alk -i input.in
   ```
   
   
