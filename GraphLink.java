
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

    //4.3
    public boolean searchVertex(E data) {
        return findVertex(data) != null;
    }

    //4.3
    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = findVertex(verOri);
        Vertex<E> vertexDes = findVertex(verDes);

        if (vertexOri != null && vertexDes != null) {
            Nodo<Edge<E>> current = vertexOri.listAdj.getHead();
            while (current != null) {
                if (current.getData().equals(new Edge<>(vertexDes))) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }
    public void removeVertex(E data) {
        Vertex<E> vertexToRemove = findVertex(data);
        if (vertexToRemove != null) {
            Nodo<Vertex<E>> current = listVertex.getHead();
            while (current != null) {
                if (!current.getData().equals(vertexToRemove)) {
                    removeEdge(current.getData().getData(), data);
                }
                current = current.getNext();
            }
            listVertex.removeNode(vertexToRemove);
        } else {
            System.out.println("El vertice no existe.");
        }
    }

    public void removeEdge(E verOri, E verDes) {
        Vertex<E> vertexOri = findVertex(verOri);
        Vertex<E> vertexDes = findVertex(verDes);

        if (vertexOri != null && vertexDes != null) {
            vertexOri.listAdj.removeNode(new Edge<>(vertexDes));
            vertexDes.listAdj.removeNode(new Edge<>(vertexOri));
        } else {
            System.out.println("Una o ambas aristas no existen.");
        }
    }

    @Override
    public String toString() {
        return listVertex.toString();
    }
}
