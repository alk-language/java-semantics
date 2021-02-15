#!/bin/bash

#jardir="$(dirname "$BASH_SOURCE")"
jardir="$(dirname "$(readlink -f "$0")")"
#echo $jardir

java -jar $jardir/alk.jar ${@:1}
exit 0
