import java.util.ArrayList;
import java.util.List;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class Node implements Comparable<Node>{

    //the id of the node, what we will reference it by
    private Integer idOfNode;
    //the collection of edges that are around this node
    private List<Edge> edgeList;
    //the parent node
    private Integer parent;
    //the key of the node, used for graph algorithms
    private Integer key;

    public Node(){
        edgeList = new ArrayList<Edge>();

    }

    public Node(int num){
        this.idOfNode = num;
        edgeList = new ArrayList<Edge>();

    }

    public void display(){
        //Print out the curent Node
        System.out.println("Node # " + idOfNode);
        //Print out the edges
        for(Edge e : edgeList){
            e.display();
        }
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setIdOfNode(int idOfNode) {
        this.idOfNode = idOfNode;
    }

    public Integer getIdOfNode() {
        return idOfNode;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ID: " + idOfNode + " Key: " + key + " Parent: " + parent +"\n";
    }

    @Override
    public int compareTo(Node o) {
        if(key < o.getKey())
            return -1;
        if(key > o.getKey())
            return 1;
        return 0;
    }
}
