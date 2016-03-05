import java.util.ArrayList;
import java.util.List;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class Node {

    private Integer idOfNode;
    private Edge edge;
    private List<Edge> edgeList;

    public Node(){
        edgeList = new ArrayList<Edge>();
        edge = new Edge();
    }

    public Node(int num){
        this.idOfNode = num;
        edge = new Edge();
    }

    @Override
    public boolean equals(Object object){
        //If this the object, then we return true
        if(this == object){
            return true;
        }
        //If we get
        if(object == null){
            return false;
        }
        if(object.getClass() != object.getClass()){
            return  false;
        }

        Node otherNode = (Node) object;
        if(idOfNode == null){
           if(otherNode.getIdOfNode() == null){
               return false;
           }
        } else if( !idOfNode.equals(otherNode.getIdOfNode()))
            return false;
        return true;
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
}
