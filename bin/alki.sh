	#!/bin/bash

TARGET_FILE=$0
ORIG=`pwd -P`


cd `dirname $TARGET_FILE`
TARGET_FILE=`basename $TARGET_FILE`

# Iterate down a (possible) chain of symlinks
while [ -L "$TARGET_FILE" ]
do
    TARGET_FILE=`readlink $TARGET_FILE`
    cd `dirname $TARGET_FILE`
    TARGET_FILE=`basename $TARGET_FILE`
done

# Compute the canonicalized name by finding the physical path
# for the directory we're in and appending the target file.
PHYS_DIR=`pwd -P`
cd "$ORIG"
export PATH="$PATH:$PHYS_DIR:$PHYS_DIR/lib"
export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:$PHYS_DIR:$PHYS_DIR/lib"
export DYLD_LIBRARY_PATH="$DYLD_LIBRARY_PATH:$PHYS_DIR:$PHYS_DIR/lib"
java -Djava.library.path="$PHYS_DIR:$PHYS_DIR/lib" -cp "$PHYS_DIR/alk.jar:$PHYS_DIR/lib/com.microsoft.z3.jar" main.ExecutionDriver "${@:1}"
exit 0
