package FourSum;

import java.util.ArrayList;
import java.util.Iterator;

public class HashCodeTest {

    public static void main(String[] args) {
        int hashCode = 1;
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()){
            Integer obj = i.next();
            hashCode  = 31 * hashCode + ((obj ==null)?0:obj.hashCode());
        }
    }
}
