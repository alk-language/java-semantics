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

# IMPORTANT!

Currently, the night builds are not promoted, as the version is still work in progress. Please use the latest release as it has a stable version and the sources attached. However, once the night builds will be scripted and regularly working, this will be merged.

Use the following for the latest stable version:
https://github.com/alk-language/java-semantics/releases
