package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Utils.BoardUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("secondaryDiagonal")
public class SecondaryDiagonalChecker implements StatusChecker{
    @Override
    public byte checkStatus(Character[][] board) {
        Character[] line = {board[0][2], board[1][1], board[2][0]} ;
        return BoardUtils.checkLine(line);
    }
}
