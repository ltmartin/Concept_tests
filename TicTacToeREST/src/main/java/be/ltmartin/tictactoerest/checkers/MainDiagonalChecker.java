package be.ltmartin.tictactoerest.checkers;

import be.ltmartin.tictactoerest.Utils.BoardUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("mainDiagonal")
public class MainDiagonalChecker implements StatusChecker{
    @Override
    public byte checkStatus(Character[][] board) {
        Character[] line = {board[0][0], board[1][1], board[2][2]} ;
        return BoardUtils.checkLine(line);
    }
}
