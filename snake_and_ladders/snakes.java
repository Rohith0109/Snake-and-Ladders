package snake_and_ladders;

import java.util.HashMap;

public class snakes {
    
    public HashMap<Integer, Integer> genSnakes(){
        HashMap<Integer, Integer> snake = new HashMap<Integer, Integer>(){{
            put(23,4);
            put(43,38);
            put(56,25);
            put(61,59);
            put(69, 12);
            put(86,54);
            put(90,72);
            put(94, 73);
            put(96, 84);
            put(98, 58);
        }};

        return snake;
    }


}
