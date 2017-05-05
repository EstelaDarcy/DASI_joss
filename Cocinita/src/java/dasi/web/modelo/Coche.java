/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.modelo;

/**
 *
 * @author Estela
 */
public class Coche 
{
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private String anno;
    private String cilindrada;
    private String caballos;
    private boolean vendido;

    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo, String color, String anno, String cilindrada, String caballos, boolean vendido) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anno = anno;
        this.cilindrada = cilindrada;
        this.caballos = caballos;
        this.vendido = vendido;
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

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }    
}
