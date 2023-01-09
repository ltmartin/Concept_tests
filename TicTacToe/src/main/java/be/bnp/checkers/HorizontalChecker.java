package be.bnp.checkers;

import be.bnp.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("horizontal")
public class HorizontalChecker implements StatusChecker{
    @Override
    public byte checkStatus(char[][] board) {
        for (int i = 0; i < 3; i++) {
            char firstCharacter = board[i][0];
            if ((board[i][1] == firstCharacter) && (board[i][2] == firstCharacter))
                if (firstCharacter == Constants.X_MARK)
                    return Constants.X_WINS;
                else if (firstCharacter == Constants.O_MARK)
                    return Constants.O_WINS;
        }
        return Constants.CONTINUE;
    }
}
