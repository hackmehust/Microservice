import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String> test = null;
        if (test.size() > 0) {
            test.forEach(e -> {
                System.out.println(e);
            });
        }
    }
}
