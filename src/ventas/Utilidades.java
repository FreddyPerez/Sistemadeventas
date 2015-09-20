/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas;

/**
 *
 * @author Freddy
 */
public class Utilidades {
    
       public static String EliminarEspacioBlanco(String cadena){
       
              String CadenaSinEspacios = "";
              int NumEspInicial = 0;
              int NumEspFinal = 0;
              int IncrementoInicial = 0;
              int IncrementoFinal = cadena.length()-1;
              
              if(cadena.length()>0){
              
              while(cadena.charAt(IncrementoInicial) == ' '){
              
                   NumEspInicial++;
                   IncrementoInicial++;
                   if(cadena.length() == NumEspInicial)break;
                   
              
                                                            } 
              while(cadena.charAt(IncrementoFinal) == ' ') {
              
                    IncrementoFinal--;
                    NumEspFinal++;
                    if(IncrementoFinal == -1)break;
              
                                                            }
              
              }
              
              for(int a = NumEspInicial;a < cadena.length()-NumEspFinal;a++)CadenaSinEspacios = CadenaSinEspacios+(cadena.charAt(a));
              return CadenaSinEspacios;
                                                                
                                                                }
    
    
    
}
