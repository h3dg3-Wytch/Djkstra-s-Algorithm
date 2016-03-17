import java.util.ArrayList;
import java.util.List;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class Node implements Comparable<Node>{

    private Integer idOfNode;
    private Edge edge;
    private List<Edge> edgeList;
    private Integer parent;
    private Integer key;

    public Node(){
        edgeList = new ArrayList<Edge>();
        edge = new Edge();
    }

    public Node(int num){
        this.idOfNode = num;
        edgeList = new ArrayList<Edge>();
        edge = new Edge();
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

    public Edge getEdge(){
        return this.edge;
    }

    public void update(){

        edgeList.add(this.edge);
        edge = new Edge();
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
