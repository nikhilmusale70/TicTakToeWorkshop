package com.bridgelabz.tictaktoe;

public class ComputerChance {

    TicTacToeGame ticTacToeGame = new TicTacToeGame();

    public void computerChance(char[] board, char computerSymbol, char userSymbol){
        ticTacToeGame.computerPlay(board,computerSymbol,userSymbol);
        System.out.println();
        System.out.print("Computer Played :- ");
        ticTacToeGame.displayBoard(board);

    }
}
