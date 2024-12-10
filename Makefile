JC=javac

all: src/Color.java src/InputParser.java src/Challenge.java src/Main.java
	$(JC) -d bin/ $^

clean:
	rm -rf bin/*

.PHONY: all clean
