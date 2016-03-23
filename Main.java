import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class Main {

    public static void main(String[] args) {
        //If the length of args is zero, we return, we need valid input
        if (args.length == 0) {
            System.out.println("Please enter a valid file name that is currently in your directory or a valid file path!");
        } else if (args.length == 2) {
            //if the user enters one in the command prompt , they are on windows and need special formating for the path
            if (args[1].equals("1")) {
                String path = args[0];
                path = path.replace("\\", "/");
                try {
                    List<Node> nodes = IO.readFromFile(path);
                } catch (FileNotFoundException e) {
                    System.out.println("Error: file not found!");
                } catch (IOException e) {
                    System.out.println("Error: IOException, something went wrong!");
                }
                //If linux or mac
            }

        } else {
            String input = args[0];
            try {
                List<Node> nodeList = IO.readFromFile(input);
                startDijkstra(nodeList);

            }catch (Exception e) {
                System.out.println("There was an error! Please check your input and try again");
            }
        }
    }//end main

    private static void  startDijkstra(List<Node> nodes){
        Dijkstra dijkstra = new Dijkstra(nodes);
        dijkstra.execute();
    }
}//end class



//
//        //If the length is zero, then the user did not input an input file
//        if (args.length == 0) {
//            try {
//                List<Node> nodes = IO.readFromFile("25000.txt");
//
//                Dijkstra dijkstra = new Dijkstra(nodes);
//                dijkstra.execute();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            //There are arguments, if they inlcluded the number one in there work, then it is a microsoft windows path
//        } else if (!args[1].equals("1")) {
//            String path = args[0];
//            try {
//                List<Node> nodes = IO.readFromFile(path);
//                System.out.println(nodes.get(0));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            String path = args[0];
//            path = path.replace("\\", "/");
//            try {
//                List<Node> nodes = IO.readFromFile(path);
//            } catch (FileNotFoundException e) {
//
//                System.out.println("Error: file not found!");
//
//            } catch (IOException e) {
//
//                System.out.println("Error: IOException, something went wrong!");
//
//            }
//
//        }
//
//
//    }




