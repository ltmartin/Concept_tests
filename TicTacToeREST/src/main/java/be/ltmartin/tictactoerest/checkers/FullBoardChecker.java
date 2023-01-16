package be.ltmartin.tictactoerest.checkers;


import be.ltmartin.tictactoerest.Constants;
import be.ltmartin.tictactoerest.Utils.BoardUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("fullBoard")
public class FullBoardChecker implements StatusChecker{
    @Override
    public byte checkStatus(Character[][] board) {
        return BoardUtils.flatBoard(board).contains(Constants.EMPTY_CHARACTER)? Constants.CONTINUE : Constants.TIE;
    }
}
