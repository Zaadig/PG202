package tec;

public final class FabriqueTec{


    private FabriqueTec(){};
    
    
    public static Transport faireAutobus(int nbPlace_assise, int nbPlace_debout){
        return (Transport) new Autobus(nbPlace_assise,nbPlace_debout);
    }

    public static Transport faireGreffonestUn(int nbPlace_assise, int nbPlace_debout, Collection c){
        return (Transport) new GreffonestUn(nbPlace_assise,nbPlace_debout,c);
    }

    public static Transport faireGreffonAUn(Transport v, Collection c){
        return (Transport) new GreffonAUn(v,c); 
    }

    public static Transport faireDualStarship(int nbPlace_assise, int nbPlace_debout,
                                                int nbPlace_assise_emergency, int nbPlace_debout_emergency){
        return (Transport) new DualStarship(nbPlace_assise,nbPlace_debout,nbPlace_assise_emergency,nbPlace_debout_emergency);
    }

    public static Usager faireMonteeFatigue(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        return (Usager) new MonteeFatigue(new_nom,new_destination,new_choixPlaceArret);
    }

    public static Usager faireMonteeRepos(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        return (Usager) new MonteeRepos(new_nom,new_destination,new_choixPlaceArret);
    }

    public static Usager faireMonteeSportif(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        return (Usager) new MonteeSportif(new_nom,new_destination,new_choixPlaceArret);
    }
    public static Usager faireMonteeTetu(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
        return (Usager) new MonteeTetu(new_nom,new_destination,new_choixPlaceArret);
    }

    public static ComportementArret faireArretNerveux(){
        return (ComportementArret) new ArretNerveux();
    }

    public static ComportementArret faireArretPoli(){
        return (ComportementArret) new ArretPoli();
    }

    public static ComportementArret faireArretCalme(){
        return (ComportementArret) new ArretCalme();
    }

    public static ComportementArret faireArretPrudent(){
        return (ComportementArret) new ArretPrudent();
    }

    public static ComportementArret faireArretAgoraphobe(){
        return (ComportementArret) new ArretAgoraphobe();
    }



}