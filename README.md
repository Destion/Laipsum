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

####How to execute a Class:
A step by step explanation:
- Download and install Java Version 8 (make sure it is actually 8!!!)
- Make sure that the commandline "java" command is actually java 8
- Double check the previous statement (protip: use java -version)
- Get the files from github
- Go to the main folder (where the src folder is)
- Use javac to compile the sources (javac src/java/\*/\*.java)
- Use java -classpath src/java/ package.ClassName to execute a file (So for instance "java -classpath src/java/ test.TestMails")
- Enjoy!
