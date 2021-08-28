package com.bridgelabz.tictaktoe;

import com.sun.deploy.security.SelectableSecurityManager;

public class TicTacToeRunner {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        char[] board = ticTacToeGame.createBoard();
        char userSymbol = ticTacToeGame.chooseSymbol();
        char computerSymbol;
        if (userSymbol=='x')
            computerSymbol = 'o';
        else
            computerSymbol = 'x';
    }
}
