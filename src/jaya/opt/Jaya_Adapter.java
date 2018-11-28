/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaya.opt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public final class Jaya_Adapter {
   public static int Population_Size;
   public static int NDV;
   public static boolean TER_COD;
   public static double best;
   public static double worst;
   public static double current_result=0;
   public static double solution;
   static Random r = new Random();
   static double result;
   static Map<Integer, String> temp_array1 = new HashMap<>();
   static Map<Integer, String> temp_array2 = new HashMap<>();
   static ArrayList<Float> max = new ArrayList<>();
   static Map<Float, Integer> map_maximum = new HashMap<>();
   static Map<ArrayList<Float>, Integer> max_map = new HashMap<>();
   static ArrayList<Float> fl_value = new ArrayList<>();
   static List<Map<Integer, String>> opcode_array_hash1 = new ArrayList<>();
   static List<Map<Integer, String>> opcode_array_hash2 = new ArrayList<>();

   public Jaya_Adapter(){
       //!!!!! DEFİNE ACCORDİNG DESİGN VERİABLES (opcode_array_hash1/opcode_array_hash2) TO YOUR PROJECT NEEDS FOR PROGRAM TO WORK
       
        for(int i=0;i<opcode_array_hash1.size();i++){  
                temp_array1 = opcode_array_hash1.get(i);
                temp_array2 = opcode_array_hash2.get(i);
               // System.out.println(temp_array_cmp(temp_array1, temp_array2));
                collect_value(temp_array_cmp(temp_array1, temp_array2));
                
        } 
        
       
        
  
    }
    public static void collect_value(ArrayList<Float> temp){  //collect values to send jaya  
       float temp_value=0;
        for(int i=0;i<temp.size();i++){
         temp_value += temp.get(i);
        }
        temp_value = temp_value/(temp.size());
        fl_value.add(temp_value);
      }
    
    
    
    
    public static ArrayList<Float> temp_array_cmp(Map<Integer, String> temp_array1, Map<Integer, String> temp_array2){
           ArrayList<Float> max_map = new ArrayList<>();

                max.clear();
                ArrayList<Float> maxvalue = new ArrayList<>();
                LCS lcs = new LCS();
                for(int i=0;i<temp_array1.size();i++){
                    for(int j=0;j<temp_array2.size();j++){
                           maxvalue.add(lcs.LCS(temp_array1.get(i), temp_array2.get(j)));
                    
                    } 
                    max.add(Collections.max(maxvalue));
                    maxvalue.clear();
                    
                }
                return max;                    
    }

}

