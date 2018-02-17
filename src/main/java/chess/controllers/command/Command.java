package chess.controllers.command;

import chess.controllers.BoardController;
import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;
import javafx.scene.control.Button;

import java.util.List;

/**
 * The command interface of the Command Pattern
 */
public interface Command {
    public void execute(BoardController board, Button movingBtn, Position originPos, Button capturedBtn, Position destinationPos);
    public void undo(BoardController board);
}
