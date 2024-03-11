public class Player {
    private int wert;
    private int[] karten;

    public Player() {
        this.karten = new int[11];
    }

    public int[] getKarten() {
        return karten;
    }

    public void setKarten(int karte, int index) {
        this.karten[index] = karte;
    }

    public int getCardsValue() {
        int gesamtzahl = 0;
        for (int i = 0; i < this.getKarten().length; i++) {
            gesamtzahl += this.getKarten()[i];
        }
        return gesamtzahl;
    }
}
