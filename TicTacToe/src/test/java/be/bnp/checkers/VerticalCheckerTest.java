package be.bnp.checkers;

import be.bnp.Constants;
import be.bnp.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TicTacToe.class)
class VerticalCheckerTest {
    @Resource
    private VerticalChecker verticalChecker;

    @Test
    void checkStatus_XWins() {
        char board[][] = new char[3][3];
        board[0][0] = Constants.X_MARK;
        board[1][0] = Constants.X_MARK;
        board[2][0] = Constants.X_MARK;
        Assertions.assertEquals(Constants.X_WINS, verticalChecker.checkStatus(board));
    }

    @Test
    void checkStatus_OWins() {
        char board[][] = new char[3][3];
        board[0][2] = Constants.O_MARK;
        board[1][2] = Constants.O_MARK;
        board[2][2] = Constants.O_MARK;
        Assertions.assertEquals(Constants.O_WINS, verticalChecker.checkStatus(board));
    }
}