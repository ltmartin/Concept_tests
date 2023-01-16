package be.ltmartin.tictactoerest.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardUtilsTests {

    @Test
    void flatBoard() {
        Character[][] board = new Character[3][3];
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
}