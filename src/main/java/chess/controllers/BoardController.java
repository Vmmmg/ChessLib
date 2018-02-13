package chess.controllers;

import chess.models.Board;
import chess.models.enums.GameMode;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BoardController extends Application {

    @FXML MenuItem startItem;

    @FXML Label bNameLabel;
    @FXML Button bUndoBtn;
    @FXML Button bRestartBtn;
    @FXML Button bForfeitBtn;
    @FXML Label wNameLabel;
    @FXML Button wUndoBtn;
    @FXML Button wRestartBtn;
    @FXML Button wForfeitBtn;

    @FXML TextField bNameField;
    @FXML TextField wNameField;
    @FXML RadioButton classicModeBtn;
    @FXML RadioButton newModeBtn;
    @FXML Button startBtn;

    private String blackName;
    private String whiteName;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Board.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    public void startGame(){
        blackName = bNameField.getText();
        whiteName = wNameField.getText();
        if(classicModeBtn.isSelected()){
            Board board = new Board(GameMode.Classic);
        }
        else{
            Board board = new Board(GameMode.New);
        }

        bNameField.setEditable(false);
        wNameField.setEditable(false);
        classicModeBtn.setDisable(false);


    }
}
