package tec;

public class MonteeFatigue extends PassagerAbstrait{

    protected MonteeFatigue(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        super(new_nom,new_destination,new_choixPlaceArret);
    } 

    protected void choixPlaceMontee(Vehicule v){
        if (v.aPlaceAssise()){
            v.monteeDemanderAssis(this);
        }
    }
}
