package be.ltmartin.tictactoerest.Utils;

import be.ltmartin.tictactoerest.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BoardUtilsTest {

    @Test
    void flatBoard() {
        var board = new Character[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) (count + '0');
                count++;
            }
        }
        List<Character> expectedResult = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8');
        Assertions.assertEquals(expectedResult, BoardUtils.flatBoard(board));
    }

    @Test
    void checkLineX() {
        Character line[] = {Constants.X_MARK, Constants.X_MARK, Constants.X_MARK};
        Assertions.assertEquals(Constants.X_WINS, BoardUtils.checkLine(line));
    }

    @Test
    void checkLineO() {
        Character line[] = {Constants.O_MARK, Constants.O_MARK, Constants.O_MARK};
        Assertions.assertEquals(Constants.O_WINS, BoardUtils.checkLine(line));
    }

    @Test
    void getWinnerX() {
        Assertions.assertEquals(Constants.X_WINS, BoardUtils.getWinner(Constants.X_MARK));
    }

    @Test
    void getWinnerO() {
        Assertions.assertEquals(Constants.O_WINS, BoardUtils.getWinner(Constants.O_MARK));
    }
}