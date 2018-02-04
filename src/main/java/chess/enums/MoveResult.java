package chess.enums;

public enum MoveResult {
    LegalMove, // Movement is legal.
    SamePosition, // Destination position is the same as current position.
    OffTheBoard, // Destination position is off the board.
    IllegalMove, // Movement is illegal.
    OverOtherPieces, // Movement needs to get over other pieces.
    PawnDiagonally, // Pawn captures diagonally.
    PawnForward, // Pawn move forward.
    Capture // Movement with capture.
}
