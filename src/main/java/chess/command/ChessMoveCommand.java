package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement of the command interface
 */
public class ChessMoveCommand implements Command {

    private ArrayList<ChessPiece> chessList;
    private ArrayList<Position> posList;
    private ChessMove chessMove;

    /**
     * Contructor of ChessMoveCommand
     *
     * @param chessMove Receiver of the Command Pattern
     */
    public ChessMoveCommand(ChessMove chessMove){
        chessList = new ArrayList<>();
        posList = new ArrayList<>();
        this.chessMove = chessMove;
    }

    /**
     * Execute command
     *
     * @param board
     * @param chess  Piece that needs to move
     * @param destination  Destination position
     */
    @Override
    public MoveResult execute(Board board, ChessPiece chess, Position destination) {
        chessList.add(chess);
        posList.add(chess.getPosition());
        return chessMove.move(board, chess, destination);
    }

    /**
     * Undo command
     *
     * @param board
     * @return The chess's positions before undo and after undo
     */
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
