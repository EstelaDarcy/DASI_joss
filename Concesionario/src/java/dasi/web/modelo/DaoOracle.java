/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.modelo;

import dasi.web.exceptions.ConcesionarioException;
import dasi.web.exceptions.AddCocheException;
import dasi.web.exceptions.ModificarCocheException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Estela
 */
public class DaoOracle implements Dao
{
    private DataSource dataSource;
    
    @Override
    public void init(DataSource dataSource) 
    {
        this.dataSource = dataSource;
    }

    @Override
    public void addCoche(String matricula, String marca, String modelo, String color, int anno, int cilindrada, int caballos) throws ConcesionarioException
    {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement psAdd = connection.prepareStatement("INSERT INTO  coches (matricula, marca, modelo, color, anno, cilindrada, caballos, vendido) "
                                                                            + "  VALUES(        ?,     ?,      ?,     ?,    ?,          ?,        ?, 'false')" )
        )
        {
            psAdd.setString(1, matricula);
            psAdd.setString(2, marca);
            psAdd.setString(3, modelo);
            psAdd.setString(4, color);
            psAdd.setInt(5, anno);
            psAdd.setInt(6, cilindrada);
            psAdd.setInt(7, caballos);

            psAdd.executeUpdate();
        } catch (SQLException ex) {
            throw new AddCocheException();
        }
    }

    @Override
    public void modificarCoche(String matricula, String marca, String modelo, String color, int anno, int cilindrada, int caballos) throws ConcesionarioException 
    {
        try(Connection connection = dataSource.getConnection();            
            PreparedStatement psUpdate = connection.prepareStatement("UPDATE coches"
                                                                  + "    SET marca=?, modelo=?, color=?, anno=?, cilindrada=?, caballos=?"
                                                                  + "  WHERE matricula=?")
        )
        {    
            psUpdate.setString(1, marca);
            psUpdate.setString(2, modelo);
            psUpdate.setString(3, color);                    
            psUpdate.setInt(4, anno);
            psUpdate.setInt(5, cilindrada);
            psUpdate.setInt(6, caballos);
            psUpdate.setString(7, matricula);

            psUpdate.executeUpdate();               
        } catch (SQLException ex) {
            throw new ModificarCocheException();
        }
        
        
    }

    @Override
    public Coche mostrarFormulario(String matricula) throws ConcesionarioException 
    {
        Coche coche = new Coche();
        
        try(Connection connection = dataSource.getConnection();
            PreparedStatement psSelect = connection.prepareStatement("SELECT marca, modelo, color, anno, cilindrada, caballos "
                                                                  + "   FROM coches"
                                                                  + "  WHERE matricula=?");
        )
        {
            psSelect.setString(1, matricula);
            try(ResultSet rsSelect = psSelect.executeQuery())
            {
                if(rsSelect.next())
                {
                    coche.setMatricula(matricula);
                    coche.setMarca(rsSelect.getString(1));
                    coche.setModelo(rsSelect.getString(2));
                    coche.setColor(rsSelect.getString(3));
                    coche.setAnno(rsSelect.getInt(4));
                    coche.setCilindrada(rsSelect.getInt(5));
                    coche.setCaballos(rsSelect.getInt(6));
                }                            
            } 
        }catch (SQLException ex) {
            Logger.getLogger(DaoOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return coche;
    }
}
