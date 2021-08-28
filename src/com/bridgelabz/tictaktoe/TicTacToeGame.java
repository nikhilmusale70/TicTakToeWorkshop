package com.bridgelabz.tictaktoe;

import java.util.Scanner;

public class TicTacToeGame {

    public char[] createBoard(){
        char[] board = new char[10];
        for (int i=1;i<board.length;i++)
            board[i] = ' ';
        return board;
    }

    public char chooseSymbol(){
        System.out.print("Which symbol you want \n\t'x' or 'o'\nEnter here :- ");
        Scanner sc = new Scanner(System.in);
        char userSymbol = sc.next().charAt(0);
        return userSymbol;
    }
}
