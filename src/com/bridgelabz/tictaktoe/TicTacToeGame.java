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

    public void computerPlay(char[] board, char computerSymbol){
        Random ran = new Random();
        int index = 0;
        index = ifICanWin(board,computerSymbol);
        if (index == 0){
            while (true){
                index = ran.nextInt(10) + 1;
                if(checkIfEmpty(board,index)) {
                    assigningChoiceToBoard(board, index, computerSymbol);
               //     return index;
                    break;
                }
            }
        }
        else {
            assigningChoiceToBoard(board, index, computerSymbol);
        }
    }
    public int ifICanWin(char[] board, char computerSymbol){
        if (((board[1]==board[2])&&(board[2]==computerSymbol)) && checkIfEmpty(board,3) ){  //topRow
            return 3;
        }
        if (((board[1]==board[3])&&(board[3]==computerSymbol)) && checkIfEmpty(board,2) ){
            return 2;
        }
        if (((board[2]==board[3])&&(board[3]==computerSymbol)) && checkIfEmpty(board,1) ){
            return 1;
        }

        if (((board[4]==board[5])&&(board[5]==computerSymbol)) && checkIfEmpty(board,6) ){  //midRow
            return 6;
        }
        if (((board[4]==board[6])&&(board[6]==computerSymbol)) && checkIfEmpty(board,5) ){
            return 5;
        }
        if (((board[5]==board[6])&&(board[6]==computerSymbol)) && checkIfEmpty(board,4) ){
            return 1;
        }

        if (((board[7]==board[8])&&(board[8]==computerSymbol)) && checkIfEmpty(board,9) ){  //bottomRow
            return 3;
        }
        if (((board[7]==board[9])&&(board[9]==computerSymbol)) && checkIfEmpty(board,8) ){
            return 2;
        }
        if (((board[8]==board[9])&&(board[9]==computerSymbol)) && checkIfEmpty(board,7) ){
            return 1;
        }

        //columns
        if (((board[1]==board[4])&&(board[4]==computerSymbol)) && checkIfEmpty(board,7) ){  //1stColumn
            return 7;
        }
        if (((board[1]==board[7])&&(board[7]==computerSymbol)) && checkIfEmpty(board,4) ){
            return 4;
        }
        if (((board[7]==board[4])&&(board[4]==computerSymbol)) && checkIfEmpty(board,1) ){
            return 1;
        }

        if (((board[2]==board[5])&&(board[5]==computerSymbol)) && checkIfEmpty(board,8) ){  //2nd column
            return 8;
        }
        if (((board[2]==board[8])&&(board[8]==computerSymbol)) && checkIfEmpty(board,5) ){
            return 5;
        }
        if (((board[5]==board[8])&&(board[8]==computerSymbol)) && checkIfEmpty(board,2) ){
            return 2;
        }

        if (((board[3]==board[6])&&(board[6]==computerSymbol)) && checkIfEmpty(board,9) ){  //3rd column
            return 9;
        }
        if (((board[3]==board[9])&&(board[9]==computerSymbol)) && checkIfEmpty(board,6) ){
            return 6;
        }
        if (((board[6]==board[9])&&(board[9]==computerSymbol)) && checkIfEmpty(board,3) ){
            return 3;
        }

        //diagonals
        if (((board[1]==board[5])&&(board[5]==computerSymbol)) && checkIfEmpty(board,9) ){  //1st diagonal
            return 9;
        }
        if (((board[1]==board[9])&&(board[9]==computerSymbol)) && checkIfEmpty(board,5) ){
            return 5;
        }
        if (((board[5]==board[9])&&(board[9]==computerSymbol)) && checkIfEmpty(board,1) ){
            return 1;
        }

        if (((board[3]==board[5])&&(board[5]==computerSymbol)) && checkIfEmpty(board,7) ){  //2nd diagonal
            return 7;
        }
        if (((board[3]==board[7])&&(board[7]==computerSymbol)) && checkIfEmpty(board,5) ){
            return 5;
        }
        if (((board[5]==board[7])&&(board[7]==computerSymbol)) && checkIfEmpty(board,3) ){
            return 3;
        }

        return 0;
    }

    public void assigningChoiceToBoard(char[] board, int index, char userSymbol){
        board[index] = userSymbol;
    }



    public void resultOfMove(char[] board, char userSymbol,char compySymbol){
        checkGameWonOrNot(board,userSymbol);
        if (flag==1){
            if (userSymbol=='x')
                System.out.println("You Won the game");
            else
                System.out.println("Computer won the game");
        }
        else
            switchChance(board,compySymbol);
    }

    public void switchChance(char[] board, char compSymbol){
        System.out.println("Chance are switched");
        //computerPlay(board, compSymbol);
        //int a=0;

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
