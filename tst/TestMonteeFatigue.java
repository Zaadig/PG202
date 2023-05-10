package tec;

class TestMonteeFatigue extends TestPassagerAbstrait{


    
    protected MonteeFatigue creerMontee(String nom, int destination, ComportementArret choixPlaceArret){
        return  new MonteeFatigue(nom, destination, choixPlaceArret);
    }


    public void testInteractionMontee() throws TecException  {
        MonteeFatigue p = creerMontee("yyy", 5, new ArretPrudent());
      
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
  
        assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
  
        faux = new FauxVehicule(FauxVehicule.ASSIS);
        p.monterDans(faux);
  
        assert "monteeDemanderAssis" == getLastLog(faux) : "assis"; 
    
        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
  
        assert 0 == faux.logs.size() : "pas de place assis reste en dehors";        
    
        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);
    
        assert 0 == faux.logs.size() : "pas de place";        
    }

    public void testInteractionArret(){};




}
