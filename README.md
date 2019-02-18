# Downloading and Running the Interpreter

1. Be sure you have installed the latest version of Java. Alk interpreter works now on Java 1.8.
2. Download and compile the Java interpreter of Alk:
* if you have git on your system, then the best is to make a clone of the K definition of alk from https://github.com/alk-language/java-semantics
* otherwise, you may download a zip archive from https://github.com/alk-language/java-semantics/archive/master.zip (Clone or download button);
3. Test the Alk interpreter:
* Go to the `examples/miscelanea` folder and test some examples:

  * an example that does not require the input state:

    * Linux/Mac OS:
    ```
    ../../bin/alki.sh gcd-no-input.alk
    4
    ```
    * Windows:
    ```
    ..\..\bin\alki.bat gcd-no-input.alk
    4
    ```
  * an example that does require the input state:
    * Linux/Mac OS:
    ```
    ../../bin/alki.sh gcd.alk gcd.in
    14
    ```
    * Windows:
    ```
    ..\..\bin\alki.bat gcd.alk gcd.in
    14
    ```
It is strongly recommended to include the folder `java-semantics/bin` in the PATH environment variable. This allow to call the the interpreter without mentioning the path to its location.
    
Read the [manual](doc/alk.pdf) to learn how to write Alk programs.
The Java interpreter for Alk is in progress, therefore we strongly advise you to weekly update it.
