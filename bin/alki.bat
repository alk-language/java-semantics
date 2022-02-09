set PATH=%PATH%;%~dp0\lib
java -Djava-library-path="%~dp0;%~dp0\lib" -cp "%~dp0\alk.jar;%~dp0\lib\com.microsoft.z3.jar" main.ExecutionDriver %*
