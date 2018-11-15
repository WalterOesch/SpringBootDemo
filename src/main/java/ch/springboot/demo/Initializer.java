package ch.springboot.demo;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Walter Oesch on 15.11.2018.
 */
@Component
public class Initializer {

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        List<String> profiles = Arrays.asList(environment.getActiveProfiles());
        defaultWeightedEdge();

    }

    private void defaultWeightedEdge() {
        //@example:main:begin
        // constructs a directed graph with the specified vertices and edges
        Graph<String, DefaultWeightedEdge> directedGraph =
                new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");
        directedGraph.addVertex("e");
        directedGraph.addVertex("f");
        directedGraph.addVertex("g");
        directedGraph.addVertex("h");
        directedGraph.addVertex("i");
        directedGraph.addEdge("a", "b");
        //directedGraph.setEdgeWeight("a", "b", 4);
        directedGraph.addEdge("b", "d");
        directedGraph.addEdge("d", "c");
        directedGraph.addEdge("c", "a");
        directedGraph.addEdge("e", "d");
        directedGraph.addEdge("e", "f");
        directedGraph.addEdge("f", "g");
        directedGraph.addEdge("g", "e");
        directedGraph.addEdge("h", "e");
        directedGraph.addEdge("i", "h");

        // computes all the strongly connected components of the directed graph
        StrongConnectivityAlgorithm<String, DefaultWeightedEdge> scAlg =
                new KosarajuStrongConnectivityInspector<>(directedGraph);
        List<Graph<String, DefaultWeightedEdge>> stronglyConnectedSubgraphs =
                scAlg.getStronglyConnectedComponents();

        // prints the strongly connected components
        System.out.println("Strongly connected components:");
        for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++) {
            System.out.println(stronglyConnectedSubgraphs.get(i));
        }
        System.out.println();

        // Prints the shortest path from vertex i to vertex c. This certainly
        // exists for our particular directed graph.
        System.out.println("Shortest path from i to c:");
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg =
                new DijkstraShortestPath<>(directedGraph);
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> iPaths = dijkstraAlg.getPaths("i");
        System.out.println(iPaths.getPath("c") + "\n");

        // Prints the shortest path from vertex c to vertex i. This path does
        // NOT exist for our particular directed graph. Hence the path is
        // empty and the result must be null.
        System.out.println("Shortest path from c to i:");
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> cPaths = dijkstraAlg.getPaths("c");
        System.out.println(cPaths.getPath("i"));
        //@example:main:end
    }

    void directedGraph(){
        //@example:main:begin
        // constructs a directed graph with the specified vertices and edges
        Graph<String, DefaultEdge> directedGraph =
                new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");
        directedGraph.addVertex("e");
        directedGraph.addVertex("f");
        directedGraph.addVertex("g");
        directedGraph.addVertex("h");
        directedGraph.addVertex("i");
        directedGraph.addEdge("a", "b");
        directedGraph.addEdge("b", "d");
        directedGraph.addEdge("d", "c");
        directedGraph.addEdge("c", "a");
        directedGraph.addEdge("e", "d");
        directedGraph.addEdge("e", "f");
        directedGraph.addEdge("f", "g");
        directedGraph.addEdge("g", "e");
        directedGraph.addEdge("h", "e");
        directedGraph.addEdge("i", "h");

        // computes all the strongly connected components of the directed graph
        StrongConnectivityAlgorithm<String, DefaultEdge> scAlg =
                new KosarajuStrongConnectivityInspector<>(directedGraph);
        List<Graph<String, DefaultEdge>> stronglyConnectedSubgraphs =
                scAlg.getStronglyConnectedComponents();

        // prints the strongly connected components
        System.out.println("Strongly connected components:");
        for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++) {
            System.out.println(stronglyConnectedSubgraphs.get(i));
        }
        System.out.println();

        // Prints the shortest path from vertex i to vertex c. This certainly
        // exists for our particular directed graph.
        System.out.println("Shortest path from i to c:");
        DijkstraShortestPath<String, DefaultEdge> dijkstraAlg =
                new DijkstraShortestPath<>(directedGraph);
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> iPaths = dijkstraAlg.getPaths("i");
        System.out.println(iPaths.getPath("c") + "\n");

        // Prints the shortest path from vertex c to vertex i. This path does
        // NOT exist for our particular directed graph. Hence the path is
        // empty and the result must be null.
        System.out.println("Shortest path from c to i:");
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> cPaths = dijkstraAlg.getPaths("c");
        System.out.println(cPaths.getPath("i"));
        //@example:main:end

    }

    void directedWeighedGraph(){
        //@example:main:begin
        // constructs a directed graph with the specified vertices and edges
        Graph<String, DefaultWeightedEdge> directedGraph =
                new DefaultDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");
        directedGraph.addVertex("e");
        directedGraph.addVertex("f");
        directedGraph.addVertex("g");
        directedGraph.addVertex("h");
        directedGraph.addVertex("i");
        directedGraph.addEdge("a", "b");
        //directedGraph.setEdgeWeight("a", "b", 4);
        directedGraph.addEdge("b", "d");
        directedGraph.addEdge("d", "c");
        directedGraph.addEdge("c", "a");
        directedGraph.addEdge("e", "d");
        directedGraph.addEdge("e", "f");
        directedGraph.addEdge("f", "g");
        directedGraph.addEdge("g", "e");
        directedGraph.addEdge("h", "e");
        directedGraph.addEdge("i", "h");

        // computes all the strongly connected components of the directed graph
        StrongConnectivityAlgorithm<String, DefaultWeightedEdge> scAlg =
                new KosarajuStrongConnectivityInspector<>(directedGraph);
        List<Graph<String, DefaultWeightedEdge>> stronglyConnectedSubgraphs =
                scAlg.getStronglyConnectedComponents();

        // prints the strongly connected components
        System.out.println("Strongly connected components:");
        for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++) {
            System.out.println(stronglyConnectedSubgraphs.get(i));
        }
        System.out.println();

        // Prints the shortest path from vertex i to vertex c. This certainly
        // exists for our particular directed graph.
        System.out.println("Shortest path from i to c:");
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg =
                new DijkstraShortestPath<>(directedGraph);
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> iPaths = dijkstraAlg.getPaths("i");
        System.out.println(iPaths.getPath("c") + "\n");

        // Prints the shortest path from vertex c to vertex i. This path does
        // NOT exist for our particular directed graph. Hence the path is
        // empty and the result must be null.
        System.out.println("Shortest path from c to i:");
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> cPaths = dijkstraAlg.getPaths("c");
        System.out.println(cPaths.getPath("i"));
        //@example:main:end
    }

    void directedWeighedCustomGraph() {
        //@example:main:begin
        // constructs a directed graph with the specified vertices and edges
        Graph<Gleisknoten, Gleiskante> directedGraph =
                new SimpleDirectedWeightedGraph<Gleisknoten, Gleiskante>(Gleiskante.class);

        Gleisknoten k1 =new Gleisknoten();
        Gleisknoten k2 =new Gleisknoten();
        Gleisknoten k3 =new Gleisknoten();
        Gleisknoten k4 =new Gleisknoten();
        Gleisknoten k5 =new Gleisknoten();
        Gleisknoten k6 =new Gleisknoten();
        Gleisknoten k7 =new Gleisknoten();
        Gleisknoten k8 =new Gleisknoten();
        Gleisknoten k9 =new Gleisknoten();


        directedGraph.addVertex(k1);
        directedGraph.addVertex(k2);
        directedGraph.addVertex(k3);
        directedGraph.addVertex(k4);
        directedGraph.addVertex(k5);
        directedGraph.addVertex(k6);
        directedGraph.addVertex(k7);
        directedGraph.addVertex(k8);
        directedGraph.addVertex(k9);

        Gleiskante n1 = new Gleiskante();
        Gleiskante n2 = new Gleiskante();
        Gleiskante n3 = new Gleiskante();
        Gleiskante n4 = new Gleiskante();
        Gleiskante n5 = new Gleiskante();
        Gleiskante n6 = new Gleiskante();
        Gleiskante n7 = new Gleiskante();
        Gleiskante n8 = new Gleiskante();
        Gleiskante n9 = new Gleiskante();
        Gleiskante n10 = new Gleiskante();

        directedGraph.addEdge(k1, k2, n1);
        directedGraph.addEdge(k2, k4, n2);
        directedGraph.addEdge(k4, k3, n3);
        directedGraph.addEdge(k3, k1, n4);
        directedGraph.addEdge(k5, k4, n5);
        directedGraph.addEdge(k5, k6, n6);
        directedGraph.addEdge(k6, k7, n7);
        directedGraph.addEdge(k7, k5, n8);
        directedGraph.addEdge(k8, k5, n9);
        directedGraph.addEdge(k9, k8, n10);

        // computes all the strongly connected components of the directed graph
        StrongConnectivityAlgorithm<Gleisknoten, Gleiskante> scAlg =
                new KosarajuStrongConnectivityInspector<>(directedGraph);
        List<Graph<Gleisknoten, Gleiskante>> stronglyConnectedSubgraphs =
                scAlg.getStronglyConnectedComponents();

        // prints the strongly connected components
        System.out.println("Strongly connected components:");
        for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++) {
            System.out.println(stronglyConnectedSubgraphs.get(i));
        }
        System.out.println();

        // Prints the shortest path from vertex i to vertex c. This certainly
        // exists for our particular directed graph.
        System.out.println("Shortest path from k9 to k3:");
        DijkstraShortestPath<Gleisknoten, Gleiskante> dijkstraAlg =
                new DijkstraShortestPath<>(directedGraph);
        ShortestPathAlgorithm.SingleSourcePaths<Gleisknoten, Gleiskante> iPaths = dijkstraAlg.getPaths(k9);
        System.out.println(iPaths.getPath(k3) + "\n");

        // Prints the shortest path from vertex c to vertex i. This path does
        // NOT exist for our particular directed graph. Hence the path is
        // empty and the result must be null.
        System.out.println("Shortest path from k3 to k9:");
        ShortestPathAlgorithm.SingleSourcePaths<Gleisknoten, Gleiskante> cPaths = dijkstraAlg.getPaths(k3);
        System.out.println(cPaths.getPath(k9));
        //@example:main:end
    }
}
