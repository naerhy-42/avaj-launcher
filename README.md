# avaj-launcher

Implementation of a simple Java program according to a given class diagram written in UML.

## Description

First 42's project of the Java branch, **avaj-launcher** is an introduction to the language, the concept of UML diagrams, and object oriented design patterns.  
The objective is to implement a minimal aircraft simulation program based on a given UML diagram.

## Usage

Before being able to compile and run the program, you will have to install the **Java Development Kit** and the **Java Runtime Environment**.

```bash
# for Ubuntu
sudo apt update
sudo apt install default-jdk # JRE is included in the package

# check installation
java -version
javac -version
```

The program only accepts a single argument: the path to a scenario.  
The output of the simulation will be written to a file called `simulation.txt`, located at the root of the project.

```bash
# compile program
make

# run program on scenarios/1.txt
make run
```
