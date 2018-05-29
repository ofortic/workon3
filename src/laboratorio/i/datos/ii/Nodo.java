/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.i.datos.ii;

import java.util.Date;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author cdcasalins
 * @author ofortich
 */
public class Nodo extends DefaultMutableTreeNode {
    
    Boolean paquete;//si es un paquete va a ser verdadero
    private String nombre;
    int altura;
    private String data;
    private Nodo rLink;
    private Nodo lLink;
    Nodo dependencia;
    Date fecha;
    //dibujar
    int x,y;
    public String getNombre() {
        return nombre;
    }

    public Nodo getrLink() {
        return rLink;
    }

    public Nodo getlLink() {
        return lLink;
    }
    
    public String getData() {
        return data;
    }

    public Nodo(String nombre, Boolean paquete) {
        this.nombre = nombre;
        this.paquete=paquete;
        this.data=data;
        
    }
    
    String getNombre(Nodo nodo){
        return this.nombre;
    }
    
    /**
     * Metodo agregar entregables y paquetes 
     * @param nombre
     * @param paquete 
     */
    void add(String nombre, Boolean paquete){
        if (paquete) {
            this.ultPaquete().lLink=new Nodo(nombre, true);
        }else{
            this.ultEntregable().rLink=new Nodo(nombre, false);
        }
    }
    void add(Nodo nodo ){
        if (nodo.paquete) {
            this.ultPaquete().lLink=new Nodo(nodo.nombre, true);
        }else{
            this.ultEntregable().rLink=new Nodo(nodo.nombre, false, nodo.fecha);
        }
    }
    //Nuevo constructor con fechas
    public Nodo(String nombre, Boolean paquete, Date fecha) {
        this.nombre = nombre;
        this.paquete=paquete;
        this.data=data;
        this.fecha=fecha;
        if (!paquete) {
            //agregar archivo
        }
    }
    /**
     * Metodo para hayar el ultimo paquete del arbol
     * @return 
     */
    Nodo ultPaquete() {
        Nodo p = this;
        while (p.lLink != null) {
            p = p.lLink;
        }
        return p;
    }

    /**
     * revisa si ya existe un nodo
     * @param nombre
     * @param p
     * @return 
     */
    boolean existe(String nombre, Nodo p){
        if (p==null) {
            return false;
        }else{
            if (p.nombre.equals(nombre)) {
                return true;
            }else{
               return existe(nombre, p.lLink)||existe(nombre, p.rLink);
            }
        }
    }
    
    /**
     * busca un nodo
     * @param nombre
     * @param p
     * @return 
     */
    Nodo buscarPaquete(String nombre, Nodo p) {
        if (p != null) {
            if (p.nombre.equals(nombre)) {
                return p;
            } else {
                return buscarPaquete(nombre, p.lLink);
            }
        }else{
            return p;
        }
    }
    
    /**
     * Busca los nodos hoja
     * @param ptr
     * @return 
     */
    String hojas(Nodo ptr){
        String nodos="";
        Nodo p=ptr.lLink;
        int c=0;
        while(p.lLink != null){
            nodos=nodos+p.ultEntregable().nombre;
            p=p.lLink;
            c++;
        }
        
        return nodos;
    }
    
    /**
     * Nodos hoja
     * @param p
     * @return 
     */
    String nodosHoja(Nodo p){
        if (p==null) {
            return "";
        }else{
            if ((p.lLink == null) && (p.rLink == null)) {
                return p.nombre + " ";
            }else{
                return nodosHoja(p.rLink) +nodosHoja(p.lLink);
            }
        }
    }
    
    /**
     * paquetes con un solo entregable
     * @param ptr
     * @return 
     */
    String unSoloEntregable(Nodo ptr){
        String nodos="";
        Nodo p=ptr;
        int c=0;
        while(p.lLink != null){
            p=p.lLink;
            c++;
        }
        p=ptr.lLink;
        for (int i = 0; i < c; i++) {
            if (p.rLink==null) {
                return "";
            }else{
                if (p.rLink.rLink==null) {
                    nodos =nodos + p.nombre + ", ";
                    p=p.lLink;
                }
            }
        }
        return nodos;
    }
    
    /**
     * busca un entregable
     * @param nombre
     * @param p
     * @return 
     */
    Nodo buscarEntregable(String nombre, Nodo p){
        if (p != null) {
            if (p.nombre.equals(nombre)) {
                return p;
            } else {
                return buscarEntregable(nombre, p.rLink);
            }
        }else{
            return p;
        }
    }
    
    /**
     * saca la altura del arbol
     * @param p
     * @return 
     */
    int altura(Nodo p){
        int a=0;
        Nodo h=null;
        int c=0;
        int c2=0;
        if (p==null) {
            return 0;
        }else{
            if (p.lLink==null&&p.rLink==null) {
                return 1;
            }else{
                while(p.lLink!=null){
                    h=p;
                    c++;
                    p=p.lLink;
                    while(h.rLink!=null){
                        h=h.rLink;
                        c2++;
                    }
                    if (a<c2+c) {
                            a=c2+c;
                    }
                    c2=0;
                }
            }
        }
        return  a-1;   
        
    }
    
    /**
     * haya el ultimo entregable de un paquete
     * @return 
     */
    public Nodo ultEntregable(){
        Nodo p=this;
        while(p.rLink != null){
            p=p.rLink;
        }
        return p;
    }
}
