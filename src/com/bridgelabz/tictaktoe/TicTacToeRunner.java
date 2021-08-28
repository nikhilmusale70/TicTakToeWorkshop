package com.bridgelabz.tictaktoe;

import com.sun.deploy.security.SelectableSecurityManager;

public class TicTacToeRunner {

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        char[] board = ticTacToeGame.createBoard();

        char userSymbol = ticTacToeGame.chooseSymbol();
        char computerSymbol = (userSymbol=='x')?'o':'x';

        System.out.println("User symbol is:- " + userSymbol);
        System.out.println("Computer symbol is:- " + computerSymbol);

        ticTacToeGame.displayBoard(board);


        int index=0;
        while(index==0) {
            index = ticTacToeGame.makeUserChoice(board, userSymbol);
            if (index==1)
                System.out.println("Index is free, and your choice is registered");

            else
                System.out.println("Index is not free, and please enter another index");
        }
    }
}
