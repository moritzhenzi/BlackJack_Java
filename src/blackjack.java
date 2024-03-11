import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class blackjack {

    static int randomNumber;
    public static Player p = new Player();
    public static Player d = new Player();
    static boolean ja;

    public static void random() {
        Random random = new Random();
        randomNumber = random.nextInt(10) + 2;
    }

    public static void blackjacks() {
        System.out.println("Das ist Blackjack, deine erste karte ist");
        setCardForPlayer(p,0);

        System.out.println("Die erste Karte des dealers ist:");
        setCardForPlayer(d,0);

        System.out.println("deine zweite Karte ist eine");
        setCardForPlayer(p,1);


        hit();
    }
    public static void setCardForPlayer(Player p, int index){
        random();
        p.setKarten(randomNumber,index);
        System.out.println(p.getKarten()[index]);
    }

    public static void hit(){
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("willst du noch eine karte? Y/N");
            String hitnot = scan.nextLine();

            if (Objects.equals(hitnot, "Y")) {
                ja = true;
                random();
                if (p.getCardsValue() > 21) {

                    for (int i = 0; i < p.getKarten().length; i++) {
                        if (p.getKarten()[i] == 11) {
                            p.setKarten(1, i);
                            System.out.println("das Ass wird zu einer 1 und du hast jetzt " + p.getCardsValue());
                            hit();
                        }
                    }
                    System.out.println("du hast " + p.getCardsValue());
                    System.out.println("Player bust You Lose");
                    nochmal();


                }
                System.out.println(p.getCardsValue());

            }else {
                ja = false;
                random();
                System.out.println("der dealer hat " + d.getCardsValue());

                while (d.getCardsValue() < p.getCardsValue() && d.getCardsValue() < 17) {
                    random();
                    System.out.println("dealer nimmt noch eine karte und hat " + d.getCardsValue());
                    if (d.getCardsValue() > 21) {
                        System.out.println("Dealer bust You Win");
                        nochmal();

                    }
                }

                if (d.getCardsValue() > p.getCardsValue()) {
                    System.out.println("der dealer hat insgesamt " + d.getCardsValue() + ". Du hast insgesamt " + p.getCardsValue());
                    System.out.println("dealer hat mehr. Du verlierst");
                    nochmal();
                } else {
                    System.out.println("der dealer hat insgesamt " + d.getCardsValue() + ". Du hast insgesamt " + p.getCardsValue());
                    System.out.println("Du gewinnst");
                    nochmal();

                }

            }
        } while (ja);

    }

    public static void nochmal(){
        Scanner scan = new Scanner(System.in);
        System.out.println("willst du nochmals spielen? Y/N");
        String noch = scan.nextLine();

        if (Objects.equals(noch, "Y")){
            blackjacks();
        } else {
            System.exit(1);
        }
    }


}

