package chess.models.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;

import java.util.ArrayList;

/**
 * Implement of the command interface
 */
public class ChessMoveCommand implements Command {

    private ArrayList<ChessPiece> movingChessList;
    private ArrayList<Position> originPosList;
    private ArrayList<ChessPiece> capturedChessList;
    private ArrayList<Position> destinationPosList;
    private ChessMove chessMove;

    /**
     * Contructor of ChessMoveCommand
     *
     * @param chessMove Receiver of the Command Pattern
     */
    public ChessMoveCommand(ChessMove chessMove){
        movingChessList = new ArrayList<>();
        originPosList = new ArrayList<>();
        capturedChessList = new ArrayList<>();
        destinationPosList = new ArrayList<>();
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
        movingChessList.add(chess);
        originPosList.add(chess.getPosition());
        capturedChessList.add(board.getSpecificPositionChess(destination));
        destinationPosList.add(destination);

        return chessMove.move(board, chess, destination);
    }

    /**
     * Undo command
     *
     * @param board
     */
    @Override
    public void undo(Board board) {
        ChessPiece movingChess = movingChessList.get(movingChessList.size() - 1);
        Position originPos = originPosList.get(originPosList.size() - 1);
        ChessPiece capturedChess = capturedChessList.get(capturedChessList.size() - 1);
        Position destinationPos = destinationPosList.get(destinationPosList.size() - 1);

        chessMove.undo(board, movingChess, originPos, capturedChess, destinationPos);

        movingChessList.remove(movingChessList.size() - 1);
        originPosList.remove(originPosList.size() - 1);
        capturedChessList.remove(capturedChessList.size() - 1);
        destinationPosList.remove(destinationPosList.size() - 1);
    }
}
