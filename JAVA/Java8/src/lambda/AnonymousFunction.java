package lambda;

public class AnonymousFunction {
    public static void main(String[] args) {
        // Sử dụng hàm vô danh để triển khai giao diện có nhiều phương thức abstract
        MyFunctionalInterface myFunctionalInterface = () -> {
            System.out.println("Triển khai cho method1.");
            System.out.println("Triển khai cho method2.");
        };

//        MyFunctionalInterface test = new MyFunctionalInterface() {
//            @Override
//            public void method1() {
//
//            }
//
//            @Override
//            public void method2() {
//
//            }
//        };

        // Gọi các phương thức từ đối tượng triển khai giao diện
        myFunctionalInterface.method1();
        myFunctionalInterface.defaultMethod();

        MyFunctionalInterface.staticMethod();
    }
}

//@FunctionalInterface
interface MyFunctionalInterface {
    void method1(); // Phương thức abstract đầu tiên
//    void method2(); // Phương thức abstract đầu tiên

    // Bạn có thể có các phương thức khác (default, static) không ảnh hưởng đến tính chất chức năng
    default void defaultMethod() {
        System.out.println("Đây là phương thức mặc định.");
    }

    static void staticMethod() {
        System.out.println("Đây là phương thức static.");
    }
}
