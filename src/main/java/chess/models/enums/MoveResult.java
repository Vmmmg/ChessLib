package chess.models.enums;

public enum MoveResult {
    LegalMove,
    SamePosition,
    OffTheBoard,
    IllegalMove,
    OverOtherPieces,
    PawnDiagonally,
    PawnForward,
    Capture
}
