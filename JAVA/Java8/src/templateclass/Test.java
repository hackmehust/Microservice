package templateclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User myName1 = new User();
        myName1.setName("Thang 1");

        User myName2 = new User();
        myName2.setName("Thang 2");

        List<User> listUser = new ArrayList<>();
        listUser.add(myName1);
        listUser.add(myName2);

        SupperClass supperClass = new SupperClass();
        supperClass.setUser(listUser);

        List<User> test2 = supperClass.getUser();

        test2.forEach(user -> System.out.println(user.getName()));
    }
}
