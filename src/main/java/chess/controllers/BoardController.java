package chess.controllers;

import chess.command.ChessMove;
import chess.command.ChessMoveCommand;
import chess.command.Command;
import chess.command.RequestChessMove;
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
import java.util.List;
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
    ChessMove chessMoveReceiver;
    Command moveCommand;
    private RequestChessMove chessMoveInvoker;

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
        bNameField.setDisable(true);
        wNameField.setDisable(true);
        classicModeBtn.setDisable(true);
        newModeBtn.setDisable(true);
        startBtn.setDisable(true);

        board = new Board(selectedMode);
        addPaneToArray();
        setCommandInvoker();
        setPlayerBtnDisable(false);
        addBtnToSet();
        setChessDisable();
    }

    @FXML
    public void startGame(ActionEvent event){
        resultLabel.setText("");
        board = new Board(selectedMode);

        for(int i = 0; i < board.getHEIGHT(); i++){
            for(int j = 0; j < board.getWIDTH(); j++){
                paneArray[i][j].getChildren().clear();
            }
        }

        setCommandInvoker();
        setPlayerBtnDisable(false);
        addBtnToSet();
        addBtnToPane();
        setChessDisable();
        startItem.setDisable(true);
    }

    public void setCommandInvoker(){
        chessMoveReceiver = new ChessMove();
        moveCommand = new ChessMoveCommand(chessMoveReceiver);
        chessMoveInvoker = new RequestChessMove();
        chessMoveInvoker.setMoveCommand(moveCommand);
    }

    public void setUndoDisable(){
        if(board.getCurPlayer() == Player.White){
            bUndoBtn.setDisable(false);
            wUndoBtn.setDisable(true);
        }
        else{
            wUndoBtn.setDisable(false);
            bUndoBtn.setDisable(true);
        }
    }

    public void setPlayerBtnDisable(boolean disable){
        bRestartBtn.setDisable(disable);
        bForfeitBtn.setDisable(disable);
        wRestartBtn.setDisable(disable);
        wForfeitBtn.setDisable(disable);
    }

    public void addBtnToPane(){
        pane00.getChildren().addAll(bRookBtn1);
        pane10.getChildren().addAll(bKnightBtn1);
        pane20.getChildren().addAll(bBishopBtn1);
        pane30.getChildren().addAll(bQueenBtn);
        pane40.getChildren().addAll(bKingBtn);
        pane50.getChildren().addAll(bBishopBtn2);
        pane60.getChildren().addAll(bKnightBtn2);
        pane70.getChildren().addAll(bRookBtn2);
        pane01.getChildren().addAll(bPawnBtn1);
        pane11.getChildren().addAll(bPawnBtn2);
        pane21.getChildren().addAll(bPawnBtn3);
        pane31.getChildren().addAll(bPawnBtn4);
        pane41.getChildren().addAll(bPawnBtn5);
        pane51.getChildren().addAll(bPawnBtn6);
        pane61.getChildren().addAll(bPawnBtn7);
        pane71.getChildren().addAll(bPawnBtn8);

        pane07.getChildren().addAll(wRookBtn1);
        pane17.getChildren().addAll(wKnightBtn1);
        pane27.getChildren().addAll(wBishopBtn1);
        pane37.getChildren().addAll(wQueenBtn);
        pane47.getChildren().addAll(wKingBtn);
        pane57.getChildren().addAll(wBishopBtn2);
        pane67.getChildren().addAll(wKnightBtn2);
        pane77.getChildren().addAll(wRookBtn2);
        pane06.getChildren().addAll(wPawnBtn1);
        pane16.getChildren().addAll(wPawnBtn2);
        pane26.getChildren().addAll(wPawnBtn3);
        pane36.getChildren().addAll(wPawnBtn4);
        pane46.getChildren().addAll(wPawnBtn5);
        pane56.getChildren().addAll(wPawnBtn6);
        pane66.getChildren().addAll(wPawnBtn7);
        pane76.getChildren().addAll(wPawnBtn8);
    }

    @FXML
    public void restartConfirm(ActionEvent event){
        if((Button) event.getSource() == bRestartBtn){
            wRestartLabel.setVisible(true);
            wRestartYesBtn.setDisable(false);
            wRestartYesBtn.setVisible(true);
            wRestartNoBtn.setDisable(false);
            wRestartNoBtn.setVisible(true);
        }
        else{
            bRestartLabel.setVisible(true);
            bRestartYesBtn.setDisable(false);
            bRestartYesBtn.setVisible(true);
            bRestartNoBtn.setDisable(false);
            bRestartNoBtn.setVisible(true);
        }
    }

    @FXML
    public void restartGame(ActionEvent event){
        if((RadioButton) event.getSource() == wRestartYesBtn){
            wRestartLabel.setVisible(false);
            wRestartYesBtn.setVisible(false);
            wRestartYesBtn.setDisable(true);
            wRestartNoBtn.setVisible(false);
            wRestartNoBtn.setDisable(true);
            wRestartYesBtn.setSelected(false);

        }
        else{
            bRestartLabel.setVisible(false);
            bRestartYesBtn.setVisible(false);
            bRestartYesBtn.setDisable(true);
            bRestartNoBtn.setVisible(false);
            bRestartNoBtn.setDisable(true);
            bRestartYesBtn.setSelected(false);
        }

        finish(GameResult.Draw);

        startGame(event);
    }

    @FXML
    public void notRestartGame(ActionEvent event){
        if((RadioButton) event.getSource() == wRestartNoBtn){
            wRestartLabel.setVisible(false);
            wRestartYesBtn.setVisible(false);
            wRestartYesBtn.setDisable(true);
            wRestartNoBtn.setVisible(false);
            wRestartNoBtn.setDisable(true);
            wRestartNoBtn.setSelected(false);

        }
        else{
            bRestartLabel.setVisible(false);
            bRestartYesBtn.setVisible(false);
            bRestartYesBtn.setDisable(true);
            bRestartNoBtn.setVisible(false);
            bRestartNoBtn.setDisable(true);
            bRestartNoBtn.setSelected(false);
        }
    }

    @FXML
    public void forfeit(ActionEvent event){
        if((Button) event.getSource() == wForfeitBtn){
            finish(GameResult.BlackWin);
        }
        else{
            finish(GameResult.WhiteWin);
        }
    }

    @FXML
    public void undo(ActionEvent event){
        List<Position> poses = chessMoveInvoker.undoMoveCommand(board);
        Position prePos = poses.get(0);
        Position curPos = poses.get(1);
        paneArray[prePos.getX()][prePos.getY()].getChildren().addAll(paneArray[curPos.getX()][curPos.getY()].getChildren().get(0));
        setChessDisable();
        setUndoDisable();
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
            chessMoveInvoker.executeMoveCommand(board, selectedChess, destinationPos);

            if(moveResult == MoveResult.Capture){
                if(board.getCurPlayer() == Player.White){
                    blackBtnSet.remove(paneArray[destinationX][destinationY].getChildren().get(0));
                }
                else{
                    whiteBtnSet.remove(paneArray[destinationX][destinationY].getChildren().get(0));
                }
                paneArray[destinationX][destinationY].getChildren().clear();
            }
            paneArray[destinationX][destinationY].getChildren().addAll(movingBtn);

            GameResult gameResult = board.judge();
            movingBtn = null;
            movingBtnPos = null;
            if(gameResult == GameResult.Gaming){
                board.nextPlayer();
                setChessDisable();
                setUndoDisable();
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
            resultLabel.setText(blackName + " Win!");
            resultFlowPane.getChildren().addAll(new Label(blackName + " Win!"));
        }
        else if(gameResult == GameResult.WhiteWin){
            resultLabel.setText(whiteName + " Win!");
            resultFlowPane.getChildren().addAll(new Label(whiteName + " Win!"));
        }
        else{
            resultLabel.setText("Draw!");
            resultFlowPane.getChildren().addAll(new Label("Draw!"));
        }

        for(Button whiteBtn: whiteBtnSet){
            whiteBtn.setDisable(true);
        }
        for(Button blackBtn: blackBtnSet){
            blackBtn.setDisable(true);
        }
        startItem.setDisable(false);
        setPlayerBtnDisable(true);
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
