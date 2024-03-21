public class SwitchCase {
    public static void main(String[] args) {
        String caseCheck = "1";

        switch (caseCheck) {
            case "1":
                if (true) {
                    return;
                }
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            default:
                System.out.println("default");
        }
    }
}
