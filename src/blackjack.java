import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class blackjack {

    static int randomNumber;
    static player p = new player();
    static dealer d = new dealer();

    static boolean ja;

    public static void random() {
        Random random = new Random();
        randomNumber = random.nextInt(10) + 2;
    }

    public static void blackjacks() {

        System.out.println("Das ist Blackjack, deine erste karte ist");
        random();
        p.wert = randomNumber;
        p.karten[0] = new Cards(randomNumber);
        System.out.println(p.karten[0]);

        System.out.println("Die erste Karte des dealers ist:");
        random();
        d.wert = randomNumber;
        System.out.println(d.wert);

        System.out.println("deine zweite Karte ist eine");
        random();
        p.wert = p.wert + randomNumber;
        System.out.println(randomNumber);
        hit();
    }

    public static void hit(){
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("willst du noch eine karte? Y/N");
            String hitnot = scan.nextLine();

            if (Objects.equals(hitnot, "Y")) {
                ja = true;
                random();
                p.wert = p.wert + randomNumber;
                if (p.wert > 21) {
                    System.out.println("du hast " + p.wert);
                    System.out.println("Player bust You Lose");
                    nochmal();
                }
                System.out.println(p.wert);

            }else {
                ja = false;
                random();
                d.wert = d.wert + randomNumber;
                System.out.println("der dealer hat " + d.wert);

                while (d.wert < p.wert && d.wert < 17) {
                    random();
                    d.wert = d.wert + randomNumber;
                    System.out.println("dealer nimmt noch eine karte und hat " + d.wert);
                    if (d.wert > 21) {
                        System.out.println("Dealer bust You Win");
                        nochmal();

                    }
                }

                if (d.wert > p.wert) {
                    System.out.println("der dealer hat insgesamt " + d.wert + ". Du hast insgesamt " + p.wert);
                    System.out.println("dealer hat mehr. Du verlierst");
                    nochmal();
                } else {
                    System.out.println("der dealer hat insgesamt " + d.wert + ". Du hast insgesamt " + p.wert);
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
