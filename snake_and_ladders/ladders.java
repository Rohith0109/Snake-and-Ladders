package snake_and_ladders;

import java.util.HashMap;

public class ladders {
    public HashMap<Integer,Integer> genLadders(){
        HashMap<Integer,Integer> ladder = new HashMap<Integer, Integer>(){{
            put(3,21);
            put(8,55);
            put(16,26);
            put(32,48);
            put(37,76);
            put(50,70);
            put(64,83);
            put(77, 95);
            put(80, 99);
            put(89,91);
        }};
        return ladder;
    }

   

}
