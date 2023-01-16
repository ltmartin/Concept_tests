package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Constants;
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
            Character firstCharacter = board[0][i];
            if (null != firstCharacter) {
                if ((board[1][i] == firstCharacter) && (board[2][i] == firstCharacter))
                    if (firstCharacter == Constants.X_MARK)
                        return Constants.X_WINS;
                    else if (firstCharacter == Constants.O_MARK)
                        return Constants.O_WINS;
            }
        }
        return Constants.CONTINUE;
    }
}
