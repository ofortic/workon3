/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.i.datos.ii;

/**
 *
 * @author orlando
 */
public class Node {
    Node nextn;
    int data;
    Nadj adj;
    static int acum=0; 
    public Node() {
        data=acum;
        acum=acum+1;
        nextn = null;
        adj=null;
    }
}
