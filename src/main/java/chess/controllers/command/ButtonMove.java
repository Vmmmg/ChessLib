package chess.controllers.command;

import chess.controllers.BoardController;
import chess.models.Board;
import chess.models.Position;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class ButtonMove {

    public void move(BoardController board, Button button, Position destination){
        board.btnMove(button, destination);

    }

    public void undo(BoardController board, Button movingBtn, Position originPos, Button capturedBtn, Position destination){
        board.undoBtnMove(movingBtn, originPos, capturedBtn, destination);
    }
}
