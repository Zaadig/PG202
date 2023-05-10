
/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2019
 **/
package tec;

class Position {

  /*
  private final int DEHORS = 1;
  private final int ASSIS  = 2;
  private final int DEBOUT = 3;
  
     private final int courant;

   */
  private  static  Position PosDehors = new Position();
  private  static  Position PosAssis  = new Position();
  private  static  Position PosDebout = new Position(); 

  /**
   * construit une l'instance dans la position dehors.
   * 
   */
  public static Position NewPosition() {
    /*courant = DEHORS;*/
    return PosDehors;
  }
  
  
  /**
   * Construit une instance en précisant une des positions du passager.
   * 
   *
   */
  private Position() {
    //courant = e;
  }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    /*return courant == DEHORS;*/
    return this == PosDehors;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    //return courant == ASSIS;
    return this == PosAssis;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    //return courant == DEBOUT;
    return this == PosDebout;
  }

  public static Position assis(){
    return PosAssis;
  }

  public static Position debout(){
    return PosDebout;
  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    //return courant != DEHORS;
    return this != Position.PosDehors;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
  @Override
  public String toString() {
    String nom = null;
    if ( this == Position.PosDehors) 
      nom = "endehors";
    else if ( this == Position.PosAssis ) 
      nom = "assis";
    else 
      nom = "debout";
    return "<" + nom + ">";
  }
}