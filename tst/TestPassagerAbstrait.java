package tec;

abstract class TestPassagerAbstrait{

    abstract protected PassagerAbstrait creerMontee(String nom, int destination, ComportementArret choixPlaceArret);
    abstract void testInteractionArret()  throws TecException;
    abstract void testInteractionMontee()  throws TecException ;

    //********************************************************
    /* Etat apres instanciation
    * Un seul cas 
    */  
    public void testInstanciation() {
        PassagerAbstrait p = creerMontee("xxx", 3, new ArretCalme());

        assert false == p.estAssis();
        assert false == p.estDebout();
        assert true == p.estDehors();
    }

    /* Gestion des changement d'état.
    * 
    * Changer Debout puis Dehors puis assis. 
    */
    public void testGestionEtat() {
        PassagerAbstrait p = creerMontee("yyy", 3, new ArretCalme());

        p.changerEnDebout();
        assert false == p.estAssis();
        assert true == p.estDebout();
        assert false == p.estDehors();

        p.changerEnDehors();
        assert false == p.estAssis();
        assert false == p.estDebout();
        assert true == p.estDehors();

        p.changerEnAssis();
        assert true == p.estAssis();
        assert false == p.estDebout();
        assert false == p.estDehors();
    }  


    public String getLastLog(FauxVehicule f) {
        return f.logs.get(f.logs.size() - 1);
    }
}
