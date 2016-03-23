import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class IO {

    private static List<Node> nodeList;

    private static Node currentNode;
    private static int position = 0;

    public static List<Node> readFromFile(String filePath) throws IOException{
        //Nake the nodeList to store all the Nodes
        nodeList = new ArrayList<Node>();

        //Set up the reader.
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(filePath));
            //Read in each line. If line is null break
            String line;
            while((line = reader.readLine()) != null){
                //Format line into a node
                formatString(line);
            }
            //Add the very last node generated to the list
            //nodeList.add(currentNode);
            //If you can't find the file
        }catch (FileNotFoundException e){
            System.out.println("ERROR: file not found. Please enter correct file path, or keep text file in directory");
            return null;
            //Something happened
        }catch(Exception e){
            System.out.println("ERROR: something went wrong with your file");
            return null;
            //Just closing down all the i/o bits
        }finally {
            if(reader != null) {
                reader.close();
                reader = null;
            }

           return nodeList;

        }


    }

    public static void formatString(String s) throws NumberFormatException{
        //Split the string by white space
        String[] tokens = s.split("\\s+");
        //This means it is the the first line
        if(tokens[0].contains("n")){
            //We get the index of the blank char
            int indexOfBlankSpace = s.indexOf(" ");
            //we figure out the number
            String amountOfNodesRaw = s.substring(2, indexOfBlankSpace);
            //translate it into an int
            int amountOfNodes = Integer.parseInt(amountOfNodesRaw);

            for(int i = 0; i < amountOfNodes; i++){
                nodeList.add(new Node(i));
            }

        }
        //If the length is zero, then go ahead and skip
        if(tokens.length == 0 || s.equals("")){
            return;
        //If one, then it is a new node
        }else if(tokens.length == 1){
            currentNode = nodeList.get(Integer.parseInt(tokens[0]));
            //I'm sorry but I'm still getting white space for some reason!
            //It will always make a length 3 array though
        }else if(tokens.length == 3){

            int currentNodeId = currentNode.getIdOfNode();
            int destinationNodeId = Integer.parseInt(tokens[1]);
            int edgeWeight = Integer.parseInt(tokens[2]);
            //We make a new edge
            Edge edge = new Edge();
            //Set the source Node
            edge.setSourceNode(currentNodeId);
            //Set the destination node
            edge.setDestinationNode(destinationNodeId);
            //Set the weight
            edge.setWeight(edgeWeight);

            //Put the edge in the current NOde
            currentNode.getEdgeList().add(edge);
            Edge reverseEdge = new Edge();

            //Now do the same but for the destination node
            Node temp = nodeList.get(destinationNodeId);

            //Set the source as the destination node
            reverseEdge.setSourceNode(destinationNodeId);
            //Set the destination as the current node
            reverseEdge.setDestinationNode(currentNodeId);
            reverseEdge.setWeight(edgeWeight);

            temp.getEdgeList().add(reverseEdge);

        }else{
            return;
        }

    }


}
