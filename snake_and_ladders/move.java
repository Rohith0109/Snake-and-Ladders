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
        }
        if (ladder.containsKey(fin))
        fin = ladder.get(fin);
        if (fin>100)
            return curr;
        return fin;
    }
}
