import tec.Collection_stock_memoire;
import tec.DualStarship;
import tec.FabriqueTec;
import tec.GreffonAUn;
import tec.Starship;
import tec.Usager;
import tec.Transport;
public class SimpleCollecteDualStarshipAUn{


  /*
   * Affiche l'etat des deux instances passees en parametre.
   * La methode println(Object x) de la classe PrintWriter 
   * declenche la methode toString() sur l'objet passe 
   * en parametre (x.toString()) et affiche la chaine 
   * de caracteres obtenue..
   */
  static private void deboguerEtat (Transport t, Usager p) {
    System.out.println(p);
    System.out.println(t);
  }

  static public void main (String[] args) {

        System.out.println("\n \n ======= SimpleCollecteDualStarship ======== \n");

        Collection_stock_memoire c = new Collection_stock_memoire();

        //Transport serenity = FabriqueTec.faireDualStarship(1, 2, 1, 2);
        Transport serenity = FabriqueTec.faireGreffonAUn(FabriqueTec.faireDualStarship(1, 2,
                                                         1, 2),c);
                                                         
        Usager kaylee = FabriqueTec.faireMonteeRepos("Kaylee_Standard", 4, FabriqueTec.faireArretCalme());
        Usager jayne = FabriqueTec.faireMonteeRepos("jayne_Standard", 4, FabriqueTec.faireArretCalme());
        Usager inara = FabriqueTec.faireMonteeRepos("inara_Standard", 5, FabriqueTec.faireArretCalme());
        Usager inaraa = FabriqueTec.faireMonteeRepos("inaraa_Standard", 5, FabriqueTec.faireArretCalme());
        
    //0

    serenity.allerArretSuivant();
    //1

    try {

      kaylee.monterDans(serenity);
      jayne.monterDans(serenity);
      inara.monterDans(serenity);
      
    }catch (Exception e){
      System.out.println (e.getMessage());
    }
    

   // System.out.println(serenity);



    serenity.allerArretSuivant();
    //2
    GreffonAUn serenity0 = (GreffonAUn) serenity;
    Transport serenity2 = FabriqueTec.faireGreffonAUn(serenity0.DeclareEmergency(),c);

    serenity2.allerArretSuivant();
    //3


    serenity2.allerArretSuivant();
    //4

    try {

      inaraa.monterDans(serenity2);
      
    }catch (Exception e){
      System.out.println (e.getMessage());
    }
    serenity2.allerArretSuivant();

    //6
    serenity2.allerArretSuivant();
    c.get_data();
  }

}
