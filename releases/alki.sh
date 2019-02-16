#!/bin/bash

jardir="$(dirname "$BASH_SOURCE")"
# echo $jardir

if [ $# -lt 1 ]
then
  echo "Usage:"
  echo "alki.bat <file-with-algorithm>.alk"
  echo "or" 
  echo "alki <file-with-algorithm>.alk <file-with-initial-state>.in"
  exit 1
fi

if [ $# -eq 1 ]
then
  java -jar $jardir/alk.jar -a $1
  exit 0
fi

if [ $# -eq 2 ]
then
    java -jar $jardir/alk.jar -a $1 -i $2
  exit 0
fi
