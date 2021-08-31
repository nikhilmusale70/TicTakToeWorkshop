package com.bridgelabz.tictaktoe;

public class TicTacToeRunner {

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        char[] board = ticTacToeGame.createBoard();

        char userSymbol = ticTacToeGame.chooseSymbol();
        char computerSymbol = (userSymbol=='x')?'o':'x';

        System.out.println("User symbol is:- " + userSymbol);
        System.out.println("Computer symbol is:- " + computerSymbol);


        int choice = ticTacToeGame.coinToss();
        HumanChance human = new HumanChance();
        human.humanPlay(board,userSymbol);

//        ticTacToeGame.humanPlay(board,userSymbol);
//
//        ticTacToeGame.enterYourChoice(board,userSymbol);
//        ticTacToeGame.displayBoard(board);

        //ticTacToeGame.resultOfMove(board,userSymbol, computerSymbol);

        //ticTacToeGame.displayBoard(board);



    }
}
