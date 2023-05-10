package tec;
public class Triple {

    private int NUM_SORTIE=0;
    private int NUM_ENTREE=0;
    private int NUM_ARRET;

    public Triple(int arret){
       NUM_ARRET=arret;
    }

    public void increment_NUM_SORTIE(){
        NUM_SORTIE++;
    }

    public void increment_NUM_ENTREE(){
        NUM_ENTREE++;
    }

    public int get_NUM_ENTREE(){
        return NUM_ENTREE;
    }

    public int get_NUM_SORTIE(){
        return NUM_SORTIE;
    }

    @Override
    public String toString() {
        return "[ ARRET num : " + NUM_ARRET + " ] =>  " + "Numero des ENTREES : " + NUM_ENTREE + " && Numero des SORTIES : " + NUM_SORTIE+"\n";
    }
}