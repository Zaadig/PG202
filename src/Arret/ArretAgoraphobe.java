package tec;

public class ArretAgoraphobe implements ComportementArret{

    protected ArretAgoraphobe(){};
    
    public void ChoixPlaceArret(Passager p, int distanceDestination, Vehicule v){
        if (!v.aPlaceAssise() || !v.aPlaceDebout()){
            v.arretDemanderSortie(p);
        }
    }
}
