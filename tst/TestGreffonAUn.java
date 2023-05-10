package tec;
class TestGreffonAUn{


    public void  testGreffonAUn(){

    GreffonAUn greffon = new GreffonAUn((Transport) new Autobus(1,2), new Collection_stock_memoire());
    MonteeRepos inara = new MonteeRepos("inara_Standard", 4, new ArretCalme());
    MonteeRepos kaylee = new MonteeRepos("Kaylee_Standard", 4, new ArretCalme());
    MonteeRepos sylvin = new MonteeRepos("sylvin_Standard", 5, new ArretCalme());
    MonteeRepos inara2 = new MonteeRepos("inara2_Standard", 5, new ArretCalme());



    //0

    greffon.allerArretSuivant();


    assert greffon.greffonAUn_collect_data(0).get_NUM_ENTREE()==0;
    assert greffon.greffonAUn_collect_data(0).get_NUM_SORTIE()==0;

    //1

    try {

        kaylee.monterDans(greffon);
        sylvin.monterDans(greffon);
        inara.monterDans(greffon);
        
    }catch (Exception e){
        System.out.println (e.getMessage());
    }
    
    greffon.allerArretSuivant();

    assert greffon.greffonAUn_collect_data(1).get_NUM_ENTREE()==3;
    assert greffon.greffonAUn_collect_data(1).get_NUM_SORTIE()==0;

    //2

    greffon.allerArretSuivant();

    assert greffon.greffonAUn_collect_data(2).get_NUM_ENTREE()==0;
    assert greffon.greffonAUn_collect_data(2).get_NUM_SORTIE()==0;

    //3
  
    greffon.allerArretSuivant();

    assert greffon.greffonAUn_collect_data(3).get_NUM_ENTREE()==0;
    assert greffon.greffonAUn_collect_data(3).get_NUM_SORTIE()==0;

    //4

    try {

      inara2.monterDans(greffon);
      
    }catch (Exception e){
      System.out.println (e.getMessage());
    }

    greffon.allerArretSuivant();
    
    assert greffon.greffonAUn_collect_data(4).get_NUM_ENTREE()==1;
    assert greffon.greffonAUn_collect_data(4).get_NUM_SORTIE()==2;


    //5
  
     greffon.allerArretSuivant();

    assert greffon.greffonAUn_collect_data(5).get_NUM_ENTREE()==0;
    assert greffon.greffonAUn_collect_data(5).get_NUM_SORTIE()==2;

    // greffon.greffonAUn_collect_data();
    

    }

}