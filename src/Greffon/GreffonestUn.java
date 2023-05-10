package tec;


public class GreffonestUn extends Autobus {

    private Collection collect;
    public GreffonestUn(int nbPlaceA,int nbPlaceD,Collection c)
    {
        super(nbPlaceA, nbPlaceD);
        collect=c;
    }
    @Override
    public void allerArretSuivant(){
        collect.changerArret();
        super.allerArretSuivant();
        
    }
    @Override
    public void arretDemanderSortie(Passager p) {
        super.arretDemanderSortie( p);
        collect.uneSortie();
    }

    @Override
    public void monteeDemanderAssis(Passager p){
        super.monteeDemanderAssis( p);
        collect.uneEntree();
    }
    @Override
    public void monteeDemanderDebout(Passager p){
        super.monteeDemanderDebout( p);
        collect.uneEntree();
    }

    
    // for test


    // to get all data collected
    public void GreffonestUn_collect_data(){
        collect.get_data();
    }

    // to get data of arret num_arret when collection memory is used
    public Triple GreffonestUn_collect_data(int num_arret){
        return collect.get_data(num_arret);
    }

    // to get data of arret num_arret when collection file is used
    public void GreffonestUn_collect_data_line(int num_arret){
        collect.get_data_line(num_arret);
    }
    
    
    
}
