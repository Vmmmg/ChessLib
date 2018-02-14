package chess.controllers;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.GameMode;
import chess.models.enums.GameResult;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;
import chess.models.pieces.King;
import chess.models.pieces.Queen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class BoardController {

    //top
    @FXML MenuItem startItem;

    //left
    @FXML Label bNameLabel;
    @FXML Button bUndoBtn;
    @FXML Button bRestartBtn;
    @FXML Button bForfeitBtn;
    @FXML Label bRestartLabel;
    @FXML RadioButton bRestartYesBtn;
    @FXML RadioButton bRestartNoBtn;
    @FXML Label resultLabel;
    @FXML Label wNameLabel;
    @FXML Button wUndoBtn;
    @FXML Button wRestartBtn;
    @FXML Button wForfeitBtn;
    @FXML Label wRestartLabel;
    @FXML RadioButton wRestartYesBtn;
    @FXML RadioButton wRestartNoBtn;

    //right
    @FXML TextField bNameField;
    @FXML TextField wNameField;
    @FXML RadioButton classicModeBtn;
    @FXML RadioButton newModeBtn;
    @FXML Button startBtn;

    //bottom
    @FXML FlowPane resultFlowPane;

    //center
    @FXML GridPane boardGridPane;

    @FXML Pane pane00, pane10, pane20, pane30, pane40, pane50, pane60, pane70, pane01, pane11, pane21, pane31, pane41, pane51, pane61, pane71,
            pane02, pane12, pane22, pane32, pane42, pane52, pane62, pane72, pane03, pane13, pane23, pane33, pane43, pane53, pane63, pane73,
            pane04, pane14, pane24, pane34, pane44, pane54, pane64, pane74, pane05, pane15, pane25, pane35, pane45, pane55, pane65, pane75,
            pane06, pane16, pane26, pane36, pane46, pane56, pane66, pane76, pane07, pane17, pane27, pane37, pane47, pane57, pane67, pane77;

    @FXML Button bRookBtn1;
    @FXML Button bRookBtn2;
    @FXML Button bKnightBtn1;
    @FXML Button bKnightBtn2;
    @FXML Button bBishopBtn1;
    @FXML Button bBishopBtn2;
    @FXML Button bQueenBtn;
    @FXML Button bKingBtn;
    @FXML Button bPawnBtn1;
    @FXML Button bPawnBtn2;
    @FXML Button bPawnBtn3;
    @FXML Button bPawnBtn4;
    @FXML Button bPawnBtn5;
    @FXML Button bPawnBtn6;
    @FXML Button bPawnBtn7;
    @FXML Button bPawnBtn8;

    @FXML Button wRookBtn1;
    @FXML Button wRookBtn2;
    @FXML Button wKnightBtn1;
    @FXML Button wKnightBtn2;
    @FXML Button wBishopBtn1;
    @FXML Button wBishopBtn2;
    @FXML Button wQueenBtn;
    @FXML Button wKingBtn;
    @FXML Button wPawnBtn1;
    @FXML Button wPawnBtn2;
    @FXML Button wPawnBtn3;
    @FXML Button wPawnBtn4;
    @FXML Button wPawnBtn5;
    @FXML Button wPawnBtn6;
    @FXML Button wPawnBtn7;
    @FXML Button wPawnBtn8;

    private Board board;
    private Pane[][] paneArray;
    private GameMode selectedMode;
    private String blackName;
    private String whiteName;
    private Set<Button> blackBtnSet;
    private Set<Button> whiteBtnSet;
    private Button movingBtn;
    private Pane movingBtnPos;
    private Pane destination;

    @FXML
    public void firstStartGame(ActionEvent event){
        blackName = bNameField.getText();
        whiteName = wNameField.getText();
        if(classicModeBtn.isSelected()){
            selectedMode = GameMode.Classic;
        }
        else {
            selectedMode = GameMode.New;
        }

        bNameLabel.setText(blackName);
        wNameLabel.setText(whiteName);
        bNameField.setEditable(false);
        wNameField.setEditable(false);
        classicModeBtn.setDisable(false);
        newModeBtn.setDisable(false);
        startBtn.setDisable(false);

        board = new Board(selectedMode);
        addPaneToArray();
        addBtnToSet();
        setChessDisable();
    }

    @FXML
    public void startGame(ActionEvent event){
        board = new Board(selectedMode);

        boardGridPane.setConstraints(wRookBtn1, 1, 8);
        boardGridPane.setConstraints(wKnightBtn1, 2, 8);
        boardGridPane.setConstraints(wBishopBtn1, 3, 8);
        boardGridPane.setConstraints(wQueenBtn, 4, 8);
        boardGridPane.setConstraints(wKingBtn, 5, 8);
        boardGridPane.setConstraints(wBishopBtn2, 6, 8);
        boardGridPane.setConstraints(wKnightBtn2, 7, 8);
        boardGridPane.setConstraints(wRookBtn2, 8, 8);
        boardGridPane.setConstraints(wPawnBtn1, 1, 7);
        boardGridPane.setConstraints(wPawnBtn2, 2, 7);
        boardGridPane.setConstraints(wPawnBtn3, 3, 7);
        boardGridPane.setConstraints(wPawnBtn4, 4, 7);
        boardGridPane.setConstraints(wPawnBtn5, 5, 7);
        boardGridPane.setConstraints(wPawnBtn6, 6, 7);
        boardGridPane.setConstraints(wPawnBtn7, 7, 7);
        boardGridPane.setConstraints(wPawnBtn8, 8, 7);

        boardGridPane.setConstraints(bRookBtn1, 1, 1);
        boardGridPane.setConstraints(bKnightBtn1, 2, 1);
        boardGridPane.setConstraints(bBishopBtn1, 3, 1);
        boardGridPane.setConstraints(bQueenBtn, 4, 1);
        boardGridPane.setConstraints(bKingBtn, 5, 1);
        boardGridPane.setConstraints(bBishopBtn2, 6, 1);
        boardGridPane.setConstraints(bKnightBtn2, 7, 1);
        boardGridPane.setConstraints(bRookBtn2, 8, 1);
        boardGridPane.setConstraints(bPawnBtn1, 1, 2);
        boardGridPane.setConstraints(bPawnBtn2, 2, 2);
        boardGridPane.setConstraints(bPawnBtn3, 3, 2);
        boardGridPane.setConstraints(bPawnBtn4, 4, 2);
        boardGridPane.setConstraints(bPawnBtn5, 5, 2);
        boardGridPane.setConstraints(bPawnBtn6, 6, 2);
        boardGridPane.setConstraints(bPawnBtn7, 7, 2);
        boardGridPane.setConstraints(bPawnBtn8, 8, 2);

        boardGridPane.getChildren().addAll(bRookBtn1, bKnightBtn1, bBishopBtn1, bQueenBtn, bKingBtn, bBishopBtn2, bKnightBtn2, bRookBtn2,
                bPawnBtn1, bPawnBtn2, bPawnBtn3, bPawnBtn4, bPawnBtn5, bPawnBtn6, bPawnBtn7, bPawnBtn8,
                wRookBtn1, wKnightBtn1, wBishopBtn1, wQueenBtn, wKingBtn, wBishopBtn2, wKnightBtn2, wRookBtn2,
                wPawnBtn1, wPawnBtn2, wPawnBtn3, wPawnBtn4, wPawnBtn5, wPawnBtn6,wPawnBtn7, wPawnBtn8);

        addBtnToSet();
        setChessDisable();
        startItem.setDisable(true);
    }

    @FXML
    public void restartGame(ActionEvent event){
        finish(GameResult.Draw);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startGame(event);
    }

    public void addBtnToSet(){
        blackBtnSet = new HashSet<>();
        whiteBtnSet = new HashSet<>();

        blackBtnSet.add(bRookBtn1);
        blackBtnSet.add(bRookBtn2);
        blackBtnSet.add(bKnightBtn1);
        blackBtnSet.add(bKnightBtn2);
        blackBtnSet.add(bBishopBtn1);
        blackBtnSet.add(bBishopBtn2);
        blackBtnSet.add(bQueenBtn);
        blackBtnSet.add(bKingBtn);
        blackBtnSet.add(bPawnBtn1);
        blackBtnSet.add(bPawnBtn2);
        blackBtnSet.add(bPawnBtn3);
        blackBtnSet.add(bPawnBtn4);
        blackBtnSet.add(bPawnBtn5);
        blackBtnSet.add(bPawnBtn6);
        blackBtnSet.add(bPawnBtn7);
        blackBtnSet.add(bPawnBtn8);

        whiteBtnSet.add(wRookBtn1);
        whiteBtnSet.add(wRookBtn2);
        whiteBtnSet.add(wKnightBtn1);
        whiteBtnSet.add(wKnightBtn2);
        whiteBtnSet.add(wBishopBtn1);
        whiteBtnSet.add(wBishopBtn2);
        whiteBtnSet.add(wQueenBtn);
        whiteBtnSet.add(wKingBtn);
        whiteBtnSet.add(wPawnBtn1);
        whiteBtnSet.add(wPawnBtn2);
        whiteBtnSet.add(wPawnBtn3);
        whiteBtnSet.add(wPawnBtn4);
        whiteBtnSet.add(wPawnBtn5);
        whiteBtnSet.add(wPawnBtn6);
        whiteBtnSet.add(wPawnBtn7);
        whiteBtnSet.add(wPawnBtn8);
    }

    public void addPaneToArray(){
        paneArray = new Pane[board.getHEIGHT()][board.getWIDTH()];
        paneArray[0][0] = pane00; paneArray[1][0] = pane10;
        paneArray[2][0] = pane20; paneArray[3][0] = pane30;
        paneArray[4][0] = pane40; paneArray[5][0] = pane50;
        paneArray[6][0] = pane60; paneArray[7][0] = pane70;
        paneArray[0][1] = pane01; paneArray[1][1] = pane11;
        paneArray[2][1] = pane21; paneArray[3][1] = pane31;
        paneArray[4][1] = pane41; paneArray[5][1] = pane51;
        paneArray[6][1] = pane61; paneArray[7][1] = pane71;
        paneArray[0][2] = pane02; paneArray[1][2] = pane12;
        paneArray[2][2] = pane22; paneArray[3][2] = pane32;
        paneArray[4][2] = pane42; paneArray[5][2] = pane52;
        paneArray[6][2] = pane62; paneArray[7][2] = pane72;
        paneArray[0][3] = pane03; paneArray[1][3] = pane13;
        paneArray[2][3] = pane23; paneArray[3][3] = pane33;
        paneArray[4][3] = pane43; paneArray[5][3] = pane53;
        paneArray[6][3] = pane63; paneArray[7][3] = pane73;
        paneArray[0][4] = pane04; paneArray[1][4] = pane14;
        paneArray[2][4] = pane24; paneArray[3][4] = pane34;
        paneArray[4][4] = pane44; paneArray[5][4] = pane54;
        paneArray[6][4] = pane64; paneArray[7][4] = pane74;
        paneArray[0][5] = pane05; paneArray[1][5] = pane15;
        paneArray[2][5] = pane25; paneArray[3][5] = pane35;
        paneArray[4][5] = pane45; paneArray[5][5] = pane55;
        paneArray[6][5] = pane65; paneArray[7][5] = pane75;
        paneArray[0][6] = pane06; paneArray[1][6] = pane16;
        paneArray[2][6] = pane26; paneArray[3][6] = pane36;
        paneArray[4][6] = pane46; paneArray[5][6] = pane56;
        paneArray[6][6] = pane66; paneArray[7][6] = pane76;
        paneArray[0][7] = pane07; paneArray[1][7] = pane17;
        paneArray[2][7] = pane27; paneArray[3][7] = pane37;
        paneArray[4][7] = pane47; paneArray[5][7] = pane57;
        paneArray[6][7] = pane67; paneArray[7][7] = pane77;
    }

    public void gameLoop(){
        int movingBtnPosX = Integer.parseInt(movingBtnPos.getId().substring(4, 5));
        int movingBtnPosY = Integer.parseInt(movingBtnPos.getId().substring(5, 6));
        ChessPiece selectedChess = board.getSpecificPositionChess(new Position(movingBtnPosX, movingBtnPosY));
        int destinationX = Integer.parseInt(destination.getId().substring(4, 5));
        int destinationY = Integer.parseInt(destination.getId().substring(5, 6));
        Position destinationPos = new Position(destinationX, destinationY);
        MoveResult moveResult = board.isLegalMove(selectedChess, destinationPos);

        if(moveResult == MoveResult.LegalMove){
            moveResult = board.chessMove(selectedChess, destinationPos);

            if(moveResult == MoveResult.Capture){
                if(board.getCurPlayer() == Player.White){
                    blackBtnSet.remove(paneArray[destinationX][destinationY].getChildren().get(0));
                }
                else{
                    whiteBtnSet.remove(paneArray[destinationX][destinationY].getChildren().get(0));
                }
                paneArray[destinationX][destinationY].getChildren().removeAll();
            }
            paneArray[destinationX][destinationY].getChildren().addAll(movingBtn);

            GameResult gameResult = board.judge();
            if(gameResult == GameResult.Gaming){
                board.nextPlayer();
                setChessDisable();
                movingBtn = null;
                movingBtnPos = null;
            }
            else{
                finish(gameResult);
            }
        }
        else{
            resultLabel.setText("Illegal Move!");
        }
    }

    public void setChessDisable(){
        if(board.getCurPlayer() == Player.White){
            for(Button whiteBtn: whiteBtnSet){
                whiteBtn.setDisable(false);
            }
            for(Button blackBtn: blackBtnSet) {
                blackBtn.setDisable(true);
            }
        }
        else{
            for(Button whiteBtn: whiteBtnSet){
                whiteBtn.setDisable(true);
            }
            for(Button blackBtn: blackBtnSet) {
                blackBtn.setDisable(false);
            }
        }
    }

    public void finish(GameResult gameResult){
        if(gameResult == GameResult.BlackWin){
            resultLabel.setText(blackName + "Win!");
            resultFlowPane.getChildren().addAll(new Label(blackName + "Win!"));
        }
        else if(gameResult == GameResult.WhiteWin){
            resultLabel.setText(whiteName + "Win!");
            resultFlowPane.getChildren().addAll(new Label(whiteName + "Win!"));
        }
        else{
            resultLabel.setText("Draw!");
            resultFlowPane.getChildren().addAll(new Label("Draw!"));
        }

        startItem.setDisable(false);
    }

    @FXML
    public void clickChess(ActionEvent event){
        resultLabel.setText("");
        movingBtn = (Button) event.getSource();
        movingBtnPos = (Pane) movingBtn.getParent();
    }

    @FXML
    public void clickDestination(MouseEvent event){
        resultLabel.setText("");
        if(movingBtn != null) {
            destination = (Pane) event.getSource();
            gameLoop();
        }
    }

}
