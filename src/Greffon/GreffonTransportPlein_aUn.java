package tec;

public class GreffonTransportPlein_aUn extends GreffonAUn{
 
    public GreffonTransportPlein_aUn(Transport ConcreteVehicle, Collection ConcreteCollection){
        super(ConcreteVehicle, ConcreteCollection);
    }
    @Override
    public void monteeDemanderAssis(Passager p){
        
        if (super.aPlaceAssise()){
            super.monteeDemanderAssis(p);
        }
    }

    @Override
    public void arretDemanderAssis(Passager p){
        
        if (super.aPlaceAssise()){
            super.arretDemanderAssis(p);
        }
    }


    @Override
    public void monteeDemanderDebout(Passager p){
        if (super.aPlaceDebout()){
            super.monteeDemanderDebout(p);
        }
    }

   
    @Override
    public void arretDemanderDebout(Passager p){
        if (super.aPlaceDebout()){
            super.arretDemanderDebout(p);
        }
    }

}
