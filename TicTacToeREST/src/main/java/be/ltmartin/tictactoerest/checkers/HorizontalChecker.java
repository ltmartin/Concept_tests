package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Constants;
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
            Character firstCharacter = board[i][0];
            if (null != firstCharacter) {
                if ((board[i][1] == firstCharacter) && (board[i][2] == firstCharacter))
                    if (firstCharacter == Constants.X_MARK)
                        return Constants.X_WINS;
                    else if (firstCharacter == Constants.O_MARK)
                        return Constants.O_WINS;
            }
        }
        return Constants.CONTINUE;
    }
}
