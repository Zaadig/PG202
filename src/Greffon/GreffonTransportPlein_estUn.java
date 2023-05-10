package tec;
public class GreffonTransportPlein_estUn extends GreffonestUn {

    public GreffonTransportPlein_estUn(int nbPlaceA,int nbPlaceD,Collection c)
    {
        super(nbPlaceA, nbPlaceD,c);
    }

    @Override
    public void monteeDemanderAssis(Passager p){
        
        if (aPlaceAssise()){
            super.monteeDemanderAssis(p);
        }
    }

    @Override
    public void arretDemanderAssis(Passager p){
        
        if (aPlaceAssise()){
            super.arretDemanderAssis(p);
        }
    }


    @Override
    public void monteeDemanderDebout(Passager p){
        if (aPlaceDebout()){
            super.monteeDemanderDebout(p);
        }
    }

   
    @Override
    public void arretDemanderDebout(Passager p){
        if (aPlaceDebout()){
            super.arretDemanderDebout( p);
        }
    }

    
    
}
