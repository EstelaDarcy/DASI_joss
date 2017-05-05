/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.exceptions;

/**
 *
 * @author Estela
 */
public class MostrarCocheException extends ConcesionarioException
{
    public MostrarCocheException() {
    }

    public MostrarCocheException(String string) {
        super(string);
    }

    public MostrarCocheException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public MostrarCocheException(Throwable thrwbl) {
        super(thrwbl);
    }

    public MostrarCocheException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }    
}
