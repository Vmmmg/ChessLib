package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement of the command interface
 */
public class ChessMoveCommand implements Command {

    private ArrayList<ChessPiece> chessList;
    private ArrayList<Position> posList;
    private ChessMove chessMove;

    public ChessMoveCommand(ChessMove chessMove){
        chessList = new ArrayList<>();
        posList = new ArrayList<>();
        this.chessMove = chessMove;
    }

    @Override
    public void execute(Board board, ChessPiece chess, Position destination) {
        chessList.add(chess);
        posList.add(chess.getPosition());
        chessMove.move(board, chess, destination);
    }

    @Override
    public List<Position> undo(Board board) {
        ChessPiece chess = chessList.get(chessList.size() - 1);
        Position pos = posList.get(posList.size() - 1);
        Position curPos = chess.getPosition();
        chessMove.move(board, chess, pos);
        chessList.remove(chessList.size() - 1);
        posList.remove(posList.size() - 1);

        List<Position> poses = new ArrayList<Position>();
        poses.add(pos);
        poses.add(curPos);
        return poses;
    }
}
