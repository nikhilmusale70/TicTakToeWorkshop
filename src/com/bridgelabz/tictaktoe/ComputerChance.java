package com.bridgelabz.tictaktoe;

public class ComputerChance {
    char [] board;
    char computerSymbol;
    TicTacToeGame ticTacToeGame = new TicTacToeGame();
    ComputerChance(char[] board, char computerSymbol){
        this.board=board;
        this.computerSymbol=computerSymbol;
    }
    public void computerCHance(char[] board, char computerSymbol){
        ticTacToeGame.computerPlay(board,computerSymbol);

    }
}
