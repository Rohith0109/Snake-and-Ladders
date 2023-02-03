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
    // public static void main(String[] args) {
    //     board brd = new board(1, 100);
    //     Dice d = new riggedDice();
    //     snakes sn = new snakes();
    //     ladders ld = new ladders();
    //     move mv = new move();
    //     int val = mv.position(84, 6);
    //     System.out.println(val);
    //     HashMap<Integer,Integer> snake = new HashMap<>();
    //     snake = sn.genSnakes();
    //     System.out.println(snake);
    //     HashMap<Integer,Integer> ladder = ld.genLadders();
    //     System.out.println(ladder);
    //     // int ch = d.rollADice();
    //     // System.out.println(ch);
    // }
}
