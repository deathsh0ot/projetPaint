JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	
CLASSES = \
	  powd/ColorsChooser.java \
	  powd/CanvasPanel.java \
	  powd/Painter.java \
	  powd/Powd.java \
	  powd/ConfigFrame.java \
	  powd/ToolsPanel.java \
	  
	  
	  
	  
	  
default: classes jar

classes: $(CLASSES:.java=.class)
	
clean:
	$(RM) powd/*.class powd/*.java~
jar:
	echo 'Main-Class: powd/Powd' > Mainclass.txt
	jar -cmf Mainclass.txt powd.jar powd/*.class