import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rex Petersen on 3/5/16.
 *
 * A graph class with the key of integers and a value of nodes
 *
 */
public class Graph {

    private HashMap<Integer, Node> graph;


    public Graph(){

        this.graph = new HashMap<Integer, Node>();

    }

    //Inserts a value into the graph
    public void insert(Node n){
        //We get the id of the num
        graph.put(n.getIdOfNode(), n);
    }

    //Finds if the graph contains the n node
    public boolean contains(Node n){
        return graph.containsKey(n.getIdOfNode());
    }
    //Finds if the graph contains the n Node
    public boolean contains(int id){
        return graph.containsKey(id);
    }

    //Pretty print the contents of the graph
    public void display(){

        for(int i = 0; i < graph.size(); i++){
            Node n = graph.get(i);
            n.display();

        }
    }




    public static void main(String[] args) throws IOException {

        Graph graph = new Graph();

        List<Node> nodeList = IO.readFromFile("5.txt");

        for(Node n : nodeList){
            graph.insert(n);
        }

        graph.display();




    }


}
