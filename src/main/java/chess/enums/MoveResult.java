package chess.enums;

public enum MoveResult {
    LegalMove,
    SamePosition,
    OffTheBoard, //棋盘判断
    IllegalMove,
    OverOtherPieces,  //棋盘判断，如果是马就可以越，其他不能越
    PawnDiagonally, //棋盘判断，是否吃子，如果能吃就可以走，如果不能吃就不能走
    Capture  //棋盘判断
}
