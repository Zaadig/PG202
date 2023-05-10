
package tec;

public interface InterfaceGreffonAUn extends Vehicule, Transport{


    // to get all data collected

    public void greffonAUn_collect_data();

    // to get data of arret num_arret when collection memory is used
    public Triple greffonAUn_collect_data(int num_arret);
    
    // to get data of arret num_arret when collection file is used
    public void greffonAUn_collect_data_line(int num_arret);

}
