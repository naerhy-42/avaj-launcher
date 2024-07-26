NAME = avaj-launcher

SRC_DIR = src
BUILD_DIR = build

SRC = $(wildcard $(SRC_DIR)/*/*.java)

J = java
JFLAGS = -cp $(BUILD_DIR)
JC = javac
JCFLAGS = -d $(BUILD_DIR)

RM = rm -rf

all: $(NAME)

$(NAME): $(BUILD_DIR)
	$(JC) $(JCFLAGS) $(SRC)

$(BUILD_DIR):
	mkdir -p $@

run:
	$(J) $(JFLAGS) simulator.Simulator scenarios/1.txt

clean:
	$(RM) $(BUILD_DIR)

re: clean all

.PHONY: all clean re
