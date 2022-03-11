CLASSPATH = lib/*:.

run: MarkdownParse.java MarkdownParseTest.java
	javac -g -cp $(CLASSPATH) MarkdownParse.java
	javac -cp $(CLASSPATH) MarkdownParseTest.java
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore MarkdownParseTest

test: MarkdownParse.class MarkdownParseTest.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

TryCommonMark.class: TryCommonMark.java
	javac -g -cp $(CLASSPATH) TryCommonMark.java
