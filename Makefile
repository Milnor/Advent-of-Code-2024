JC=javac

all: src/InputParser.java src/Main.java
	$(JC) -d bin/ $^

clean:
	rm -rf bin/*

.PHONY: all clean
