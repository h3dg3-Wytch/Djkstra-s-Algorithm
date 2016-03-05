import java.util.Collections;
import java.util.List;

/**
 * Created by h3dg3wytch on 3/1/16.
 */


public class JSONtest {

    public static String[] result = new String[5000];
    public static int currentIndex = 0;

    public static void main(String[] args){

        //permutation("", "hi");
        System.out.println(permutationOf("nope", "nope"));

    }

    public static void permutation(String prefix, String string){

        if(string.length() == 0){
            result[currentIndex] = prefix;
            currentIndex++;
        }

        for(int i = 0; i < string.length(); i++){
            permutation(prefix + string.charAt(i), string.substring(0, i) + string.substring(i + 1));
        }

    }

    public static boolean permutationOf(String one, String two){

//        permutation("", one);
//        for(String s : result){
//            if(s == null){
//                break;
//            }
//            if(s.equals(two)){
//                System.out.println("EQUALS");
//                return;
//            }
//        }
//        System.out.println("NOT FOUND");

        if (!isLengthEqual(one, two)) {

            return false;

        }

        return sort(one).equals(sort(two));

    }

    //Compare two stirngs by sorting them
    //Get the strings
    //Sort each
    //See if each other are equal
    public static String sort(String s){

       char[] c = s.toCharArray();
       java.util.Arrays.sort(c);
       return new String(c);
    }

    public static boolean isLengthEqual(String one,String two){
        if(one.length() != two.length())
            return false;
        else
            return true;
    }






}
