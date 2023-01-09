package be.bnp.checkers;

import be.bnp.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("fullBoard")
public class FullBoardChecker implements StatusChecker{
    @Override
    public byte checkStatus(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
              if (board[i][j] == Constants.EMPTY_CHARACTER)
                  return Constants.CONTINUE;
            }
        }
        return Constants.TIE;
    }
}
