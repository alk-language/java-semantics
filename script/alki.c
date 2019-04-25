#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char* args[])
{
    printf("%s\n", args[0]);
    int i = strlen(args[0]);
    while 
    char* ars[argc+3];

    char *ar0 = "-jar";
    char *ar1 = "alk.jar";
    ars[0]="java";
    ars[1]=ar0;
    ars[2]=ar1;
    for (int i=1; i<argc; i++)
        ars[i+2]=args[i];
    ars[argc+2] = NULL;
    execvp("java", ars);
    return 0;
}