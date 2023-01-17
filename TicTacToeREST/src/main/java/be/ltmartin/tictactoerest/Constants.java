package be.ltmartin.tictactoerest;

public interface Constants {
    byte X_WINS = 1;
    byte O_WINS = 0;
    byte TIE = 2;
    byte CONTINUE = 3;
    byte INITIAL_COORDINATE = Byte.MAX_VALUE;
    Character EMPTY_CHARACTER = 'E';
    Character X_MARK = 'X';
    Character O_MARK = 'O';
    String SPOT_TAKEN = "Sorry, that spot is taken, please type other coordinates.";
    String GAME_ENDED = "The game has ended. You need to start a new one.";
    String INVALID_VALUES = "Coordinates need to be between 0 and 2 inclusive.";
    String X_WINS_MESSAGE = "X is the winner.";
    String O_WINS_MESSAGE = "O is the winner.";
    String DRAW_MESSAGE = "The game is a draw.";
}
