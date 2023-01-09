package be.bnp.controller;

import be.bnp.Constants;
import be.bnp.checkers.StatusChecker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Scanner;

@Component
@Lazy
public class Game {
    @Value("${tictactoe.testing}")
    private boolean testing;
    private char[][] board;
    private boolean isX_turn;
    private byte row;
    private byte column;
    private boolean gameEnded;
    @Resource
    @Qualifier("horizontal")
    private StatusChecker horizontalChecker;
    @Resource
    @Qualifier("vertical")
    private StatusChecker verticalChecker;
    @Resource
    @Qualifier("mainDiagonal")
    private StatusChecker mainDiagonalChecker;
    @Resource
    @Qualifier("secondaryDiagonal")
    private StatusChecker secondaryDiagonalChecker;
    @Resource
    @Qualifier("fullBoard")
    private StatusChecker fullBoardChecker;

    @PostConstruct
    protected boolean newGame() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = Constants.EMPTY_CHARACTER;

        isX_turn = true;
        gameEnded = false;
        row = Constants.INITIAL_COORDINATE;
        column = Constants.INITIAL_COORDINATE;
        paintBoard();

        return true;
    }

    public void play() {
        // this check is performed to avoid console interaction while testing
        if (!testing) {
            while (!gameEnded) {
                readAction();
                if (validateAction()) {
                    performAction();
                    paintBoard();
                    byte status = checkStatus();
                    if (status != Constants.CONTINUE) {
                        gameEnded = true;
                        paintBoard();
                        showResult(status);
                    }
                } else
                    System.out.println("Sorry, that spot is taken, please type other coordinates.");
            }
        }
    }

    protected void showResult(byte status) {
        switch (status) {
            case Constants.X_WINS: {
                System.out.println("X is the winner");
                break;
            }
            case Constants.O_WINS: {
                System.out.println("O is the winner");
                break;
            }
            case Constants.TIE: {
                System.out.println("The game is a draw");
                break;
            }
        }
    }

    protected byte checkStatus() {
        byte horizontalStatus = horizontalChecker.checkStatus(board);
        byte verticalStatus = verticalChecker.checkStatus(board);
        byte mainDiagonalStatus = mainDiagonalChecker.checkStatus(board);
        byte secondaryDiagonalStatus = secondaryDiagonalChecker.checkStatus(board);
        byte fullBoardStatus = fullBoardChecker.checkStatus(board);

        if ((horizontalStatus == Constants.CONTINUE) && (verticalStatus == Constants.CONTINUE) &&
                (mainDiagonalStatus == Constants.CONTINUE) && (secondaryDiagonalStatus == Constants.CONTINUE) &&
                (fullBoardStatus == Constants.CONTINUE))
            return Constants.CONTINUE;
        else if (horizontalStatus != Constants.CONTINUE)
            return horizontalStatus;
        else if (verticalStatus != Constants.CONTINUE)
            return verticalStatus;
        else if (mainDiagonalStatus != Constants.CONTINUE)
            return mainDiagonalStatus;
        else if (secondaryDiagonalStatus != Constants.CONTINUE)
            return secondaryDiagonalStatus;
        else return fullBoardStatus;
    }

    protected void performAction() {
        if (isX_turn)
            board[row][column] = Constants.X_MARK;
        else
            board[row][column] = Constants.O_MARK;

        isX_turn = !isX_turn;
    }

    protected boolean validateAction() {
        return board[row][column] == Constants.EMPTY_CHARACTER;
    }

    protected void readAction() {
        boolean validValues;
        if (isX_turn)
            System.out.println("It is X turn");
        else
            System.out.println("It is O turn");

        do {
            System.out.println("Please introduce the row and column (both with values between 0 and 2 inclusive) where you want to play separated by space: ");
            Scanner stdin = new Scanner(System.in);
            try {
                row = stdin.nextByte();
                column = stdin.nextByte();
            } catch (Exception e) {
                System.out.println("Positions need to be between 0 and 2, inclusive.");
            }
            validValues = validateEntry(row, column);
            if (!validValues)
                System.out.println("Please, provide valid values");

        } while (!validValues);
    }

    private boolean validateEntry(byte row, byte column) {
        return ((row >= 0) && (row <= 2) && (column >= 0) && (column <= 2));
    }

    private void paintBoard() {
        System.out.println("================================");
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-----");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-----");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("================================");
    }

    public void setRow(byte row) {
        this.row = row;
    }

    public void setColumn(byte column) {
        this.column = column;
    }

    public byte getRow() {
        return row;
    }

    public byte getColumn() {
        return column;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setX_turn(boolean x_turn) {
        isX_turn = x_turn;
    }
}
