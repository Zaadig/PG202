package tec;

public class MonteeRepos extends PassagerAbstrait{

    protected MonteeRepos(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        super(new_nom,new_destination,new_choixPlaceArret);
    } 

    protected void choixPlaceMontee(Vehicule v){
        if (v.aPlaceAssise()){
            v.monteeDemanderAssis(this);
        } else if (v.aPlaceDebout()){
            v.monteeDemanderDebout(this);
        }
    }
}
