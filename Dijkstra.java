import java.util.*;

/**
 * Created by h3dg3wytch on 3/16/16.
 * Rex Petersen
 */
public class Dijkstra {

   // The heap that will store the nodes
    private HeapQueue<Node> nodeBinaryHeap;
    //The list of nodes with thier edges
    private List<Node> graph;
    //The nodes traveled
    private Set<Node> results;
    //The total weight traveled
    private int totalWeight;
    //The hash map that stores all the nodes, mainly used to quixkly retrieve the nodes due to 0(1) time
    private HashMap<Integer, Node> nodeHashMap;

    public Dijkstra(List<Node> adjacencylist){
        this.nodeBinaryHeap = new HeapQueue<Node>();
        this.nodeHashMap = new HashMap<Integer, Node>();
        this.graph = adjacencylist;
        this.results = new HashSet<Node>();
        this.totalWeight = 0;

    }

    //Relaxes all of the edges, with the exception of root
    public void initializeSingleSource(List<Node> graph){
        //set the first element key to root, and the jey to zero
        Node root = graph.get(0);
        root.setKey(0);
        //for all other elements, we the the key equal to infinity and the parent to nul
        for(int i = 1 ; i < graph.size(); i++){
            Node temp = graph.get(i);
            temp.setKey(Integer.MAX_VALUE);
            temp.setParent(null);
        }

    }

    //Relaxes all of the edges around the node
    public void relax(Node n){
        //We go through the all edges that are in the node
        for(Edge e : n.getEdgeList()){
            //we get the nodes id, which is the key
            int key = e.getDestinationNode();
            //Get the node
            Node temp = nodeHashMap.get(key);
            //If the value is not in the set we check the key
            if(!results.contains(temp)) {
                //if they key is greater than the key, then the parent nodes key and the edges
                if (temp.getKey() > n.getKey() + e.getWeight()) {
                    //set the key to the key of n and the weight of the edge
                    temp.setKey(n.getKey() + e.getWeight());
                    //set the parent of the node
                    temp.setParent(n.getIdOfNode());
                }
            }
        }
    }

    //executes all other methods, and performs the algorithm
    public void execute(){

        //initialize the single source
        initializeSingleSource(graph);

        //insert everything into the heap and the hashmap
        for(Node n : graph){
            nodeBinaryHeap.insert(n);
            nodeHashMap.put(n.getIdOfNode(), n);
        }

        while(!nodeBinaryHeap.isEmpty()) {

            //Get the min node ontop of the heap
            Node n = nodeBinaryHeap.deleteMin();
            //Add the keys total weight to the totalweight
            totalWeight += n.getKey();
            //Relax all edges that are coming out of
            relax(n);
            //Add the result to the traveled hashmap
            results.add(n);
            //reheapify the heap
            nodeBinaryHeap.update();
        }
        System.out.println("The total length of the tree: " + totalWeight);
    }
}
