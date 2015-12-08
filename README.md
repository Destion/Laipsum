#L**ai**psum
###A Naive Bayes Classifier made by Mick en Gerben

####In code functions
In code functions of the Classifier and related classes:
- Train the classifier using texts and custom classes.
- More than 2 classes supported.
- Query the most propable class for a document.
- Load and save the data to csv like files.

####Current executable Java Classes:
- test.TestMultipleClasses: Displays the use of 3 classes and the file I/O
- test.TestBlogs: Trains the classifier on the blog dataset and returns it's performance on a small testset.
- test.TestMails: Does the same as TestBlogs, but with the mails dataset.
- Main: This file is here to ensure we don't get too serious.

####How to execute a Class:
A step by step explaination:
- Download and install Java Version 8 (make sure it is actually 8!!!)
- Make sure that the commandline "java" command is actually java 8
- Double check the previous statement
- Get the files from github
- Use javac to compile the sources (located in the src/java folder!)
- Go to the folder containing the binaries (your compile target directory)
- Use java -classpath . package.ClassName to execute a file (So for instance "java -classpath . test.TestMails")
- Enjoy!
