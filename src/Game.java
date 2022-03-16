import java.time.LocalDate;


public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String naam, int releaseJaar, double nieuwprijs) {
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwprijs = nieuwprijs;
    }

    public String getNaam(){
        return naam;
    }

    public double huidigeWaarde() {
        int huidigeJaar = LocalDate.now().getYear();
        double jaarVerschil = (huidigeJaar - releaseJaar);
        double huidigePrijs = nieuwprijs * Math.pow(0.7, jaarVerschil);
        return huidigePrijs;
    }

    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar ) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }
    public String toString() {
        return "\n" + naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + String.format("%.2f", nieuwprijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde());
    }
}