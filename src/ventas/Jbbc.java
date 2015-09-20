
package ventas;

import java.sql.*;
import javax.swing.JOptionPane;
import java.lang.*;
import java.util.Date;

public class Jbbc {

       public static Connection Conexion;
       public static Statement Estatuto, Estatuto1;
       public static ResultSet Resultado;
      
       public static void Registrar_Articulo(int pIdArticulo,String pDescripcion,int pCantidad,double pPrecio,String pMarca,String pModelo, String pColor, String pFecha){
       
              Conectar();
              try{
              
                  Resultado = Estatuto.executeQuery("Select IdArticulo from Articulo where IdArticulo = "+pIdArticulo+"");
                  if(Resultado.next()){
                  
                   Estatuto.executeUpdate("update Articulo set Descripcion = '"+pDescripcion+"', Cantidad = "+pCantidad+", Precio = "+pPrecio+", Marca = '"+pMarca+"', Modelo = '"+pModelo+"', Color = '"+pColor+"', FechaDeCreacion = '"+pFecha+"' where IdArticulo = "+pIdArticulo+"");
                      
                                      }
                  else{
                  
                   Estatuto.executeUpdate("insert into Articulo(IdArticulo,Descripcion,Cantidad,Precio,Marca,Modelo,Color,FechaDeCreacion)values("+pIdArticulo+",'"+pDescripcion+"',"+pCantidad+"',"+pPrecio+",'"+pMarca+"','"+pModelo+"','"+pColor+"','"+pFecha+"')");

                      }
                  Desconectar();
                  
                 }catch(SQLException ex){
              
                    System.out.println("Error al consultar");
                    Desconectar();
              
                                     }
                                                                                                                                                                }  

       
       public static int Valor_Maximo(String IdTabla, String Nombre){
       
             Conectar();
             Integer Id;
              try{
                 
                  Resultado = Estatuto.executeQuery("Select * from "+Nombre+"");
                  
                  if(Resultado.next()){
                      
                    Resultado = Estatuto.executeQuery("Select max("+IdTabla+") as IdTabla from "+Nombre+"");
                    if(Resultado.next()){
                  
                      Id = new Integer(Resultado.getString("IdTabla").toString());
                      Desconectar();
                    
                      return Id+1;
                      
                                        }
                    else{
                  
                      Desconectar();
                      return 1;
                      
                        }
                  
                                        }
                  
                  else return 1;
                  
                 }catch(SQLException ex){
              
                   // System.out.println("Error al consultar");
                    Desconectar();
                    return 0; 
                    
              
                                     }       
       
                                                                 }
       
       public static void Registrar_Cliente(int pIdCliente,String pNombres,String pApellidos,String pCedula,String pTelefono, String pDireccion, String pCiudad){
       
              Conectar();
              try{
              
                  Resultado = Estatuto.executeQuery("Select IdCliente from cliente where IdCliente = "+pIdCliente+"");
                  if(Resultado.next()){
                  
                   Estatuto.executeUpdate("update cliente set Nombres = '"+pNombres+"', Apellidos = '"+pApellidos+"', Cedula = '"+pCedula+"', Telefono = '"+pTelefono+"', Direccion = '"+pDireccion+"', Ciudad = '"+pCiudad+"' where IdCliente = "+pIdCliente+"");
                      
                                      }
                  else{
                  
                   Estatuto.executeUpdate("insert into cliente(IdCliente,Nombres,Apellidos,Cedula,Telefono,Direccion,Ciudad)values("+pIdCliente+",'"+pNombres+"','"+pApellidos+"','"+pCedula+"','"+pTelefono+"','"+pDireccion+"','"+pCiudad+"')");

                      }
                  Desconectar();
                  
                 }catch(SQLException ex){
              
                    System.out.println("Error al consultar");
                    Desconectar();
              
                                     }
                                                                                                                                                                }
       
       public static void Conectar(){
       
                try{
              
                Class.forName("com.mysql.jdbc.Driver"); 
                Conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ventas","root","data");
                Estatuto = Conexion.createStatement();
                
                 }catch(ClassNotFoundException e){
                 
                       System.out.println("Error al cargar driver");
                     
                                                 }
              
                  catch(SQLException e){
                  
                       System.out.println("Error al conectar a la base de datos");
                                       
                                       }     
       
                                    }
       
       
       public Jbbc(){
      
              try{
              
                Class.forName("com.mysql.jdbc.Driver"); 
                Conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ventas","root","data");
                Estatuto = Conexion.createStatement();
                Estatuto1 = Conexion.createStatement();
                
                 }catch(ClassNotFoundException e){
                 
                       System.out.println("Error al cargar driver");
                     
                                                 }
              
                  catch(SQLException e){
                  
                       System.out.println("Error al conectar a la base de datos");
                                       
                                       }
           
                    }

       public static void Desconectar(){
       
              try{
              
                 Conexion.close();
                 Estatuto.close();
                  
                 }catch(SQLException e){
                 
                       System.out.println("No se pudo cerrar la conexion");
                                       
                                       } 
           
                                          }
       
       public static ResultSet Consulta(String consultar){
       
              try {
              
                  Resultado = Estatuto.executeQuery(consultar);
                  return Resultado;
              
                  }catch(SQLException e){
                  
                        return null;
                  
                                        }
       
                                                         }
       
 public static void main(String ar[]){
 /*
        Date Fecha = new Date();
        Integer Dia = Fecha.getDay();
        Integer Mes = Fecha.getMonth();
        Integer ano = Fecha.getYear();
        String Fecha1 = Dia.toString()+"-"+Mes.toString()+"-"+ano.toString();
        Fecha = new Date(); 
     //   Fecha = (Date)Fecha1;*/
                

        
       //System.out.println(Valor_Maximo("IdCliente", "Cliente"));   
       Registrar_Articulo(1,"p",100,10000,"d","n", "azul","2015-12-30");
 
 }

}
