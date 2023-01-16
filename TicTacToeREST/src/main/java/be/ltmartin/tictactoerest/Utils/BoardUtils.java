package be.ltmartin.tictactoerest.Utils;

import be.ltmartin.tictactoerest.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BoardUtils {
    public static List<Character> flatBoard(Character[][] board){
        List<Character> flattenedBoard = new ArrayList<>();

        flattenedBoard.addAll(Arrays.asList(board[0]));
        flattenedBoard.addAll(Arrays.asList(board[1]));
        flattenedBoard.addAll(Arrays.asList(board[2]));

        return flattenedBoard;
    }

    public static byte checkLine(Character[] line){
        List<Character> mark = Arrays.stream(line)
                .filter(Objects::nonNull)
                .distinct()
                .toList();

        if (mark.size() == 1)
            return getWinner(mark.get(0));
        return Constants.CONTINUE;
    }

    protected static byte getWinner(Character cell){
        return (cell == Constants.X_MARK)? Constants.X_WINS : Constants.O_WINS;
    }
}
