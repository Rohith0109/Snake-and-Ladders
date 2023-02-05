package snake_and_ladders;

import java.util.Random;

public class riggedDice implements Dice{
    public int rollADice(){
        Random rnd = new Random();
        int num = rnd.nextInt(6);
        while(num==0 || num%2==0){
            num = rnd.nextInt(6);
        }
        return num;
    }
    public void delay(int n){
        try {
            Thread.sleep(n*200);
        } catch (Exception e){

        }
    }
}
