package tec;

import tec.TecException;

class TestMonteeSportif extends TestPassagerAbstrait{


    
    protected MonteeSportif creerMontee(String nom, int destination, ComportementArret choixPlaceArret){
        return  new MonteeSportif(nom, destination, choixPlaceArret);
    }

    public void testInteractionMontee() throws TecException {

        MonteeSportif p = creerMontee("yyy", 5, new ArretNerveux());
     
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
    
        assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    
    
        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
    
    
        assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    
    
        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);
    
        assert 0 == faux.logs.size() : "pas de place";        
      }


      public void testInteractionArret(){};

}
