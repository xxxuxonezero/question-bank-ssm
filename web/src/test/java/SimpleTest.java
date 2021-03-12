import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SimpleTest {
    @Test
    public void demo() {
        String str = "a,b,c,b,h";
        String[] split = str.split(",");
        System.out.println(split.length);
        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
        int daysOfThisYear = LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear);
    }

    @Test
    public void CollectionTest() {
        List<String> list = new ArrayList<>();
        list.add("gk");
        list.add("gk");
        list.add("gk");
        list.add("gk");
        String[] arr = list.toArray(new String[10]);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testForeach() {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("2");
        for (String s : list) {
            if ("1".equals(s)) {
                list.remove(s);
            }
            System.out.println(s);
        }
    }
}
