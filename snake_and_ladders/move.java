package snake_and_ladders;
import java.util.HashMap;
public class move {
    snakes sn = new snakes();
    ladders ld = new ladders();
    public int position(int curr, int choice){
        HashMap<Integer,Integer> snake = sn.genSnakes();
        HashMap<Integer,Integer> ladder = ld.genLadders();
        int fin = curr+choice;
        if (snake.containsKey(fin)){
            fin = snake.get(fin);
            System.out.println("Oh no, you landed on a snake and slid down to "+fin+"!");
        }
        else if (ladder.containsKey(fin)) {
            fin = ladder.get(fin);
            System.out.println("You climbed the ladder and advanced to "+fin+"!");
        }
        else if (fin>100) {
            System.out.println("Looks like you don't have a move");
            return curr;
        }
        else{
            System.out.println("You moved to "+fin);
        }
        return fin;
    }
}
