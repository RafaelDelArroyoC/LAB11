
public class Vertex<E> {
    private E data;  // dato del vertice 
    protected ListLinked<Edge<E>> listAdj; // lista de adyacencia es decir las aristas

    public Vertex(E data){
        this.data = data;
        listAdj = new ListLinked<Edge<E>>();
    }

    public E getData(){
        return data;
    }

    public boolean equals(Object o){
        if(o instanceof Vertex<?>){
            Vertex<E> v = (Vertex<E>)o;
            return this.data.equals(v.data);
        }
        return false;
    }

    public String toString(){
        return this.data + " --> " + this.listAdj.toString()+"\n";
    }    
}
