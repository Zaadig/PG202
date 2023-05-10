package tec;


public class GreffonAUn implements InterfaceGreffonAUn{
    
    private Vehicule v;
    private Collection collection;
    public GreffonAUn(Transport ConcreteVehicle, Collection ConcreteCollection){
        v = (Vehicule) ConcreteVehicle;
        collection = ConcreteCollection;
    }
    
    public void arretDemanderDebout(Passager p){
        v.arretDemanderAssis(p);
        
    }
    public void arretDemanderAssis(Passager p){
        v.arretDemanderAssis(p);
        
    }
    public void arretDemanderSortie(Passager p){
        collection.uneSortie();
        v.arretDemanderSortie(p);

    }
    public void allerArretSuivant(){
        Transport t = (Transport) v;
        collection.changerArret();
        t.allerArretSuivant(this);
        
    }
    public void allerArretSuivant(Transport g){
        allerArretSuivant();
    }
    
   public void monteeDemanderAssis(Passager p){
       collection.uneEntree();
        v.monteeDemanderAssis(p);

   }
   public void monteeDemanderDebout(Passager p){
        collection.uneEntree();
        v.monteeDemanderDebout(p);

   }
   public boolean aPlaceAssise(){
        return v.aPlaceAssise();
   }
   public boolean aPlaceDebout(){
        return v.aPlaceDebout();
   }
   public Transport DeclareEmergency(){
    DualStarship starship = (DualStarship)v;
    return starship.DeclareEmergency();
   }

   @Override
   public void greffonAUn_collect_data(){
        collection.get_data();
   }

    @Override
    public Triple greffonAUn_collect_data(int num_arret){
        return collection.get_data(num_arret);
    }

    @Override
    public void greffonAUn_collect_data_line(int num_arret){
        collection.get_data_line(num_arret);
    }
}
