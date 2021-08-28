package com.bridgelabz.tictaktoe;

public class TicTacToeGame {
    public void board(){
        char[] board = new char[10];
        for (int i=1;i<=10;i++)
            board[i] = ' ';
    }
}
