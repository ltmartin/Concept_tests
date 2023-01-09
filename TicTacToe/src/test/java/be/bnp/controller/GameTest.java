package be.bnp.controller;

import be.bnp.Constants;
import be.bnp.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TicTacToe.class)
public class GameTest {
    @Autowired
    private Game gameController;

    @Test
    void newGame() {
        boolean result = gameController.newGame();
        Assertions.assertTrue(result);
    }


    @Test
    void validateActionTestEmptySpot() {
        gameController.setRow((byte) 0);
        gameController.setColumn((byte) 0);
        Assertions.assertTrue(gameController.validateAction());
    }

    @Test
    void performActionX_Turn() {
        gameController.setRow((byte) 0);
        gameController.setColumn((byte) 0);
        gameController.performAction();
        Assertions.assertEquals(Constants.X_MARK, gameController.getBoard()[gameController.getRow()][gameController.getColumn()]);
    }

    @Test
    void performActionY_Turn() {
        gameController.setX_turn(false);
        gameController.setRow((byte) 0);
        gameController.setColumn((byte) 0);
        gameController.performAction();
        Assertions.assertEquals(Constants.O_MARK, gameController.getBoard()[gameController.getRow()][gameController.getColumn()]);
    }

    @Test
    void checkStatus_XWins() {
        char[][] board = new char[3][3];
        board[0][0] = Constants.X_MARK;
        board[1][0] = Constants.X_MARK;
        board[2][0] = Constants.X_MARK;
        gameController.setBoard(board);
        Assertions.assertEquals(Constants.X_WINS, gameController.checkStatus());
    }

    @Test
    void checkStatus_OWins() {
        char[][] board = new char[3][3];
        board[2][0] = Constants.O_MARK;
        board[2][1] = Constants.O_MARK;
        board[2][2] = Constants.O_MARK;
        gameController.setBoard(board);
        Assertions.assertEquals(Constants.O_WINS, gameController.checkStatus());
    }

    @Test
    void checkStatus_OWinsMainDiagonal() {
        char[][] board = new char[3][3];
        board[0][0] = Constants.O_MARK;
        board[1][1] = Constants.O_MARK;
        board[2][2] = Constants.O_MARK;
        gameController.setBoard(board);
        Assertions.assertEquals(Constants.O_WINS, gameController.checkStatus());
    }

    @Test
    void checkStatus_OWinsSecondaryDiagonal() {
        char[][] board = new char[3][3];
        board[0][2] = Constants.O_MARK;
        board[1][1] = Constants.O_MARK;
        board[2][0] = Constants.O_MARK;
        gameController.setBoard(board);
        Assertions.assertEquals(Constants.O_WINS, gameController.checkStatus());
    }

    @Test
    void checkStatus_fullBoardDraw() {
        char[][] board = new char[3][3];
        board[0][0] = Constants.O_MARK;
        board[0][1] = Constants.X_MARK;
        board[0][2] = Constants.O_MARK;
        board[1][0] = Constants.X_MARK;
        board[1][1] = Constants.O_MARK;
        board[1][2] = Constants.X_MARK;
        board[2][0] = Constants.X_MARK;
        board[2][1] = Constants.O_MARK;
        board[2][2] = Constants.X_MARK;
        gameController.setBoard(board);
        Assertions.assertEquals(Constants.TIE, gameController.checkStatus());
    }

    @Test
    void checkStatus_fullBoardContinue() {
        char[][] board = new char[3][3];
        board[0][0] = Constants.O_MARK;
        board[0][1] = Constants.X_MARK;
        board[0][2] = Constants.O_MARK;
        board[1][0] = Constants.X_MARK;
        board[1][1] = Constants.EMPTY_CHARACTER;
        board[1][2] = Constants.X_MARK;
        board[2][0] = Constants.O_MARK;
        board[2][1] = Constants.X_MARK;
        board[2][2] = Constants.O_MARK;
        gameController.setBoard(board);
        Assertions.assertEquals(Constants.CONTINUE, gameController.checkStatus());
    }
}
