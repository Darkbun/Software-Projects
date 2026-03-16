# Tic Tac Toe (Java Swing)

A desktop **Tic-Tac-Toe game built using Java Swing** where a human player (X) plays against a simple computer opponent (O).

The game features a graphical user interface and basic AI logic that tries to **win or block the player’s winning move**.

---

## Features

* GUI built using **Java Swing**
* Player vs Computer gameplay
* Computer AI that:

  * Tries to win when possible
  * Blocks the player’s winning move
  * Otherwise plays randomly
* Win detection:

  * Horizontal
  * Vertical
  * Diagonal
* Tie detection
* Visual highlighting of the winning line

---

## Technologies Used

* Java
* Java Swing (GUI)
* AWT Event Handling

---

## Game Logic

The game board is a **3×3 grid** created using `GridLayout`.
Each tile is represented by a `JButton`.

Game flow:

1. Player clicks a tile
2. The tile becomes **X**
3. Game checks for a winner
4. If the game continues, the computer makes a move (**O**)
5. Computer logic:

   * Try to win
   * Block player win
   * Otherwise choose a random empty tile

---

## Project Structure

```text
TicTacToe
│
├── src
│   ├── App.java
│   ├── TicTacToe.java
│   └── META-INF
│       └── MANIFEST.MF
│
└── README.md
```

---

## How to Run

### Compile

```bash
javac TicTacToe.java
```

### Run

```bash
java TicTacToe
```

A game window will open where you can play against the computer.

---

## Game Controls

* Click on an empty tile to place **X**
* The computer automatically plays **O**
* The game announces:

  * Winner
  * Tie

---

## Learning Outcomes

This project helped practice:

* Java Swing GUI development
* Event handling in Java
* Game logic implementation
* Basic AI decision making
* Grid-based board design

---

## Possible Improvements

Future improvements could include:

* Minimax AI algorithm
* Player vs Player mode
* Restart button
* Score tracking
* Improved UI styling
