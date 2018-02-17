package chess.controllers.command;

import chess.models.Position;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class ButtonMove {
    public void move(Pane[][] paneArray, Button button, Position destination){
        int destinationX = destination.getX();
        int destinationY = destination.getY();

        paneArray[destinationX][destinationY].getChildren().clear();
        paneArray[destinationX][destinationY].getChildren().addAll(button);

    }
}
