/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class Edge {

    //The source node
    private int sourceNode;
    //The destitnation node
    private int destinationNode;
    //The weight of the edge
    private int weight;

    //Blank constructor
    public Edge(){}

    public Edge(int sourceNode, int weight){
        this.sourceNode = sourceNode;
        this.weight = weight;
    }

    public Edge(int sourceNode, int destinationNode, int weight){
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(int sourceNode) {
        this.sourceNode = sourceNode;
    }

    public int getDestinationNode() {
        return destinationNode;
    }

    public void setDestinationNode(int destinationNode) {
        this.destinationNode = destinationNode;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void display(){
        System.out.println("Source #" + sourceNode + " Destination #" + destinationNode +" Weight of Edge: " + weight);
    }

}
