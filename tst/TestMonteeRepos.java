package tec;

class TestMonteeRepos extends TestPassagerAbstrait{



    protected MonteeRepos creerMontee(String nom, int destination, ComportementArret choixPlaceArret){
        return  new MonteeRepos(nom, destination, choixPlaceArret);
    }
    
      

      public void testInteractionMontee() throws TecException {
        
        MonteeRepos p = creerMontee("yyy", 5, new ArretCalme());
     
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
    
        assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
    
        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
    
        assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    
    
        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);
    
        assert 0 == faux.logs.size() : "pas de place";        
      }

      public void testInteractionArret(){};
    

}
