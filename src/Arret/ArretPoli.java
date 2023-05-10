package tec;


public class ArretPoli implements ComportementArret{
    
    protected ArretPoli(){};
    
    public void ChoixPlaceArret(Passager p, int distanceDestination, Vehicule v){
        if (!v.aPlaceAssise() && p.estAssis()){
            v.arretDemanderDebout(p);
        }
    }
}
