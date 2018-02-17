package chess.controllers.command;

import chess.controllers.BoardController;
import chess.models.Board;
import chess.models.Position;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ButtonMoveCommand implements Command {

    private ArrayList<Button> movingBtnList;
    private ArrayList<Position> originPosList;
    private ArrayList<Button> capturedBtnList;
    private ArrayList<Position> destinationPosList;
    private ButtonMove buttonMove;

    public ButtonMoveCommand(ButtonMove buttonMove){
        movingBtnList = new ArrayList<>();
        originPosList = new ArrayList<>();
        capturedBtnList = new ArrayList<>();
        destinationPosList = new ArrayList<>();
        this.buttonMove = buttonMove;
    }

    @Override
    public void execute(BoardController board, Button movingBtn, Position originPos, Button capturedBtn, Position destinationPos) {
        movingBtnList.add(movingBtn);
        originPosList.add(originPos);
        capturedBtnList.add(capturedBtn);
        destinationPosList.add(destinationPos);

        buttonMove.move(board, movingBtn, destinationPos);
    }

    @Override
    public void undo(BoardController board) {
        Button movingBtn = movingBtnList.get(movingBtnList.size() - 1);
        Position originPos = originPosList.get(originPosList.size() - 1);
        Button capturedBtn = capturedBtnList.get(capturedBtnList.size() - 1);
        Position destinationPos = destinationPosList.get(destinationPosList.size() - 1);

        buttonMove.undo(board, movingBtn, originPos, capturedBtn, destinationPos);

        movingBtnList.remove(movingBtnList.size() - 1);
        originPosList.remove(originPosList.size() - 1);
        capturedBtnList.remove(capturedBtnList.size() - 1);
        destinationPosList.remove(destinationPosList.size() - 1);
    }
}
