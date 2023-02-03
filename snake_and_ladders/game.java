package snake_and_ladders;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;

class player{
    String name;
    int pos;
    player(String name, int pos){
        this.name = name;
        this.pos = pos;
    }
}

public class game {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first player name: ");
        String player1 = scan.next();
        System.out.println();
        System.out.print("Enter second player name: ");
        String player2 = scan.next();
        System.out.println();
        board brd = new board(1, 100);
        Dice d = new normalDice();
        move mv = new move();
        Queue<player> que = new LinkedList<>();
        que.offer(new player(player1, 0));
        que.offer(new player(player2, 0));
        //int n=0;
        while (que.size()>1){
            player curr = que.poll();
            int plac = curr.pos;
            System.out.println("Present "+curr.name+ " is at "+plac);
            int dic = d.rollADice();
            System.out.println(dic);
            int prev = plac;
            plac = mv.position(plac, dic);
            if (dic==6){
                int count = 1;
                if (prev!=plac) {

                    while (dic == 6 && count != 3) {
                        dic = d.rollADice();
                        System.out.println(dic);
                        prev = plac;
                        plac = mv.position(plac, dic);
                        if (dic == 6)
                            count++;
                    }
                    if (count == 3 && dic == 6)
                        plac = plac - 12;
                }
            }
            if (plac> brd.max_boxes)
                plac = prev;
            //plac = chang;
            if (brd.isWon(plac)){
                System.out.println(curr.name+" won the match");
                break;
            }
            else{
                que.add(new player(curr.name, plac));
            }
            System.out.println(curr.name+" turn is over. Current position is "+plac);
            System.out.println("Press Enter to continue the game");
//            next = scan.next();

//            if(n>50)
//                break;
//            n++;
        }
        scan.close();
    }
}
