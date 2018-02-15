package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;

import java.util.List;

/**
 * The command interface of the Command Pattern
 */
public interface Command {
    public void execute(Board board, ChessPiece chess, Position destination);
    public List<Position> undo(Board board);
}
