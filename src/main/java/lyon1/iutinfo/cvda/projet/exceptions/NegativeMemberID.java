/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyon1.iutinfo.cvda.projet.exceptions;

/**
 *
 * @author Bastien BOMBARDELLA
 */
public class NegativeMemberID extends Exception {
    public NegativeMemberID() {
        super("L'id du membre ne peut pas être négatif ou nul.");
    }
}
