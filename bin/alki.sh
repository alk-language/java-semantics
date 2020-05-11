#!/bin/bash

jardir="$(dirname "$BASH_SOURCE")"
#echo $jardir

java -jar $jardir/alk.jar ${@:1}
exit 0
