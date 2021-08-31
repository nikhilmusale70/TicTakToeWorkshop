package com.bridgelabz.tictaktoe;

public class HumanChance {

    TicTacToeGame ticTacToeGameLogic = new TicTacToeGame();

    public void humanPlay(char[] board, char userSymbol){
        ticTacToeGameLogic.enterYourChoice(board,userSymbol);
        ticTacToeGameLogic.displayBoard(board);
    }
}
