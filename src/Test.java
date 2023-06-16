import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author : wzq
 * @Date : 2023/4/21
 * @Version : 1.0
 * @Description :
 **/
public class Test {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d");

        Stream<String> stringStream = strings.stream().flatMap(s -> Arrays.asList(s, "1").stream());
        Stream<String> stringStream1 = stringStream.flatMap(s -> Arrays.asList(s, "2").stream());
        List<String> list = stringStream1.collect(Collectors.toList());
        System.out.println(list.toArray());
    }
}
