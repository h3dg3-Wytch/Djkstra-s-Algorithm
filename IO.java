import java.io.*;

/**
 * Created by h3dg3wytch on 2/25/16.
 */
public class IO {


    public static String readFromFile(String filePath) throws IOException{

        String result = "";
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = reader.readLine()) != null){
                result += line;
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR: file not found. Please enter correct file path, or keep text file in directory");
            return null;
        }catch(Exception e){
            System.out.println("ERROR: something went wrong with your file");
            return  null;
        }finally {
            if(reader != null) {
                reader.close();
                reader = null;
            }

            return result;
        }


    }

    public static String readFromFile(File file) throws IOException{

        String result = "";
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                result += line;
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR: file not found. Please enter correct file path, or keep text file in directory");
            return null;
        }catch(Exception e){
            System.out.println("ERROR: something went wrong with your file");
            return  null;
        }finally {
            if(reader != null) {
                reader.close();
                reader = null;
            }

            return result;
        }


    }
}
