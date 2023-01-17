package be.ltmartin.tictactoerest.Utils;

import be.ltmartin.tictactoerest.Constants;

public class ValidationUtils {
    public static boolean validatePlayer(Character player, boolean isX_turn) {
        if (isX_turn && (Constants.X_MARK != player))
            return false;
        if (!isX_turn && (Constants.O_MARK != player))
            return false;
        return true;
    }

    public static boolean validateCell(Character[][] board, Byte row, Byte column) {
        return board[row][column] == Constants.EMPTY_CHARACTER;
    }
}
