package com.mycompany.garcia_cutillas_franciscojose_actut04.excepciones;

/**
 *
 * @author Fran
 */
public class EdadException extends Exception {

    @Override
    public String getMessage() {
        return "La edad introducida debe ser mayor o igual a 16 años.";
    }

}
