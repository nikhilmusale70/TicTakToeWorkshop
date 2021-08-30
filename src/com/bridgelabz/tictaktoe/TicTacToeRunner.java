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


        int choice = ticTacToeGame.coinToss();

        ticTacToeGame.enterYourChoice(board,userSymbol);
        ticTacToeGame.displayBoard(board);

        ticTacToeGame.resultOfMove(board,userSymbol);

        ticTacToeGame.displayBoard(board);



    }
}
