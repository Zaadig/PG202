package tec;

public class ArretNerveux implements ComportementArret{

    protected ArretNerveux(){};
    
    public void ChoixPlaceArret(Passager p, int distanceDestination, Vehicule v){
        if (p.estDebout() && v.aPlaceAssise()){
            v.arretDemanderAssis(p);
        } else if (p.estAssis() && v.aPlaceDebout()){
            v.arretDemanderDebout(p);
        }
    }
}
