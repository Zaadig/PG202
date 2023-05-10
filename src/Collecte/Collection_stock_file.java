package tec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Collection_stock_file implements Collection {

  private Triple data;
  private int num_arret = 0;
  private String file_name;


  public Collection_stock_file(String file_name){

    this.file_name=file_name;

    try {
      File file = new File(file_name); // create a file
      if (file.createNewFile()) {
        data = new Triple(0); // arret 0 data
      } 
    }
      catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
  
  
  
  
  public void uneEntree(){

    data.increment_NUM_ENTREE(); 

  }

  
  
  
  public void uneSortie(){

    data.increment_NUM_SORTIE(); 

  }

  
  
  
  public void changerArret(){

    try{
      FileWriter Writer = new FileWriter(file_name,true); // a writer on the file
      Writer.write(data.toString()); // write the current data collected on file
      Writer.close();
    }
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    data = new Triple(++num_arret); //curent arret data
      
  }

  
  // display all data collected in the collection file 
  
  
  
  
  public void get_data(){

    File file = new File(file_name);
    
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {

      String line;
      while ((line = buffer.readLine()) != null) {
        System.out.println(line);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }    
  }


    
    // display data of arret i.
    
    
    
    
    public Triple get_data(int num_arret){
      return new Triple(0);
    }

    
    
    
    
    public void get_data_line(int num_arret){
      
    	String line=null;
    
      try {
        //read data file
      	FileReader file = new FileReader(file_name);
      	BufferedReader buffer = new BufferedReader(file);
    
      // getting the right line to read
      for (int j = 1; j < num_arret+1; j++) {
        buffer.readLine();
      }
      line = buffer.readLine(); // got it

    } catch (IOException e) {
      e.printStackTrace();
    }
    
    System.out.println(line); //read data arret i
  }

}
