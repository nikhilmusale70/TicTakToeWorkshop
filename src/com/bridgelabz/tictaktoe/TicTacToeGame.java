package com.bridgelabz.tictaktoe;

import java.time.chrono.MinguoDate;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    public static int flag;
    public static int count;

    public char[] createBoard() {
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++)
            board[i] = '_';
        return board;
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



    public void resultOfMove(char[] board, char userSymbol){
        checkGameWonOrNot(board,userSymbol);
        if (flag==1){
            if (userSymbol=='x')
                System.out.println("You Won the game");
            else
                System.out.println("Computer won the game");
        }
        else
            switchChance();
    }

    public void switchChance(){
        System.out.println("Chance are switched");
        computerPlaysNow(){

        }
    }

    public boolean isBoardFull(char[] board){                            //for tie
        count =0;
        for (int i=1;i<10;i++)
            if ((board[i]=='x') || board[i]=='o')
                count++;

        if (count==9)
            return true;
        else
            return false;
    }

    public void checkGameWonOrNot(char[] board,char userSymbol){        //won condition
        flag=0;
        if((board[1]==board[2])&&(board[2]==board[3])&&(board[3]==userSymbol)  ||     //toprow
           (board[4]==board[5])&&(board[5]==board[6])&&(board[6]==userSymbol)  ||     //midrow
           (board[7]==board[8])&&(board[8]==board[9])&&(board[9]==userSymbol)  ||     //bottomrow
           (board[1]==board[4])&&(board[4]==board[7])&&(board[7]==userSymbol)  ||     //firstColumn
           (board[2]==board[5])&&(board[5]==board[8])&&(board[8]==userSymbol)  ||     //middleColumn
           (board[3]==board[6])&&(board[6]==board[9])&&(board[9]==userSymbol)  ||     //lastColumn
           (board[1]==board[5])&&(board[5]==board[9])&&(board[9]==userSymbol)  ||     //firstDiagonal
           (board[3]==board[5])&&(board[5]==board[7])&&(board[7]==userSymbol)         //secondDiagonal
        ){
            System.out.print("Game won by ");
            flag=1;
        }

    }
}
