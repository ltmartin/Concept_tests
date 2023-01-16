package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@Lazy
@Qualifier("horizontal")
public class HorizontalChecker implements StatusChecker{
    @Override
    public byte checkStatus(Character[][] board) {
        for (int i = 0; i < 3; i++) {
            byte decision = checkRow(board[i]);
            if (decision != Constants.CONTINUE)
                return decision;
        }

        return Constants.CONTINUE;
    }

    protected byte checkRow(Character[] row){
        List<Character> mark = Arrays.stream(row)
                .filter(Objects::nonNull)
                .distinct()
                .toList();

        if (mark.size() == 1)
            return getWinner(mark.get(0));
        return Constants.CONTINUE;
    }

    protected byte getWinner(Character cell){
        return (cell == Constants.X_MARK)? Constants.X_WINS : Constants.O_WINS;
    }
}
