
public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<>();
    }

    public void insertVertex(E data) {
        Vertex<E> vertex = new Vertex<>(data);
        listVertex.insertLast(vertex);
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = findVertex(verOri);
        Vertex<E> vertexDes = findVertex(verDes);

        if (vertexOri != null && vertexDes != null) {
            Edge<E> edge = new Edge<>(vertexDes);
            vertexOri.listAdj.insertLast(edge);
            Edge<E> edgeReverse = new Edge<>(vertexOri);
            vertexDes.listAdj.insertLast(edgeReverse);
        } else {
            throw new IllegalArgumentException("Uno o ambos vertices no encontrados");
        }
    }

    private Vertex<E> findVertex(E data) {
        Nodo<Vertex<E>> current = listVertex.getHead();
        while (current != null) {
            if (current.getData().getData().equals(data)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        return listVertex.toString();
    }
}
