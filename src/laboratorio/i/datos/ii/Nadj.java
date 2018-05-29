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
public class Nadj {
    Nadj next;
    String data;

    public Nadj(String data) {
        this.next = null;
        this.data = data;
    }

    void add(String vd) {
        Nadj temp=this;
        while(temp.next!=null){
            temp=temp.next;
        } 
       temp.next= new Nadj(vd);
    }
}
