package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;

import java.util.List;

/**
 * Invoker of the Command Pattern
 */
public class RequestChessMove {

    private Command moveCommand;

    public void setMoveCommand(Command command){
        moveCommand = command;
    }

    public void executeMoveCommand(Board board, ChessPiece chess, Position destination){
        moveCommand.execute(board, chess, destination);
    }

    public List<Position> undoMoveCommand(Board board){
        List<Position> poses = moveCommand.undo(board);
        return poses;
    }

}
