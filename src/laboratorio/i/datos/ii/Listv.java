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
public class Listv {
    int x,y;
    Listv next;
    String info;

    public Listv(int x, int y) {
        this.x = x;
        this.y = y;
        this.info = info;
        next=null;
    }

    void add(Listv temp) {
        Listv aux=this;
        while(aux.next!=null){
            aux=aux.next;
        }
        aux.next=temp;
    }
    public Listv s(String info){
        Listv temp=this;
        
        while(temp.info.equals(info)){
            temp=temp.next;  
        }
        return temp;
    }
}
