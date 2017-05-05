/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.modelo;

import dasi.web.exceptions.ConcesionarioException;
import javax.sql.DataSource;

/**
 *
 * @author Estela
 */
public interface Dao 
{
    public void init(DataSource dataSource);
    public void addCoche(String matricula, String marca, String modelo, String color, int anno, int cilindrada, int caballos) throws ConcesionarioException;
    public Coche mostrarFormulario(String matricula) throws ConcesionarioException;
    public void modificarCoche(String matricula, String marca, String modelo, String color, int anno, int cilindrada, int caballos) throws ConcesionarioException; 
}
