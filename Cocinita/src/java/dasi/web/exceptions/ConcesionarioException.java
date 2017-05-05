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
public class ConcesionarioException extends Exception
{
    public ConcesionarioException() {
    }

    public ConcesionarioException(String string) {
        super(string);
    }

    public ConcesionarioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ConcesionarioException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ConcesionarioException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
