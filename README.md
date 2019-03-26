# Conquering U of C
This is based off Risk which is a strategy based board game. The goal of the game is to conquer all of the zones on the University of Calgary's campus by taking turns drafting, attacking, and fortifying to take buildings from other players.

## Getting Started (GUI)
Extract the "Demo3" zip file.\
Open command prompt, navigate into the "Demo3" folder, run the command to compile the files:


## Getting Started (Text-Based)
Extract the "Demo3 Text-Based" zip file.\
Open command prompt and navigate into "Demo3 Text-Based" folder, run the command to compile the files:
```
javac *.java
````
Then to play the game, run the command:
```
java Game
```

## How to Play
To begin, the user will pick a number of players for the game. Next they will give a name to each player and set each player to human or AI. The game begins by placing troops into given buildings that have been randomly assigned. The turns will rotate through the players going through drafting, attacking, and fortifying phases to conquer as many buildings as they can. The game is user friendly and will give instructions throughout the game to guide the player. When the game is won, the game will end automatically.

## Running Tests
To test certain logic classes, make sure that all files are present in a location:
- Java test file
  - BoardTest, CountryTest, DiceTest, PlayerTest (Located in /Demo3/src/test)
- Java file to be tested
  - Board, Country, Dice, Player (Located in /Demo3/src/logic)
- junit-4.12.jar
- hamcrest-core-1.3.jar

Open command prompt, navigate into the folder with all the files, run the commands in command prompt:
```
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test class>
```
For windows users run these commands instead:
```
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test class>
```

## Authors
- Israa Farouk
- Nicole Langevin
- Sophia Ngo
- Jana Osea
- Markus Pistner

## Acknowledgements
- Recreation of the game Risk by Hasbro
