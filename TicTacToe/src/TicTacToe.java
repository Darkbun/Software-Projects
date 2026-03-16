import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "x";
    String playerO = "O";
    String currentPlayer = playerX;
    boolean gameOver = false;
    int turns = 0;


    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for(int r =0; r<3; r++){
            for(int c=0; c<3; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText() == "") {
                            tile.setText(playerX);
                            turns++;
                            checkWinner();
                            if(!gameOver) {
                                currentPlayer = playerO;
                                textLabel.setText("Computer's turn");
                                Timer timer = new Timer(300, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        computerMove();
                                    }
                                });
                                timer.setRepeats(false);
                                timer.start();
                            }

                        }
                    }
                });

            }
        }

    }

    void checkWinner() {
        //horizontal
        for(int r=0; r<3; r++){
            if(board[r][0].getText() == "")continue;

            if(board[r][0].getText() == board[r][1].getText() &&
                board[r][1].getText() == board[r][2].getText()){

                for(int i=0; i<3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        //vertical
        for(int c=0; c<3; c++){
            if(board[0][c].getText() == "")continue;

            if(board[0][c].getText() == board[1][c].getText() &&
                    board[1][c].getText() == board[2][c].getText()){

                for(int i=0; i<3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        //Diagonally
        if(board[0][0].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][2].getText() &&
            board[0][0].getText() != ""){

            for(int i=0; i<3; i++) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }

        //AntiDiagonally
        if(board[0][2].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][0].getText() &&
            board[0][2].getText() != ""){

            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }

        if(turns == 9){
            for(int r = 0; r<3; r++) {
                for(int c = 0; c<3; c++) {
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }

    }

    void setWinner(JButton tile) {
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.GRAY);
        String winner = tile.getText();
        textLabel.setText(winner + " is the winner!");
//        textLabel.setText(currentPlayer + " is the winner!");
    }

    void setTie(JButton tile) {
        tile.setForeground(Color.ORANGE);
        tile.setBackground(Color.GRAY);
        textLabel.setText("It's a tie");
    }

    void computerMove() {
        if(gameOver) return;

        if (tryWinOrBlock(playerO)) return;
        if (tryWinOrBlock(playerX)) return;

        int r,c;
        while(true) {
            r = (int)(Math.random() *3);
            c = (int)(Math.random() *3);

            if(board[r][c].getText().isEmpty()) {
                board[r][c].setText(playerO);
                turns++;
                break;
            }

        }
        finalizeComputerTurn();
    }

    boolean tryWinOrBlock(String symbol) {

        // check rows
        for (int r = 0; r < 3; r++) {
            int countSymbol = 0, countEmpty = 0, emptyCol = -1;
            for (int c = 0; c < 3; c++) {
                if (board[r][c].getText().equals(symbol)) countSymbol++;
                if (board[r][c].getText().isEmpty()) {
                    countEmpty++;
                    emptyCol = c;
                }
            }
            if (countSymbol == 2 && countEmpty == 1) {
                board[r][emptyCol].setText(playerO);
                turns++;
                finalizeComputerTurn();
                return true;
            }
        }

        // check columns
        for (int c = 0; c < 3; c++) {
            int countSymbol = 0, countEmpty = 0, emptyRow = -1;
            for (int r = 0; r < 3; r++) {
                if (board[r][c].getText().equals(symbol)) countSymbol++;
                if (board[r][c].getText().isEmpty()) {
                    countEmpty++;
                    emptyRow = r;
                }
            }
            if (countSymbol == 2 && countEmpty == 1) {
                board[emptyRow][c].setText(playerO);
                turns++;
                finalizeComputerTurn();
                return true;
            }
        }

        // check main diagonal
        int countSymbol = 0, countEmpty = 0, emptyIndex = -1;
        for (int i = 0; i < 3; i++) {
            if (board[i][i].getText().equals(symbol)) countSymbol++;
            if (board[i][i].getText().isEmpty()) {
                countEmpty++;
                emptyIndex = i;
            }
        }
        if (countSymbol == 2 && countEmpty == 1) {
            board[emptyIndex][emptyIndex].setText(playerO);
            turns++;
            finalizeComputerTurn();
            return true;
        }

        // check anti diagonal
        countSymbol = 0; countEmpty = 0; emptyIndex = -1;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i].getText().equals(symbol)) countSymbol++;
            if (board[i][2 - i].getText().isEmpty()) {
                countEmpty++;
                emptyIndex = i;
            }
        }
        if (countSymbol == 2 && countEmpty == 1) {
            board[emptyIndex][2 - emptyIndex].setText(playerO);
            turns++;
            finalizeComputerTurn();
            return true;
        }

        return false;
    }

    void finalizeComputerTurn() {
        checkWinner();
        if(!gameOver){
            currentPlayer = playerX;
            textLabel.setText("X's turn");
        }
    }



}












//import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        char[][] board = new char[3][3];
//        for(int row=0; row< board.length; row++) {
//            for(int col=0; col< board[row].length; col++) {
//                board[row][col] = ' ';
//            }
//        }
//        char player = 'X';
//        boolean gameOver = false;
//
//        Scanner scanner = new Scanner(System.in);
//
//        while(!gameOver){
//            printBoard(board);
//            System.out.println("Player " + player + "enter: ");
//            int row = scanner.nextInt();
//            int col = scanner.nextInt();
//
//            if(board[row][col] == ' ') {
//                board[row][col] = player;
//                gameOver = haveWon(board, player);
//                if(gameOver) {
//                    System.out.println("Player "+ player + " has won: ");
//                }
//                else {
//                    player = (player == 'X') ? '0' : 'X';
//                }
//            }
//            else {
//                System.out.println("Invalid move. Try again!");
//            }
//        }
//        printBoard(board);
//    }
//
//    public static boolean haveWon(char[][] board, char player) {
//        for(int row=0; row< board.length; row++) {
//            if((board[row][0] == player) && (board[row][1] == player) && (board[row][2] == player)) {
//                return true;
//            }
//        }
//        for(int col=0; col< board.length; col++) {
//            if((board[0][col] == player) && (board[1][col] == player) && (board[2][col] == player)) {
//                return true;
//            }
//        }
//        // Diagonal
//        if(board[0][0] ==player && board[1][1] ==player && board[2][2] ==player){
//            return true;
//        }
//        if(board[0][2] ==player && board[1][1] ==player && board[2][0] ==player){
//            return true;
//        }
//
//        return false;
//
//    }
//
//    public static void printBoard(char[][] board) {
//        for(int row=0; row< board.length; row++) {
//            for (int col = 0; col < board[row].length; col++) {
//                System.out.print(board[row][col] + "| ");
//            }
//            System.out.println();
//        }
//    }
//}