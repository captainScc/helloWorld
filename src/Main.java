import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int i = 5;
        int j = i++;
        System.out.println(i+"--"+j);
        if((i>++j) && (i++ == j)){
            System.out.println("==");
            i += j;
        }
        System.out.println(i);



    }

}


