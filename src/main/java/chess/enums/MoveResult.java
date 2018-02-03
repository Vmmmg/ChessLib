package chess.enums;

public enum MoveResult {
    LegalMove,
    SamePosition,
    OffTheBoard,
    IllegalMove,
    OverOtherPieces,
    PawnDiagonally,
    Capture
}
