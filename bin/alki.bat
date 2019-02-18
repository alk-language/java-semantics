@ECHO OFF

SET jarpath=%~dp0
IF %1.==. GOTO No1
IF %2.==. GOTO No2
 java -jar "%jarpath%alk.jar" -a %1 -i %2
GOTO End1

:No1
  ECHO Usage:
  ECHO "alki.bat <file-with-algorithm>.alk"
  ECHO or 
  ECHO "alki <file-with-algorithm>.alk <file-with-initial-state>.in"
GOTO End1
:No2
  java -jar "%jarpath%alk.jar" -a %1 
GOTO End1

:End1
