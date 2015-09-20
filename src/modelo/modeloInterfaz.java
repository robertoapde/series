/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rob
 */
public class modeloInterfaz extends Database{
    
    public modeloInterfaz(){};
    
    public DefaultTableModel getTablaSeries()
    {
        DefaultTableModel tableSmodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Nombre","Temporada","Capitulo"};
        try
        {
         PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM series");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
           
        }
        Object[][] data = new String[registros][4];
       try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM series");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "nombre" );
                data[i][1] = res.getString( "temporada" );
                data[i][2] = res.getString( "capitulo" );
            i++;
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tableSmodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tableSmodel;
    }
    
    public DefaultTableModel getTablaPeliculas()
    {
        DefaultTableModel tablePmodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"Nombre","Genero","Duracion"};
        try
        {
         PreparedStatement pstm = this.getConexion().prepareStatement( "SELECT count(*) as total FROM peliculas");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
           
        }
        Object[][] data = new String[registros][4];
       try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = this.getConexion().prepareStatement("SELECT * FROM peliculas");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "nombre" );
                data[i][1] = res.getString( "genero" );
                data[i][2] = res.getString( "duracion" );
            i++;
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablePmodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablePmodel;
    }
    
    public boolean NuevaSerie(String nombre, String temporada, String capitulo,String usuario)
    {
        if(valida_datosSeries(nombre, temporada, capitulo, usuario))
        {
            String q =" INSERT INTO series (nombre , temporada, capitulo, usuario)"
                    + "VALUES ('"+ nombre +"','"+ temporada +"','"+ capitulo +"','"+ usuario +")";
        try {
                PreparedStatement pstm = this.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else
         return false;
    }
    
    public boolean Nuevapelicula(String nombre, String genero, String duracion,String usuario)
    {
        if(valida_datosSeries(nombre, genero, duracion, usuario))
        {
            String q =" INSERT INTO peliculas (nombre , genero, duracion, usuario)"
                    + "VALUES ('"+ nombre +"','"+ genero +"','"+ duracion +"','"+ usuario +")";
        try {
                PreparedStatement pstm = this.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else
         return false;
    }
    
    public boolean EliminarSerie( String nombre )
    {
         boolean res=false;
        //se arma la consulta
        String q = " DELETE FROM series WHERE  nombre='" + nombre + "' " ;
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return res;
    }  
    
    public boolean EliminarPeliculas( String nombre )
    {
         boolean res=false;
        //se arma la consulta
        String q = " DELETE FROM peliculas WHERE  nombre='" + nombre + "' " ;
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return res;
    } 
    
   private boolean valida_datosSeries(String nombre , String temporada, String capitulo, String usuario)
    {
        if( nombre.equals("  ") )
            return false;
        else if( nombre.length() > 0 && temporada.length()>0 && capitulo.length() >0 && usuario.length()>0)
        {
            return true;
        }
        else  return false;
    }
   
   private boolean valida_datosPeliculas(String nombre , String genero, String duracion,String usuario)
    {
        if( nombre.equals(" ") )
            return false;
        else if( nombre.length() > 0 && genero.length()>0 && duracion.length() >0 && usuario.length()>0)
        {
            return true;
        }
        else  return false;
    }
}
    

