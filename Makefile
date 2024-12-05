JC=javac

all: InputParser.java AoC2024.java
	$(JC) $^

clean:
	rm -f *.class

.PHONY: all clean
