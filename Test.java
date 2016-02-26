

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class Test {

    public static void main(String[] args){

        if(args.length == 0) {
            try {
                String result = IO.readFromFile("25000.txt");
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{

            if(!args[1].equals("1")) {
                String path = args[0];
                try {
                    String result = IO.readFromFile(path);
                    System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                String path = args[0];
                path = path.replace("\\" ,"/");
                try{
                    String result = IO.readFromFile(path);
                }catch (FileNotFoundException e){

                    System.out.println("Error: file not found!");

                }catch(IOException e){

                    System.out.println("Error: IOException, something went wrong!");

                }

            }




        }


    }



}
