package snake_and_ladders;

import java.util.HashMap;

public class board {
    int max_boxes;
    int min;
    public board(int min, int max_boxes){
        this.max_boxes = max_boxes;
        this.min = min;
    }

    public boolean isWon(int num){
        if (num==max_boxes)
        return true;
        return false;
    }
}
