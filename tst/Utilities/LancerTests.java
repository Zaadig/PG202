/**Author: Elkarchi Jad */
package tec;

import java.lang.reflect.*;

class LancerTests {
    
    static private void lancer(Class<?> c){
        Method Methods[];
        Object newClass;
        int validTests = 0;
        int allTests = 0;
            try{
                // Class newClass = c.newInstance();  Is not working because it's deprecated in Java 9+, 
                // we used getDeclaredConstructor to get the constructor first, then create a new instance of it's class 
                // to be returned as an Object
                // We do not recommand using the keyword Class<?> in this example,
                // we could add an interface called Tests and use it instead to be more specific.
                newClass = c.getDeclaredConstructor().newInstance();
                // the getClass method gets the class from the returned Object.
                Methods = newClass.getClass().getMethods();

            for( int i = 0; i < Methods.length; i++){
                try{
                    // I verify if the method is actually a test method by checking if it contains word 'test'
                    if (Methods[i].getName().contains("test")){
                        allTests++; // counting total number of test methods
                        Object ret = Methods[i].invoke(newClass);
                        System.out.print(".");
                        validTests++; // counting total number of validated test methods
                    }
                } catch(SecurityException 
                       | InvocationTargetException // exception for assert errors coming from test methods
                       | IllegalArgumentException e){
                        System.out.println("\n\n error method : " + Methods[i] + "\n" + e);
                }
            }
            
            System.out.print(":OK(" + validTests + "/" + allTests + "):");
            System.out.print(newClass.getClass().getName()+"\n");
            
            } catch(SecurityException
                   | NoSuchMethodException 
                   | InstantiationException 
                   | IllegalAccessException
                   | InvocationTargetException e){
                System.out.println("\n\n error class: " + c.getName() + "\n" + e);
            }
    }

    static public void main(String[] args){
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        Class<?> classTest;
        String className;
        for (int i = 0; i < args.length; i++ ){
            try{
                className = "tec.Test" + args[i]; // concatenating name with package and constant "Test"
                classTest = Class.forName(className); // loading test class from package tec
                lancer(classTest); // running test class
            } catch (ClassNotFoundException e){
                System.out.println("\n\nerror :" + e);
            }
        }
    }
}

