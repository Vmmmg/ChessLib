package chess;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private int x;
    private int y;

    public Position(String position){
        this.x = position.substring(0, 1).toUpperCase().charAt(0) - 'A';
        this.y = Integer.parseInt(position.substring(1, 2)) - 1;
    }
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean equals(Position pos){
        int otherX = pos.getX();
        int otherY = pos.getY();
        if(x == otherX){
            if(y == otherY){
                return true;
            }
        }

        return false;
    }

    public int distance(Position pos){
        if(this.isVertical(pos)){
            return Math.abs(y - pos.getY());
        }
        else if(this.isHorizontal(pos)){
            return Math.abs(x - pos.getX());
        }
        else if(this.isDiagonal(pos)){
            return Math.abs(x - pos.getX());
        }

        return -1;
    }

    public boolean isHorizontal(Position pos){
        if(y == pos.getY()){
            return true;
        }

        return false;
    }

    public boolean isVertical(Position pos){
        if(x == pos.getX()){
            return true;
        }

        return false;
    }

    public boolean isDiagonal(Position pos){
        if(Math.abs(x - pos.getX()) == Math.abs(y - pos.getY())){
            return true;
        }

        return false;
    }

    public boolean isLShape(Position pos){
        if(Math.abs(x - pos.getX()) == 2){
            if(Math.abs(y - pos.getY()) == 1){
                return true;
            }
        }
        else if (Math.abs(x - pos.getX()) == 1){
            if(Math.abs(y - pos.getY()) == 2){
                return true;
            }
        }

        return false;
    }

    public List aroundPos(){
        List aroundPos = new ArrayList();
        aroundPos.add(new Position(x-1, y-1));
        aroundPos.add(new Position(x, y-1));
        aroundPos.add(new Position(x+1, y-1));
        aroundPos.add(new Position(x-1, y));
        aroundPos.add(new Position(x+1, y));
        aroundPos.add(new Position(x-1, y+1));
        aroundPos.add(new Position(x, y+1));
        aroundPos.add(new Position(x+1, y+1));

        return aroundPos;
    }
}
