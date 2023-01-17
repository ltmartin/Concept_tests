package be.ltmartin.tictactoerest.services;

import be.ltmartin.tictactoerest.Constants;
import be.ltmartin.tictactoerest.TicTacToeRestApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TicTacToeRestApplication.class)
public class GameServiceTest {
    @Autowired
    private GameService gameService;

    @Test
    void newGame() {
        boolean result = gameService.newGame();
        Assertions.assertTrue(result);
    }


    @Test
    void validateActionTestEmptySpot() {
        gameService.setRow((byte) 0);
        gameService.setColumn((byte) 0);
        Assertions.assertTrue(gameService.validateAction());
    }

    @Test
    void performActionX_Turn() {
        gameService.setRow((byte) 0);
        gameService.setColumn((byte) 0);
        gameService.performAction();
        Assertions.assertEquals(Constants.X_MARK, gameService.getBoard()[gameService.getRow()][gameService.getColumn()]);
    }

    @Test
    void performActionY_Turn() {
        gameService.setX_turn(false);
        gameService.setRow((byte) 0);
        gameService.setColumn((byte) 0);
        gameService.performAction();
        Assertions.assertEquals(Constants.O_MARK, gameService.getBoard()[gameService.getRow()][gameService.getColumn()]);
    }

    @Test
    void checkStatus_XWins() {
        Character[][] board = new Character[3][3];
        board[0][0] = Constants.X_MARK;
        board[1][0] = Constants.X_MARK;
        board[2][0] = Constants.X_MARK;
        gameService.setBoard(board);
        Assertions.assertEquals(Constants.X_WINS, gameService.checkStatus());
    }

    @Test
    void checkStatus_OWins() {
        Character[][] board = new Character[3][3];
        board[2][0] = Constants.O_MARK;
        board[2][1] = Constants.O_MARK;
        board[2][2] = Constants.O_MARK;
        gameService.setBoard(board);
        Assertions.assertEquals(Constants.O_WINS, gameService.checkStatus());
    }

    @Test
    void checkStatus_OWinsMainDiagonal() {
        Character[][] board = new Character[3][3];
        board[0][0] = Constants.O_MARK;
        board[1][1] = Constants.O_MARK;
        board[2][2] = Constants.O_MARK;
        gameService.setBoard(board);
        Assertions.assertEquals(Constants.O_WINS, gameService.checkStatus());
    }

    @Test
    void checkStatus_OWinsSecondaryDiagonal() {
        Character[][] board = new Character[3][3];
        board[0][2] = Constants.O_MARK;
        board[1][1] = Constants.O_MARK;
        board[2][0] = Constants.O_MARK;
        gameService.setBoard(board);
        Assertions.assertEquals(Constants.O_WINS, gameService.checkStatus());
    }

    @Test
    void checkStatus_fullBoardDraw() {
        Character[][] board = new Character[3][3];
        board[0][0] = Constants.O_MARK;
        board[0][1] = Constants.X_MARK;
        board[0][2] = Constants.O_MARK;
        board[1][0] = Constants.X_MARK;
        board[1][1] = Constants.O_MARK;
        board[1][2] = Constants.X_MARK;
        board[2][0] = Constants.X_MARK;
        board[2][1] = Constants.O_MARK;
        board[2][2] = Constants.X_MARK;
        gameService.setBoard(board);
        Assertions.assertEquals(Constants.TIE, gameService.checkStatus());
    }

    @Test
    void checkStatus_fullBoardContinue() {
        Character[][] board = new Character[3][3];
        board[0][0] = Constants.O_MARK;
        board[0][1] = Constants.X_MARK;
        board[0][2] = Constants.O_MARK;
        board[1][0] = Constants.X_MARK;
        board[1][1] = Constants.EMPTY_CHARACTER;
        board[1][2] = Constants.X_MARK;
        board[2][0] = Constants.O_MARK;
        board[2][1] = Constants.X_MARK;
        board[2][2] = Constants.O_MARK;
        gameService.setBoard(board);
        Assertions.assertEquals(Constants.CONTINUE, gameService.checkStatus());
    }
}
