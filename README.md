## IF you don't see any changes in the file and the program even after changing the code
## Do the following 
We need to flush and close to write
Delete all the class file if your file isn't working

## This will find the file with .class extension 
find . -name "*.bak" -type f

## This will delete the .class files and you are ready to go
find . -name "*.bak" -type f -delete


