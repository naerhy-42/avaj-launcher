NAME = avaj-launcher

SRC_DIR = src
BUILD_DIR = build

SRC = $(wildcard $(SRC_DIR)/*/*.java)

JC = javac
JFLAGS = -d $(BUILD_DIR)

RM = rm -rf

all: $(NAME)

$(NAME): $(BUILD_DIR)
	$(JC) $(JFLAGS) $(SRC)

$(BUILD_DIR):
	mkdir -p $@

clean:
	$(RM) $(BUILD_DIR)

re: clean all

.PHONY: all clean re
