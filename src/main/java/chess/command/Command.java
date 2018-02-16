package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;

import java.util.List;

/**
 * The command interface of the Command Pattern
 */
public interface Command {

    MoveResult execute(Board board, ChessPiece chess, Position destination);

    List<Position> undo(Board board);
}
