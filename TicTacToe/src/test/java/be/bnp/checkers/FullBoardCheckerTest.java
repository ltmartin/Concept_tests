package be.bnp.checkers;

import be.bnp.Constants;
import be.bnp.TicTacToe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TicTacToe.class)
class FullBoardCheckerTest {
    @Resource
    private FullBoardChecker fullBoardChecker;

    @Test
    void checkStatus_Tie() {
        char board[][] = new char[3][3];
        board[0][0] = Constants.O_MARK;
        board[0][1] = Constants.X_MARK;
        board[0][2] = Constants.O_MARK;
        board[1][0] = Constants.X_MARK;
        board[1][1] = Constants.O_MARK;
        board[1][2] = Constants.X_MARK;
        board[2][0] = Constants.O_MARK;
        board[2][1] = Constants.X_MARK;
        board[2][2] = Constants.O_MARK;

        Assertions.assertEquals(Constants.TIE, fullBoardChecker.checkStatus(board));
    }

    @Test
    void checkStatus_Continue() {
        char board[][] = new char[3][3];
        board[0][0] = Constants.O_MARK;
        board[0][1] = Constants.X_MARK;
        board[0][2] = Constants.O_MARK;
        board[1][0] = Constants.X_MARK;
        board[1][1] = Constants.EMPTY_CHARACTER;
        board[1][2] = Constants.X_MARK;
        board[2][0] = Constants.O_MARK;
        board[2][1] = Constants.X_MARK;
        board[2][2] = Constants.O_MARK;

        Assertions.assertEquals(Constants.CONTINUE, fullBoardChecker.checkStatus(board));
    }
}