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
public class ModificarCocheException extends ConcesionarioException
{
    public ModificarCocheException() {
    }

    public ModificarCocheException(String string) {
        super(string);
    }

    public ModificarCocheException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ModificarCocheException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ModificarCocheException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
