## RUN MAIN.JAVA
Run Main.java 

## Avoid using Global variable, Try to use maximum local variable 
This will consume your memory and as a result:
Exception in thread "AWT-EventQueue-0" java.lang.OutOfMemoryError: Java heap space: failed reallocation of scalar replaced objects

## Add Data before using display button
There is no file attached, but once you add data it will create itself and you can use display button

## Add all the data 
If not you will face the : ArrayIndexOutOfBoundsException

## IF you don't see any changes in the file and the program even after changing the code
## Do the following 
We need to flush and close to write
Delete all the class file if your file isn't working

## This will find the file with .class extension 
find . -name "*.class" -type f

## This will delete the .class files and you are ready to go
find . -name "*.class" -type f -delete


