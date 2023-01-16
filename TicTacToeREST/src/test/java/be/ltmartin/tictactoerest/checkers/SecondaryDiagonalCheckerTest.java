package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Constants;
import be.ltmartin.tictactoerest.TicTacToeRestApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TicTacToeRestApplication.class)
class SecondaryDiagonalCheckerTest {

    @Resource
    private SecondaryDiagonalChecker secondaryDiagonalChecker;

    @Test
    void checkStatus_XWins() {
        Character board[][] = new Character[3][3];
        board[0][2] = Constants.X_MARK;
        board[1][1] = Constants.X_MARK;
        board[2][0] = Constants.X_MARK;
        Assertions.assertEquals(Constants.X_WINS, secondaryDiagonalChecker.checkStatus(board));
    }

    @Test
    void checkStatus_OWins() {
        Character board[][] = new Character[3][3];
        board[0][2] = Constants.O_MARK;
        board[1][1] = Constants.O_MARK;
        board[2][0] = Constants.O_MARK;
        Assertions.assertEquals(Constants.O_WINS, secondaryDiagonalChecker.checkStatus(board));
    }
}