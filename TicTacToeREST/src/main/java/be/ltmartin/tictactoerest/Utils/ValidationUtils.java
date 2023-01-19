package be.ltmartin.tictactoerest.Utils;

import be.ltmartin.tictactoerest.Constants;

public class ValidationUtils {
    public static boolean validatePlayer(Character player, boolean isX_turn) {
        if (isX_turn) return Constants.X_MARK == player;
        else return Constants.O_MARK == player;
    }

    public static boolean validateCell(Character[][] board, Integer row, Integer column) {
        return board[row][column] == Constants.EMPTY_CHARACTER;
    }

    public static boolean validateEntry(Integer row, Integer column) {
        return validateComponent(row) && validateComponent(column);
    }

    private static boolean validateComponent(Integer component){
        return ((component >=0) && (component <= 2));
    }
}
