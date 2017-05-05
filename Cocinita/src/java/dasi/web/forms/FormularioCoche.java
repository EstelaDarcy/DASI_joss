/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.forms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Estela
 */
public class FormularioCoche 
{//Todo son string porque del formulario solo recogo ese tipo de variable, más tarde compruebo que los datos que deben ser numericos sean parseables
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private String anno;
    private String cilindrada;
    private String caballos;

    public FormularioCoche() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getCaballos() {
        return caballos;
    }

    public void setCaballos(String caballos) {
        this.caballos = caballos;
    }

    public FormularioCoche(String matricula, String marca, String modelo, String color, String anno, String cilindrada, String caballos) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anno = anno;
        this.cilindrada = cilindrada;
        this.caballos = caballos;
    }
    
    public Map<String, String> correcto()
    {
        Map <String, String> errores = new HashMap();
        
        if(matricula.isEmpty())
        {
            errores.put("matricula", "Debe introducir la matricula del vehiculo");
        }
        if(marca.isEmpty())
        {
            errores.put("marca", "Debe introducir la marca del vehiculo");
        }
        if(modelo.isEmpty())
        {
            errores.put("modelo", "Debe introducir el modelo del vehiculo");
        }
        if(color.isEmpty())
        {
            errores.put("color", "Debe introducir el color del vehiculo");
        }
        if(anno.isEmpty())
        {
            errores.put("anno", "Debe introducir el año del vehiculo");
        }
        if(cilindrada.isEmpty())
        {
            errores.put("cilindrada", "Debe introducir la cilindrada del vehiculo");
        }
        if(caballos.isEmpty())
        {
            errores.put("caballos", "Debe introducir los caballos del vehiculo");
        }else{
            try{
                Integer.parseInt(anno);
            }catch(Exception ex)
            {
                errores.put("anno", "El año debe ser numerico (0-9)");
            }
            try{
                Integer.parseInt(anno);
            }catch(Exception ex)
            {
                errores.put("cilindrada", "La cilindrada debe ser numerica (0-9)");
            }
            try{
                Integer.parseInt(anno);
            }catch(Exception ex)
            {
                errores.put("caballos", "Los caballos del vahiculo deben ser numericos (0-9)");
            }
        }        
        return errores;
    }
}
