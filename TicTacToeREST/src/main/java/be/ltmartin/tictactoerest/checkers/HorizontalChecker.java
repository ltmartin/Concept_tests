package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Constants;
import be.ltmartin.tictactoerest.Utils.BoardUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("horizontal")
public class HorizontalChecker implements StatusChecker{
    @Override
    public byte checkStatus(Character[][] board) {
        for (int i = 0; i < 3; i++) {
            byte decision = BoardUtils.checkLine(board[i]);
            if (decision != Constants.CONTINUE)
                return decision;
        }

        return Constants.CONTINUE;
    }


}
