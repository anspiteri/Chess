# Chess

This is my first ever Java project. It's a chess game made within the processing library (specifically processing.core and processing.data) in Java 8. 
I'm unsure how complete it will become but for now I'm just tinkering for my own learning. 

## Features

- Chess board is drawn to screen as a tile array.
- Chess pieces are loaded in as sprites.
- Classes grouping together relevant logic.
- Test suite. 

## Installing

### Prerequisites

- **Java Development Kit (JDK)**: Make sure you have JDK 8 or higher installed.
  - Windows you can install from Oracle's website. (https://www.oracle.com/java/technologies/downloads/archive/).
  - Unix: You can use SDKMAN! (https://sdkman.io/).
- **Gradle**: This project uses the Gradle Wrapper, so you don't need to install Gradle manually.

## Usage
The root directory holds both the Windows and Unix gradle wrapper files. To build and run the 
project use the following commands in the project root directory. 
- Unix based systems: `./gradlew build` and  `./gradlew run`.
- Windows: `gradlew.bat` and `gradlew.bat run`.

## Testing 
- This project uses jacoco.
- To generate the testing code coverage report with gradle using jacoco, run
`gradle test jacocoTestReport`.

## License

- This project is licensed under the [MIT License](LICENSE).
