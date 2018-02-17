package chess.models.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;

import java.util.List;

/**
 * Invoker of the Command Pattern
 */
public class RequestChessMove {

    private Command moveCommand;

    /**
     * Set command
     *
     * @param command Chess move command
     */
    public void setMoveCommand(Command command) {
        moveCommand = command;
    }

    /**
     * Execute command
     *
     * @param board       Chess board
     * @param chess       Piece that needs to move
     * @param destination Destination position
     */
    public MoveResult executeMoveCommand(Board board, ChessPiece chess, Position destination) {
        return moveCommand.execute(board, chess, destination);
    }

    /**
     * Undo command
     *
     * @param board Chess board
     */
    public void undoMoveCommand(Board board) {
         moveCommand.undo(board);
    }

}
