package tec;


public class MonteeTetu extends PassagerAbstrait{

    protected MonteeTetu(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        super(new_nom,new_destination,new_choixPlaceArret);
    } 
    
    protected void choixPlaceMontee(Vehicule v){
        if (v.aPlaceAssise()){
            v.monteeDemanderAssis(this);
        }
        else{
        v.monteeDemanderDebout(this);
        }
    }

}
