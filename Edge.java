
public class Edge <E>{
    private Vertex<E> refDest; // referencia al vertice destino
    private int weight; // peso de la arista

    public Edge(Vertex<E> refDest){
        this(refDest, -1); // peso por defecto -1
    }

    public Edge(Vertex<E> refDest, int weight){
        this.refDest = refDest;
        this.weight = weight;
    }

    public boolean equals(Object o){
        if(o instanceof Edge<?>){
            Edge<E> e = (Edge<E>) o;
            return this.refDest.equals(e.refDest);
        } return false;
    }

    public String toString(){
        if(this.weight > -1){
            return this.refDest.getData() + " [" + this.weight + "]";
        } else {
            return this.refDest.getData() + ", ";
        }
        
    }

}
