package be.ltmartin.tictactoerest.services;

import be.ltmartin.tictactoerest.Constants;
import be.ltmartin.tictactoerest.Utils.ValidationUtils;
import be.ltmartin.tictactoerest.checkers.StatusChecker;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.System.out;

@Component
@Lazy
public class GameService {
    @Value("${tictactoe.testing}")
    private boolean testing;
    private Character[][] board;
    private boolean isX_turn;
    private byte row;
    private byte column;
    private boolean gameEnded;
    @Resource
    @Qualifier("horizontal")
    private StatusChecker horizontalChecker;
    @Resource
    @Qualifier("vertical")
    private StatusChecker verticalChecker;
    @Resource
    @Qualifier("mainDiagonal")
    private StatusChecker mainDiagonalChecker;
    @Resource
    @Qualifier("secondaryDiagonal")
    private StatusChecker secondaryDiagonalChecker;
    @Resource
    @Qualifier("fullBoard")
    private StatusChecker fullBoardChecker;

    @PostConstruct
    public boolean newGame() {
        board = new Character[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = Constants.EMPTY_CHARACTER;

        isX_turn = true;
        gameEnded = false;
        row = Constants.INITIAL_COORDINATE;
        column = Constants.INITIAL_COORDINATE;
        return true;
    }


    public String play(Integer row, Integer column, Character player) {
        if (!gameEnded) {
            if (!validateEntry(row, column)) return Constants.INVALID_VALUES;
            if (validateAction(player)) {
                performAction();
                byte status = checkStatus();
                if (status != Constants.CONTINUE) {
                    gameEnded = true;
                    return showResult(status);
                }
            } else return Constants.SPOT_TAKEN;
        }

        return Constants.GAME_ENDED;
    }

    protected String showResult(byte status) {
        switch (status) {
            case Constants.X_WINS -> {
                return Constants.X_WINS_MESSAGE;
            }
            case Constants.O_WINS -> {
                return Constants.O_WINS_MESSAGE;
            }
            case Constants.TIE -> {
                return Constants.DRAW_MESSAGE;
            }
        }
        return null;
    }

    protected byte checkStatus() {
        List<Byte> statusEvaluation = List.of(horizontalChecker.checkStatus(board), verticalChecker.checkStatus(board), mainDiagonalChecker.checkStatus(board), secondaryDiagonalChecker.checkStatus(board), fullBoardChecker.checkStatus(board));

        if (statusEvaluation.stream().distinct().count() == 1) // all checkers recommend to continue the game
            return Constants.CONTINUE;

        return statusEvaluation.stream().distinct().dropWhile(status -> status.equals(Constants.CONTINUE)).toList().get(0);
    }

    protected void performAction() {
        if (isX_turn) board[row][column] = Constants.X_MARK;
        else board[row][column] = Constants.O_MARK;

        isX_turn = !isX_turn;
    }

    protected boolean validateAction(Character player) {
        return ValidationUtils.validatePlayer(player, isX_turn) && ValidationUtils.validateCell(board, getRow(), getColumn());
    }


    private boolean validateEntry(Integer row, Integer column) {
        return ((row >= 0) && (row <= 2) && (column >= 0) && (column <= 2));
    }

    private void paintBoard() {
        out.println("================================");
        out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        out.println("-----");
        out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        out.println("-----");
        out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        out.println("================================");
    }

    public byte getRow() {
        return row;
    }

    public void setRow(byte row) {
        this.row = row;
    }

    public byte getColumn() {
        return column;
    }

    public void setColumn(byte column) {
        this.column = column;
    }

    public Character[][] getBoard() {
        return board;
    }

    public void setBoard(Character[][] board) {
        this.board = board;
    }

    public void setX_turn(boolean x_turn) {
        isX_turn = x_turn;
    }
}
