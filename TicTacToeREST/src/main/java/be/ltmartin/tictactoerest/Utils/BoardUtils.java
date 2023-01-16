package be.ltmartin.tictactoerest.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardUtils {
    public static List<Character> flatBoard(Character[][] board){
        List<Character> flattenedBoard = new ArrayList<>();

        flattenedBoard.addAll(Arrays.asList(board[0]));
        flattenedBoard.addAll(Arrays.asList(board[1]));
        flattenedBoard.addAll(Arrays.asList(board[2]));

        return flattenedBoard;
    }
}
