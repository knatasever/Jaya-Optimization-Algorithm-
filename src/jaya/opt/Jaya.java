/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaya.opt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KÜBRA NUR
 */
public class Jaya {
    public static int Population_size=10;
    public static int Solution_size=10;
    public static float X_solution;
    public static float Best;
    public static float Worst;
    static ArrayList<Float> fl_value = new ArrayList<>();
    public static Random r = new Random();

    public Jaya(){
    fl_value=Jaya_Adapter.fl_value;
    X_solution = fl_value.get(r.nextInt(fl_value.size()));
    
    for(int i=0;i<Population_size;i++){
             updateSolution(random_chs(fl_value)); 
            
    }
        System.out.println("sonuç:"+X_solution);
    
    }
    public ArrayList<Float> random_chs(ArrayList<Float> fl_value){
        ArrayList<Float> chsd = new ArrayList<>();
       int value;
        for(int i=0;i<Solution_size;i++){
            value=r.nextInt(fl_value.size());
            System.out.print(value+",");
            chsd.add(fl_value.get(value));
        
        }
        System.out.println("CHSD: "+chsd);
    return chsd;
    }
    public static void updateSolution(ArrayList<Float> chsd){
        Random rand = new Random();
        float rand1 = (float)Math.random();
        rand1=(float) (rand1*0.1);
        float rand2= (float)Math.random();
        rand2=(float) (rand2*0.1);
        float X_current;
        Best=Collections.max(chsd);
        Worst=Collections.min(chsd);

        X_current= X_solution+(rand1*(Best-Math.abs(X_solution)))-(rand2*(Worst-Math.abs(X_solution)));
       
        System.out.println(X_current);
        
        if(X_current>X_solution){
            X_solution=X_current;
        
        }
    }
}
