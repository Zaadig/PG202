package tec;

public class MonteeSportif extends PassagerAbstrait{

    protected MonteeSportif(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        super(new_nom,new_destination,new_choixPlaceArret);
    } 

    protected void choixPlaceMontee(Vehicule v){
        if (v.aPlaceDebout()){
            v.monteeDemanderDebout(this);
        }
    }
}
