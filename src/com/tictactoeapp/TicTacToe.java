package com.tictactoeapp;

public class TicTacToe {

    // Instance Variables
    private final char[][] board;
    private int turns;

    // Constructors
    public TicTacToe() {
        board = new char[3][3];
        turns = 0;

        // Nested for loop that sets the board to empty values. Changed variables to x and y so code is easier to
        // understand for a casual reader
        for ( int x=0; x<3; x++ )
            for ( int y=0; y<3; y++ )
                board[x][y] = ' ';
    }

    // Accessor Methods
    public boolean isWinner( char p ) {
        return checkRows(p) || checkColumns(p) || checkDiagonally(p);
    }

    // Method that will only return true if all characters in a row are the same
    private boolean checkRows(char p) {
        return playerAt(0, 0) == p && playerAt(0, 1) == p && playerAt(0, 2) == p
                || playerAt(1, 0) == p && playerAt(1, 1) == p && playerAt(1, 2) == p
                || playerAt(2, 0) == p && playerAt(2, 1) == p && playerAt(2, 2) == p;
    }

    // Method that will only return true if all characters in a column are the same
    private boolean checkColumns(char p) {
        return playerAt(0, 0) == p && playerAt(1, 0) == p && playerAt(2, 0) == p
                || playerAt(0, 1) == p && playerAt(1, 1) == p && playerAt(2, 1) == p
                || playerAt(0, 2) == p && playerAt(1, 2) == p && playerAt(2, 2) == p;
    }

    // Method that will only return true if all characters diagonally are the same
    private boolean checkDiagonally(char p) {
        return playerAt(0, 0) == p && playerAt(1, 1) == p && playerAt(2, 2) == p
                || playerAt(0, 2) == p && playerAt(1, 1) == p && playerAt(2, 0) == p;
    }

    // Method that will return true if the board is full
    public boolean isFull() {
        return turns == 9;
    }

    // Method that returns true if 9 spaces have been filled but no winner is determined
    public boolean isCat() {
        return isFull() && !isWinner('X') && !isWinner('O');
    }

    // Method that returns true if the player is entering numbers that correlate to a spot on the board
    public boolean isValid( int x, int y ) {
        return 0 <= x && x <= 2 && 0 <= y && y <= 2;
    }

    // Method that returns the number of turns
    public int numTurns() {
        return this.turns;
    }

    //
    public char playerAt( int x, int y ) {
        return isValid(x, y) ? board[x][y] : '@';
    }

    // Prints the board to the console
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove( char p, int x, int y ) {
        this.board[x][y] = p;
        // Increase number of turns with each move
        turns++;
    }

}
