package tec;

public class ArretPrudent implements ComportementArret{

    protected ArretPrudent(){};
    
    public void ChoixPlaceArret(Passager p, int distanceDestination, Vehicule v){
        if( (distanceDestination < 3) && v.aPlaceDebout() && p.estAssis()){
            v.arretDemanderDebout(p);
        } else if ((distanceDestination > 5) && v.aPlaceAssise() && p.estDebout()){
            v.arretDemanderAssis(p);
        }

    }
       
}
