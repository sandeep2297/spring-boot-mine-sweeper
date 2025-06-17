# Minesweeper (Java 17)

A console-based Minesweeper game implemented in Java 17, using clean code principles, SOLID design, and unit tests.

## Features
- Command-line grid-based game.
- Random mine placement up to 35%.
- Auto-displaying of adjacent blank tiles.
- Win/loss detection.
- User Input validation and parser.

## Technologies
- Java 17
- JUnit 5
- Maven

## How to Run

### Prerequisites:
- Java 17+
- Maven

### Build & Run
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass=com.springboot.gic.MineSweeperApplication # To Launch the application
mvn test #To run test cases
mvn install # To create jar