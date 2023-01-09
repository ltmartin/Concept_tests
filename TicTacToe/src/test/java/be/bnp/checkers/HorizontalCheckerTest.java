package be.bnp.checkers;

import be.bnp.Constants;
import be.bnp.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TicTacToe.class)
class HorizontalCheckerTest {
    @Resource
    private HorizontalChecker horizontalChecker;

    @Test
    void checkStatus_XWins() {
        char board[][] = new char[3][3];
        board[1][0] = Constants.X_MARK;
        board[1][1] = Constants.X_MARK;
        board[1][2] = Constants.X_MARK;
        Assertions.assertEquals(Constants.X_WINS, horizontalChecker.checkStatus(board));
    }

    @Test
    void checkStatus_OWins() {
        char board[][] = new char[3][3];
        board[2][0] = Constants.O_MARK;
        board[2][1] = Constants.O_MARK;
        board[2][2] = Constants.O_MARK;
        Assertions.assertEquals(Constants.O_WINS, horizontalChecker.checkStatus(board));
    }
}