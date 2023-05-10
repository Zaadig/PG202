/**
 * Authors: 
 * Elkarchi Jad
 * Ben Saad Mahmoud
 */
package tec;


abstract class PassagerAbstrait implements Passager, Usager{ 
    private String nom;
    private int destination;
    private Position maPosition = Position.NewPosition();
    private final java.util.List<String> logs = new java.util.LinkedList<String>();
    private ComportementArret choixArret;

    
    public PassagerAbstrait(String new_nom, int new_destination, ComportementArret new_choixPlaceArret){
      nom = new_nom;


      if (new_destination <=0){  
        throw new  IllegalArgumentException("Negative destination");
      }
      
      destination = new_destination;
      choixArret = new_choixPlaceArret;
    }

    @Override
    public String nom() {
      return nom;
    }
  
    @Override
    public boolean estDehors() {
      return maPosition.estDehors();
    }
    
    @Override
    public boolean estAssis() {
      return maPosition.estAssis();
    }
    
    public int distanceArretDestination(int arret){
      return destination - arret;
    }

    @Override
    public boolean estDebout() {
      return maPosition.estDebout();
    }

    public @Override
    void changerEnDehors() {
      logs.add("changerEnDehors");
      maPosition = maPosition.NewPosition();
    }
  
    @Override
    public void changerEnAssis() {
      logs.add("changerEnAssis");
      maPosition = maPosition.assis();
    }
  
    @Override
    public void changerEnDebout() {
      logs.add("changerEnDebout");
      maPosition = maPosition.debout();
    }

  abstract protected void choixPlaceMontee(Vehicule v);

  @Override
  public void nouvelArret(Vehicule bus, int numeroArret) {
    if ( distanceArretDestination(numeroArret) <= 0 ){
      bus.arretDemanderSortie(this);
      return;
    }
      logs.add("nouvelArret");
      choixArret.ChoixPlaceArret(this,distanceArretDestination(numeroArret),bus);
  }
  
    // Autobus n'utilise pas cette méthode.
  @Override
  public void monterDans(Transport t) throws TecException {
    logs.add("monterDans");
    Vehicule bus = (Vehicule) t; 
    if ( !(bus instanceof Vehicule)){
      throw new TecException("converion non faite");
    }
    try{
      choixPlaceMontee(bus);
    }catch(IllegalStateException e){
      throw new TecException(e);
    }
  }
    
    @Override
    public String toString(){
      return nom + " " + maPosition;
    }
  
}

