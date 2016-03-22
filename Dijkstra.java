import java.util.*;

/**
 * Created by h3dg3wytch on 3/16/16.
 */
public class Dijkstra {
    //The heap
   // private TheHeap<Node> nodeBinaryHeap;
    private HeapQueue<Node> nodeBinaryHeap;
    //The list of nodes with thier edges
    private List<Node> graph;
    //The parent nodes
    private Set<Node> results;
    //The total weight traveled
    private int totalWeight;

    public Dijkstra(List<Node> adjacencylist){
        NodeComparator comparator = new NodeComparator();
        this.nodeBinaryHeap = new HeapQueue<Node>();
        this.graph = adjacencylist;
        this.results = new HashSet<Node>();
        this.totalWeight = 0;
    }

    //Relaxes all of the edges, with the exception of root
    public void initializeSingleSource(List<Node> graph){

        Node root = graph.get(0);
        root.setKey(0);
        for(int i = 1 ; i < graph.size(); i++){
            Node temp = graph.get(i);
            temp.setKey(Integer.MAX_VALUE);
            temp.setParent(null);
        }

    }

    public void relax(Node n){

        //We go through the all edges that are in the node
        for(Edge e : n.getEdgeList()){
            Node temp = graph.get(e.getDestinationNode());
            if(temp.getKey() > n.getKey() + e.getWeight()){
                totalWeight += n.getKey() + e.getWeight();
                temp.setKey(n.getKey() + e.getWeight());
                temp.setParent(n.getIdOfNode());
            }
        }
    }

    public void execute(){
        //Old code for testing, you can input an adjacency Matrix
//        //Transfrom the matrix into the nodes
//        for (int i = 0; i < ints.length; i++) {
//            //New node at with id i
//            Node n = new Node(i);
//            //new Edge, that as long as it isn't zero, is will add that num to its weight, we also keep track of source and destination node
//            for (int j = 0; j < ints[i].length; j++) {
//                Edge edge = new Edge();
//                if (ints[i][j] != 0) {
//                    edge.setSourceNode(i);
//                    edge.setDestinationNode(j);
//                    edge.setWeight(ints[i][j]);
//                    n.getEdgeList().add(edge);
//                }
//            }
//            //add the nodes to the graph
//            graph.add(n);
//        }

        //Initialize the single source
        initializeSingleSource(graph);

        //insert everything into the heap
        for(Node n : graph){
            nodeBinaryHeap.insert(n);
        }

           //The loop will break when there is an error, trying to pull from the an empty priority queue.
            try{
                while(true) {

                        Node n = nodeBinaryHeap.deleteMin();
                        //totalWeight += n.getKey();
                        results.add(n);
                        //We go through the all edges that are in the node
                        relax(n);
                        nodeBinaryHeap.buildHeap();

                }
            }catch (Exception e){

            }

        System.out.println("The total length of the tree: " + totalWeight);


    }

    public class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.getKey() < o2.getKey())
                return -1;
            if(o1.getKey() > o2.getKey())
                return 1;
            return 0;
        }


    }


//    public static void main(String[] args){
//
//        Dijkstra d = new Dijkstra();
//
//        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
//                {0, 0, 3, 8, 5},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 9},
//                {0, 0, 7, 0, 0},
//        };
//
//        d.execute(graph);
//
//
//
//
//
//    }





}
