package snake_and_ladders;

import java.util.*;

public class normalDice implements Dice{
    public int rollADice(){
        Random rnd = new Random();
        int choice = rnd.nextInt(7);
        while (choice==0){
            choice = rnd.nextInt(7);
        }
        return choice;
    }
    public void delay(int n){
        try {
            Thread.sleep(n*200);
        } catch (Exception e){

        }
    }
}
