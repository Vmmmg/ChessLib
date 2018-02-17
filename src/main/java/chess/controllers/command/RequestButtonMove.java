package chess.controllers.command;

import chess.controllers.BoardController;
import chess.models.Board;
import chess.models.Position;
import javafx.scene.control.Button;

public class RequestButtonMove {

    private Command moveCommand;

    public void setMoveCommand(Command command){
        moveCommand = command;
    }

    public void executeMoveCommand(BoardController board, Button movingBtn, Position originPos, Button capturedBtn, Position destinationPos){
        moveCommand.execute(board, movingBtn, originPos, capturedBtn, destinationPos);
    }

    public void undoMoveCommand(BoardController board){
        moveCommand.undo(board);
    }
}
