package co.edu.unbosque.model;

public class Node {

    private Node izq;
    private Node der;
    private int data;

    /**
     * Constructor
     */
    public Node(){
        this.izq = null;
        this.der = null;
        this.data = -1;
    }

    /**
     * Constructor with data as parameter
     * @param data
     */
    public Node(int data){
        this.izq = null;
        this.der = null;
        this.data = data;
    }

    public Node getIzq() {
        return izq;
    }

    public void setIzq(Node izq) {
        this.izq = izq;
    }

    public Node getDer() {
        return der;
    }

    public void setDer(Node der) {
        this.der = der;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
