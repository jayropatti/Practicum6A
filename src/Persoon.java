import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon(String naam, double budget){
        this.naam = naam;
        this.budget = budget;
        mijnGames = new ArrayList<Game>();
    }

    public double getBudget(){
        return budget;
    }

    public boolean koop(Game game){
        for(int i=0; i < mijnGames.size();i++){
            if (mijnGames.get(i).equals(game)){
                return false;
            }
        }

        if (game.huidigeWaarde() < budget){
            this.budget -= game.huidigeWaarde(); //haal huidige waarde v budget af
            mijnGames.add(game);
            return true; //game is gekocht
        }
        return false;
    }

    public boolean verkoop(Game game, Persoon koper) {
        for (int i = 0; i < mijnGames.size(); i++) { //check voor alle games in list mijn games of game verkocht kan worden
            if (mijnGames.get(i).equals(game)) {
                if (koper.mijnGames.size() == 0) {
                    if (koper.budget > game.huidigeWaarde()) { // kijk of koper genoeg geld heeft voor game
                        koper.budget -= game.huidigeWaarde(); //budget v koper gaat omlaag
                        budget += game.huidigeWaarde(); // budget v verkoper omhoog met huidige waarde v game
                        mijnGames.remove(game); // game verwijdert van list mijnGames verkoper
                        koper.mijnGames.add(game); // regel 41 andersom
                        return true; // Game is verkocht
                    }

                }
                for (Game game2 : koper.mijnGames) {
                    if (game2.equals(game)) {
                    } else {
                        if (koper.budget > game.huidigeWaarde()) {
                            koper.budget -= game.huidigeWaarde();
                            budget += game.huidigeWaarde();
                            mijnGames.remove(game);
                            koper.mijnGames.add(game);
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }

    public String toString() {
        StringBuilder s = new StringBuilder(naam + " heeft een budget van €" + String.format("%.2f", getBudget()) + " en bezit de volgende games:");
        for (Game game : mijnGames){
            s.append(game);
        }
        return s.toString();
    }
}
