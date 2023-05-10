/**
 * Authors:
 * Elalaoui Mohamed Seddiq
 * Boz Atman
 */
package tec;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class Autobus implements Vehicule, Transport{

    private int nbPlaceAssise; // maximum number of seats
    private int nbPlaceDebout; // maximum number of standing places
    private int AssisePlaces = 0; // number of seats used
    private int DeboutPlaces = 0; // number of standing places used
    private int numArret = 0;
    private Jauge jauge_assis;
    private Jauge jauge_debout;
    private LinkedList<Passager> passagers = new LinkedList<Passager>();  // passangers array
    private ListIterator<Passager> listIterator;
 
    public Autobus(int nbPlaceA, int nbPlaceD){
        
        if (nbPlaceA < 0 || nbPlaceD < 0){
            throw new IllegalArgumentException("Number of places sit/stand is negative");
        }

        nbPlaceAssise = nbPlaceA;
        nbPlaceDebout = nbPlaceD;
   
        jauge_assis = new Jauge(nbPlaceA, 0);
        jauge_debout = new Jauge(nbPlaceD, 0);
    }



    /*
        Updates number of standing places used and number of seats used
     */

    private void SeatsUpdate(int Assise,int Debout){
        AssisePlaces+=Assise;
        DeboutPlaces+=Debout;
    }

    
    public void allerArretSuivant(){
        allerArretSuivant(this);
    }
   
    
    public void allerArretSuivant(Transport greffon){

        numArret += 1;

        listIterator = passagers.listIterator();
        Passager p;

        for (;listIterator.hasNext();){

            try{
            p=listIterator.next();   
            p.nouvelArret((Vehicule) greffon,numArret);
            } catch(NoSuchElementException e){}
        }

    }

    
   
    
    public boolean aPlaceAssise(){
        return jauge_assis.estVert();
    }

   
    
    public boolean aPlaceDebout(){
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
     * checks if the  passanger is in Autobus
     */

    private boolean passangerInBus(Passager p){


        listIterator = passagers.listIterator();
        
        Passager ps;

        for (;listIterator.hasNext();){

            try{
                ps=listIterator.next();
                if ( ps==p ){
                    return true;
                }
            } catch(NoSuchElementException e){}
        }
        return false;
    }

    
   
    
    public void monteeDemanderAssis(Passager p){
        if (passangerInBus(p)){
            throw new IllegalStateException("passanger already in the bus");
        }
        jauge_assis.incrementer();
        p.changerEnAssis();
        listIterator.add(p);
        SeatsUpdate(1,0);
    }

    
   
    
    public void monteeDemanderDebout(Passager p){
        if (passangerInBus(p)){
            throw new IllegalStateException("passanger already in the bus");
        }
        jauge_debout.incrementer();
        p.changerEnDebout();
        listIterator.add(p);
        SeatsUpdate(0,1);
    }



    @Override
    public String toString() {
        return "[arret"+numArret+"]: assis <" + (AssisePlaces) + "> debout <" + (   DeboutPlaces) + "> ";
    }

}
