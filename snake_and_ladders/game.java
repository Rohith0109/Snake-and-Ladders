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
        System.out.print("Enter the no of playes: ");
        int no_of_players = scan.nextInt();
        board brd = new board(1, 100);
        Dice d = new normalDice();
        move mv = new move();
        Queue<player> que = new LinkedList<>();
        for (int i=0;i<no_of_players;i++){
            System.out.print("Enter your name: ");
            que.offer(new player(scan.next(),0));
            System.out.println();
        }
        System.out.print("Enter 1 to play the game: ");
        String next = scan.nextLine();
        //int n=0;
        while (que.size()>1){
            player curr = que.poll();
            int plac = curr.pos;
            System.out.println(curr.name+ " is initially at "+plac);
            int dic = d.rollADice();
            System.out.println("You got "+dic+" on the dice");
            int prev = plac;
            plac = mv.position(plac, dic);
            if (dic==6) {
                int count = 1;
                if (prev != plac) {

                    while (dic == 6 && count != 3) {
                        dic = d.rollADice();
                        System.out.println("Now you got "+dic+" on the dice");
                        prev = plac;
                        plac = mv.position(plac, dic);
                        if (dic == 6)
                            count++;
                    }
                    if (count == 3 && dic == 6)
                        plac = plac - 18;
                }
            }
            if (plac<prev){
                System.out.println("Oops! you were caught by a snake");
            }
            else if (plac==prev){
                System.out.println("Looks like you don't have a move");
            }
            if (plac> brd.max_boxes)
                plac = prev;
            //plac = chang;
            if (brd.isWon(plac)){
                System.out.println(curr.name+" won the match");
                continue;
            }
            System.out.println(curr.name+"'s current position is "+plac);
            System.out.println("Press enter to continue. 0 to quit");
            next = scan.nextLine();
            if (next.equals("")){
                que.add(new player(curr.name, plac));
            }

//            if(n>50)
//                break;
//            n++;
        }
        scan.close();
    }
}
