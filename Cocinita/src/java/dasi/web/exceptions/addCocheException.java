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
public class addCocheException extends ConcesionarioException
{
    public addCocheException() {
    }

    public addCocheException(String string) {
        super(string);
    }

    public addCocheException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public addCocheException(Throwable thrwbl) {
        super(thrwbl);
    }

    public addCocheException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
