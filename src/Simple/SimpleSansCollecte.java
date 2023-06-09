import tec.FabriqueTec;
import tec.Transport;
import tec.Usager;
class SimpleSansCollecte {

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
    System.out.println("======= SimpleSanscollecte ======== \n");

        Transport serenity = FabriqueTec.faireAutobus(1, 2);

        Usager kaylee = FabriqueTec.faireMonteeRepos("Kaylee_Standard", 4, FabriqueTec.faireArretCalme());
        Usager jayne = FabriqueTec.faireMonteeRepos("jayne_Standard", 4, FabriqueTec.faireArretCalme());
        Usager inara = FabriqueTec.faireMonteeRepos("inara_Standard", 5, FabriqueTec.faireArretCalme());
        Usager inaraa = FabriqueTec.faireMonteeRepos("inaraa_Standard", 5, FabriqueTec.faireArretCalme());
        

    //0
    System.out.println(serenity);

    serenity.allerArretSuivant();
    //1

    try {

      kaylee.monterDans(serenity);
      jayne.monterDans(serenity);
      inara.monterDans(serenity);
      
    }catch (Exception e){
      System.out.println (e.getMessage());
    }
    

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //2
    

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    serenity.allerArretSuivant();
    //3
  

    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //4

    try {

      inaraa.monterDans(serenity);
      
    }catch (Exception e){
      System.out.println (e.getMessage());
    }
    
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    //6
    serenity.allerArretSuivant();
    
  }
}

/* Resultat de l'execution: 
[arret 0] assis<1> debout<2>
[arret 1] assis<0> debout<2>
Kaylee <assis>
[arret 2] assis<0> debout<1>
Kaylee <assis>
Jayne <debout>
[arret 3] assis<0> debout<0>
Kaylee <assis>
Jayne <debout>
Inara <debout>
[arret 4] assis<1> debout<1>
Kaylee <endehors>
Jayne <endehors>
Inara <debout>
[arret 5] assis<1> debout<2>
Kaylee <endehors>
Jayne <endehors>
Inara <endehors>
*/

