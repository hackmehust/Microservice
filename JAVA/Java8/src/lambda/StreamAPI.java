package lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("hello", "loda", "kaka");
        System.out.println(collection);
        Stream<String> streamOfCollection = collection.stream(); // Tạo ra một stream từ collection
        System.out.println(streamOfCollection);
    }
}
