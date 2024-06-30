

public class Test{
    public static void main(String[] args) {
        GraphLink<String> grafo = new GraphLink<>();
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");

        System.out.println("Grafo despues de las inserciones:");
        System.out.println(grafo);

        System.out.println("Buscar vertice A: " + grafo.searchVertex("A"));
        System.out.println("Buscar vertice D: " + grafo.searchVertex("D"));
        System.out.println("Buscar arista A-B: " + grafo.searchEdge("A", "B"));
        System.out.println("Buscar arista B-C: " + grafo.searchEdge("B", "C"));

        grafo.removeEdge("A", "B");
        System.out.println("Grafo despues de eliminar la arista A-B:");
        System.out.println(grafo);

        grafo.removeVertex("A");
        System.out.println("Grafo despues de eliminar el vertice A:");
        System.out.println(grafo);
    }
}