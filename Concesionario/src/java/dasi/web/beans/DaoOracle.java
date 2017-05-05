/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.beans;

import dasi.web.exceptions.ConcesionarioException;
import dasi.web.exceptions.addCocheException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            throw new addCocheException();
        }
    }
}
