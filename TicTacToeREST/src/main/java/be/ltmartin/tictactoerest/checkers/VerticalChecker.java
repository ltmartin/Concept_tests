package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Constants;
import be.ltmartin.tictactoerest.Utils.BoardUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("vertical")
public class VerticalChecker implements StatusChecker{
    @Override
    public byte checkStatus(Character[][] board) {
        for (int i = 0; i < 3; i++) {
            Character[] line = {board[0][i], board[1][i], board[2][i]};
            byte decision = BoardUtils.checkLine(line);
            if (decision != Constants.CONTINUE)
                return decision;
        }
        return Constants.CONTINUE;
    }
}
