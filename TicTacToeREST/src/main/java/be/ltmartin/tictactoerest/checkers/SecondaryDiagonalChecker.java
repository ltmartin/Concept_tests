package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("secondaryDiagonal")
public class SecondaryDiagonalChecker implements StatusChecker{
    @Override
    public byte checkStatus(Character[][] board) {
        Character firstCharacter = board[0][2];
        if (null != firstCharacter) {
            if ((board[1][1] == firstCharacter) && (board[2][0] == firstCharacter))
                if (firstCharacter == Constants.X_MARK)
                    return Constants.X_WINS;
                else if (firstCharacter == Constants.O_MARK)
                    return Constants.O_WINS;
        }
        return Constants.CONTINUE;
    }
}
