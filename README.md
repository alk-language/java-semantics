# Downloading and Running the Interpreter

1. Be sure you have installed the latest version of Java. Alk interpreter works now on Java 1.8.
2. Download the Java interpreter of Alk:
* if you have git on your system, then the best is to make a clone of the K definition of alk from https://github.com/alk-language/java-semantics
* otherwise, you may download a zip archive from https://github.com/alk-language/java-semantics/archive/master.zip (Clone or download button);

2'. Instruction to install and also add to the system path the interpretor using git for \*NIX systems :

2'.1. Clone java-semantics into `~/.alklang
  ```
  $ git clone https://github.com/alk-language/java-semantics ~/.alklang
  ```
2'.2. Add `~/.alklang/java-semantics/bin` to your $PATH for access to the alki command-line utility.
 * For **bash**:
   * you might need to replace `.bash_profile` with `.bashrc`
  ~~~ bash
  $ echo 'export PATH="$HOME/.alklang/java-semantics/bin:$PATH"' >> ~/.bash_profile
  ~~~
  
 * For **Zsh**:
  ~~~ zsh
  $ echo 'export PATH="$HOME/.alklang/java-semantics/bin:$PATH"' >> ~/.zshrc
  ~~~
  
 * For **Fish shell**:
  ~~~ fish
  $ set -Ux fish_user_paths $HOME/.alklang/java-semantics/bin $fish_user_paths
  ~~~

2'.3. Restart your shell so that PATH changes take effect.

3. Test the Alk interpreter:
* If you added `java-semantics/bin` folder to the system path you can use just use `alki` command

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
