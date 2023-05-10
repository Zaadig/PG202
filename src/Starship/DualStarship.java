package tec;
import java.util.Random;


public class DualStarship extends Starship{
    //capacity for emergency starship
    private int nbPlaceAEmergency; //number of seated places for the emergency vehicle
    private int nbPlaceDEmergency; //number of standing places for the emergency vehicule
    private boolean isEmergency; //is the main vehicle in an emergency state

    public DualStarship(int nbplaceA, int nbplaceD, int nbplaceAE, int nbplaceAD){
        super(nbplaceA,nbplaceD);
        nbPlaceAEmergency = nbplaceAE;
        nbPlaceDEmergency = nbplaceAD;
    }
    //check if there is an emergency with probability:odds%
    public void EmergencyCheck(int odds){
        boolean emergency = new Random().nextInt(odds)==0;
        if(emergency) DeclareEmergency();
    }
    
    //check if there is an emergency with probability:10%
    public void EmergencyCheck(){
        boolean emergency = new Random().nextInt(10)==0;
        if(emergency) DeclareEmergency();
    }

    //initiate emergency protocol
    public Transport DeclareEmergency(){
        final Starship EmergencyStarship = new Starship(nbPlaceAEmergency, nbPlaceDEmergency); //emergency vehicule, type is starship
        EmergencyStarship.numArret = super.numArret; //informs the current stop

        listIterator = passagers.listIterator();
        Passager p;
        //moving passengers to the emergency vehicle until there are no passangers left or capacity is full
        for (;listIterator.hasNext();){
            p=listIterator.next();
            if(EmergencyStarship.aPlaceAssise()){
                super.arretDemanderSortie(p);
                EmergencyStarship.monteeDemanderAssis(p);
            }
            else if(EmergencyStarship.aPlaceDebout()){
                super.arretDemanderSortie(p);
                EmergencyStarship.monteeDemanderDebout(p);
            }
        }
        super.isEmergency = true; //tells the main vehicle that it is in an emergency state to not allow any passengers on board
        return (Transport) EmergencyStarship;
    }
   
}
