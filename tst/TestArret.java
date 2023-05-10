package tec;
class TestArret extends TestPassagerAbstrait {
    

    @Override
    protected MonteeRepos creerMontee(String nom, int destination, ComportementArret choixPlaceArret){
        return  new MonteeRepos(nom, destination, choixPlaceArret);
    }    

    @Override
    public void testInteractionMontee(){};

    @Override
    public void testInteractionArret() {

        /* Arret calme */

        MonteeRepos p = creerMontee("yyy", 5, new ArretCalme());

        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

        p.nouvelArret(faux, 1);
        assert 0 == faux.logs.size() : "pas a destination";

        p.nouvelArret(faux, 5);
        assert "arretDemanderSortie" == getLastLog(faux) : "destination"; 
        

            /* Arret Prudent */

        p = creerMontee("yyy", 8, new ArretPrudent());
    
        Transport Bus = new Autobus(2,2);

        try {
            p.monterDans(Bus);
        }catch (Exception e){
            System.out.println (e.getMessage());
        }
        
        assert p.estAssis() : "passager non assis"; 

        Bus.allerArretSuivant(); // arret 0
        assert p.estAssis() : "passager doit rester assis"; 
        Bus.allerArretSuivant();
        Bus.allerArretSuivant();
        Bus.allerArretSuivant();
        Bus.allerArretSuivant();
        Bus.allerArretSuivant();//arret 5
        assert p.estDebout() : "passager doit etre assis";


            /* Arret nerveux */

        p = creerMontee("yyy", 5, new ArretNerveux());

        faux = new FauxVehicule(FauxVehicule.VIDE);

        p.nouvelArret(faux, 1);
        assert 0 == faux.logs.size() : "pas a destination";

        p.nouvelArret(faux, 5);
        assert "arretDemanderSortie" == getLastLog(faux) : "destination";


    }
        
}