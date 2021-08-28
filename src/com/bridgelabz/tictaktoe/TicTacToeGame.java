package com.bridgelabz.tictaktoe;

import java.util.Scanner;

public class TicTacToeGame {
    public char[] createBoard(){
        char[] board = new char[10];
        for (int i=1;i<=10;i++)
            board[i] = ' ';
        return board;
    }

    public char chooseSymbol(){
        System.out.println("Which symbol you want \n'x' or 'o'");
        Scanner sc = new Scanner(System.in);
        char userSymbol = sc.next().charAt(0);
        return userSymbol;
    }
}
