import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class IO {

    private static List<Node> nodeList;

    private static Node currentNode;

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
            nodeList.add(currentNode);
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
        //If the length is zero, then go ahead and skip
        if(tokens.length == 0 || s.equals("")){
            return;
        //If one, then it is a new node
        }else if(tokens.length == 1){
            //If the currentNode is not null, add it to the list.
            if( currentNode != null){
                nodeList.add(currentNode);
            }
            currentNode = new Node();
            currentNode.setIdOfNode(Integer.parseInt(tokens[0]));
            //I'm sorry but I'm still getting white space for some reason!
            //It will always make a length 3 array though
        }else if(tokens.length == 3){
                //Set the source node to be the current iterations id
                currentNode.getEdge().setSourceNode(currentNode.getIdOfNode());
                //Set the destination node to be the next node
                currentNode.getEdge().setDestinationNode(Integer.parseInt(tokens[1]));
                //Set the weight to the weight
                currentNode.getEdge().setWeight(Integer.parseInt(tokens[2]));
                currentNode.update();
        }else{
            return;
        }

    }


}
