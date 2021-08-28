package com.bridgelabz.tictaktoe;

import java.util.Scanner;

public class TicTacToeGame {

    public char[] createBoard() {
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++)
            board[i] = '_';
        return board;
    }

    public char chooseSymbol() {
        System.out.print("Which symbol you want \n\t'x' or 'o'\nEnter here :- ");
        Scanner sc = new Scanner(System.in);
        char userSymbol = sc.next().charAt(0);
        return userSymbol;
    }

    public void displayBoard(char[] board) {
        for (int i = 1; i < board.length; i = i + 3) {
            System.out.println();
            int j = 0;
            while (j < 3) {
                System.out.print(board[i + j] + " ");
                j++;
            }
        }
    }

    public boolean checkIfEmpty(char[] board, int index){
        if (board[index] == '_')
            return true;
        else
            return false;
    }

    public char[] makeUserChoice(char[] board, char userSymbol){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice from 1-9 :-");
        int index = sc.nextInt();

        if(checkIfEmpty(board,index)){
            board[index]=userSymbol;
            System.out.println("empty");
        }

        return board;
    }
}
