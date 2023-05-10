package tec;
import java.util.ArrayList;

public class Collection_stock_memoire implements Collection{

    private ArrayList<Triple> DATA = new ArrayList<Triple>();
    private int num_arret=0;

    public Collection_stock_memoire(){
        DATA.add(new Triple(0)); // add the data of arret 0 in the DATA array to be collected 
    }


    public void uneEntree(){
        DATA.get(num_arret).increment_NUM_ENTREE();        

    }

    public void uneSortie(){
        DATA.get(num_arret).increment_NUM_SORTIE(); 
    }
    

    public void changerArret(){

        DATA.add(new Triple(++num_arret)); //add the data of current arret in the DATA array to be collected 
    }
    
    public void get_data(){

        for (int j=0;j<DATA.size()-1;j++){
            System.out.println(DATA.get(j).toString());
        }
    }


    public Triple get_data(int num_arret){
        return DATA.get(num_arret);
    }


    public void get_data_line(int num_arret){
        
    }
    
}
