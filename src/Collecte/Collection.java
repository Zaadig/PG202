package tec;
interface Collection {

    public void uneEntree();
    public void uneSortie();
    public void changerArret();

        

    // display all data collected

    public void get_data();

    // to get data arret num_arret when collection memory is used

    public Triple get_data(int num_arret);

    // to get data arret num_arret when collection file is used

    public void get_data_line(int num_arret);

}