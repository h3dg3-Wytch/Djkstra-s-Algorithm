import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class Test {

    public static void main(String[] args) {


        //If the length is zero, then the user did not input an input file
        if (args.length == 0) {
            try {
                List<Node> nodes = IO.readFromFile("1000.txt");
                for(Node n : nodes){
                    n.display();
                }
                Dijkstra dijkstra = new Dijkstra(nodes);
                dijkstra.execute();

            } catch (Exception e) {
                e.printStackTrace();
            }
            //There are arguments, if they inlcluded the number one in there work, then it is a microsoft windows path
        } else if (!args[1].equals("1")) {
            String path = args[0];
            try {
                List<Node> nodes = IO.readFromFile(path);
                System.out.println(nodes.get(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String path = args[0];
            path = path.replace("\\", "/");
            try {
                List<Node> nodes = IO.readFromFile(path);
            } catch (FileNotFoundException e) {

                System.out.println("Error: file not found!");

            } catch (IOException e) {

                System.out.println("Error: IOException, something went wrong!");

            }

        }


    }
}




