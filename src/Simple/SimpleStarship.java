import tec.Collection_stock_memoire;
import tec.DualStarship;
import tec.FabriqueTec;
import tec.Starship;
import tec.Usager;
import tec.Transport;
class SimpleStarship{

  static public void main (String[] args) {

        System.out.println("\n \n ======= SimpleStarship ======== \n");

        Collection_stock_memoire c = new Collection_stock_memoire();

        Transport serenity = FabriqueTec.faireDualStarship(1,2,1,2);

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
    System.out.println(serenity);

   // System.out.println(serenity);



    serenity.allerArretSuivant();
    //2
    DualStarship serenity0 = (DualStarship) serenity;
    Transport serenity2 = serenity0.DeclareEmergency();

    System.out.println(serenity);
    System.out.println(serenity2);

    serenity.allerArretSuivant();
    serenity2.allerArretSuivant();
    //3
    System.out.println(serenity);
    System.out.println(serenity2);


    serenity.allerArretSuivant();
    serenity2.allerArretSuivant();
    //4

    try {

      inaraa.monterDans(serenity2);
      
    }catch (Exception e){
      System.out.println (e.getMessage());
    }
    System.out.println(serenity);
    System.out.println(serenity2);


    serenity.allerArretSuivant();
    serenity2.allerArretSuivant();

    System.out.println(serenity);
    System.out.println(serenity2);


    //6
    serenity.allerArretSuivant();
    serenity2.allerArretSuivant();
    System.out.println(serenity);
    System.out.println(serenity2);

    c.get_data();
  }

}

