package snake_and_ladders;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;



public class game {

    
    public void startGame() {
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
            System.out.println(curr.name+ " is at "+plac);
            int dic = d.rollADice();
            System.out.print("The dice is rolling. ");
            for (int i=0;i<4;i++){
                d.delay(1);
                System.out.print(". ");
                if (i==3)
                    System.out.print("\n");
            }
            System.out.println("You got "+dic+" on the dice");
            int prev = plac;
            plac = mv.position(plac, dic);
            if (dic==6) {
                int count = 1;
                if (prev != plac) {

                    while (dic == 6 && count != 3 && scan.nextLine().equals("")) {
                        dic = d.rollADice();
                        System.out.println("Now you got "+dic+" on the dice");
                        prev = plac;
                        plac = mv.position(plac, dic);
                        if (brd.isWon(plac)){
                            System.out.println(curr.name+" won the match");
                            continue;
                        }
                        if (dic == 6)
                            count++;
                    }
                    if (count == 3 && dic == 6) {
                        System.out.println("You rolled three 6's! Unfortunately, all three 6's have been cancelled and you will not get an extra turn.");
                        plac = plac - 18;
                        System.out.println("You got back to "+plac);
                    }
                }
            }
            if (plac > brd.max_boxes)
                plac = prev;
            if (brd.isWon(plac)){
                System.out.println(curr.name+" won the match");
                continue;
            }
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
