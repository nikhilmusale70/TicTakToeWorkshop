package com.bridgelabz.tictaktoe;

import java.util.Scanner;

public class TicTacToeRunner {

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        while(true) {
            int playAnother =1;
            if(playAnother==1) {
                char[] board = ticTacToeGame.createBoard();

                char userSymbol = ticTacToeGame.chooseSymbol();
                char computerSymbol = (userSymbol == 'x') ? 'o' : 'x';

                System.out.println("User symbol is:- " + userSymbol);
                System.out.println("Computer symbol is:- " + computerSymbol);


                int choice = ticTacToeGame.coinToss();

                HumanChance human = new HumanChance();
                ComputerChance computerChance = new ComputerChance();

                while (ticTacToeGame.isBoardFull(board)) {
                    if (choice == 1) {
                        choice = 0;
                        human.humanPlay(board, userSymbol);
                        ticTacToeGame.resultOfMove(board, userSymbol, computerSymbol);
                        if (TicTacToeGame.flag == 1)
                            break;
                    } else {
                        choice = 1;
                        computerChance.computerChance(board, computerSymbol, userSymbol);
                        ticTacToeGame.resultOfMove(board, userSymbol, computerSymbol);
                        if (TicTacToeGame.flag == 2)
                            break;
                    }
                }

                if (ticTacToeGame.isBoardFull(board) == false) {
                    System.out.println("Game tied");
                }

                System.out.println("Let's play another game \nPress 1. Another game\nPress 2. End game");
                Scanner obj = new Scanner(System.in);
                playAnother = obj.nextInt();
            }

            if (playAnother==2)
                break;
        }
    }
}
