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
public class AddCocheException extends ConcesionarioException
{
    public AddCocheException() {
    }

    public AddCocheException(String string) {
        super(string);
    }

    public AddCocheException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public AddCocheException(Throwable thrwbl) {
        super(thrwbl);
    }

    public AddCocheException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
