package tec;
import java.util.LinkedList;
import java.util.ListIterator;

public class Starship implements Vehicule,Transport{
    private int nbPlaceAssise; // maximum number of seats
    private int nbPlaceDebout; // maximum number of standing places
    private int AssisePlaces = 0; // number of seats used
    private int DeboutPlaces = 0; // number of standing places used
    protected int numArret = 0;
    private Jauge jauge_assis;
    private Jauge jauge_debout;
    protected LinkedList<Passager> passagers = new LinkedList<Passager>();  // passangers array
    protected ListIterator<Passager> listIterator;
    protected boolean isEmergency = false;
    

    public Starship(int nbPlaceA, int nbPlaceD){
        if (nbPlaceA < 0 || nbPlaceD < 0){
            throw new IllegalArgumentException("Number of places sit/stand is negative");
        }

        nbPlaceAssise = nbPlaceA;
        nbPlaceDebout = nbPlaceD;
   
        jauge_assis = new Jauge(nbPlaceA, 0);
        jauge_debout = new Jauge(nbPlaceD, 0);
    }

    private void SeatsUpdate(int Assise,int Debout){
        AssisePlaces+=Assise;
        DeboutPlaces+=Debout;
    }

    public boolean aPlaceAssise(){
        if(isEmergency){
            return false;
        }
        return jauge_assis.estVert();
    }

   
    public boolean aPlaceDebout(){
        if(isEmergency){
            return false;
        }
        return jauge_debout.estVert();
    }


   
    public void arretDemanderAssis(Passager p){
        jauge_debout.decrementer();
        jauge_assis.incrementer();
        p.changerEnAssis();
        SeatsUpdate(1,-1);
    }

   
    public void arretDemanderDebout(Passager p){
        jauge_assis.decrementer();
        jauge_debout.incrementer();
        p.changerEnDebout();
        SeatsUpdate(-1, 1);
    }

   
    public void arretDemanderSortie(Passager p){
        if (!p.estDehors()){
            if (p.estAssis()){
                jauge_assis.decrementer();
                SeatsUpdate(-1, 0);
            }
            else {
                jauge_debout.decrementer();
                SeatsUpdate(0,-1);
            }
            p.changerEnDehors();
            try{listIterator.remove();} catch(UnsupportedOperationException | IllegalStateException e){}
        }
    }

    /*
     * checks if the  passanger is in the starship
     */

    private boolean passangerInStarship(Passager p){


        listIterator = passagers.listIterator();
        
        Passager ps;

        for (;listIterator.hasNext();){

            ps=listIterator.next();
            if ( ps==p ){
                return true;
            }
        }
        return false;
    }

    
   
    public void monteeDemanderAssis(Passager p){
        if (passangerInStarship(p)){
            throw new IllegalStateException("passanger already in the starship");
        }
        jauge_assis.incrementer();
        p.changerEnAssis();
        listIterator.add(p);
        SeatsUpdate(1,0);
    }
   
    public void monteeDemanderDebout(Passager p){
        if (passangerInStarship(p)){
            throw new IllegalStateException("passanger already in the starship");
        }
        jauge_debout.incrementer();
        p.changerEnDebout();
        listIterator.add(p);
        SeatsUpdate(0,1);
    }

    public void allerArretSuivant(Transport greffon){
        if(!isEmergency){

            numArret += 1;

            listIterator = passagers.listIterator();
            Passager p;

            for (;listIterator.hasNext();){
                p=listIterator.next();   
                p.nouvelArret((Vehicule) greffon,numArret);
            }
        }
    }

    public void allerArretSuivant(){
        allerArretSuivant(this);
    }



    @Override
    public String toString() {
        return "[arret"+numArret+"]: assis <" + (AssisePlaces) + "> debout <" + (   DeboutPlaces) + "> ";
    }

}
