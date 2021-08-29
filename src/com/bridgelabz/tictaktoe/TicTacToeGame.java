package com.bridgelabz.tictaktoe;

import java.time.chrono.MinguoDate;
import java.util.Locale;
import java.util.Random;
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

    public void enterYourChoice(char[] board, char userSymbol) {
        int index = 0;
        while (true) {
            index = makeUserChoice(board, userSymbol);
            if (index != 0){
                System.out.println("Index is free, and your choice is registered");
                break;
            }
            else
                System.out.println("Index is not free, and please enter another index");
        }
    }

    public boolean checkIfEmpty(char[] board, int index){
        if (board[index] == '_')
            return true;
        else
            return false;
    }

    public int makeUserChoice(char[] board, char userSymbol){
        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter your choice from 1-9 :-");
        int index = sc.nextInt();

        if(checkIfEmpty(board,index)){
            assigningChoiceToBoard(board, index, userSymbol);
            return index;
        }
        else {
            return 0;
        }
    }

    public void assigningChoiceToBoard(char[] board, int index, char userSymbol){
        board[index] = userSymbol;
    }

    public int coinToss() {
        Random ran = new Random();
        System.out.print("Enter your choice (Heads or Tails):- ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().toLowerCase();

        int a = ran.nextInt(2);
        String toss = (a == 1) ? "heads" : "tails";
        if (choice.equals(toss)){
            System.out.println("You won the toss, you will play first");
            return 1;
        }
        else {
            System.out.println("Computer won the toss, computer will play first");
            return 0;
        }
    }
}
