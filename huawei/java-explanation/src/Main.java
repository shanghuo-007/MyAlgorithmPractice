public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        String api = "/api/v1/user";

        String[] temp = api.split("/");
        for (String s : temp) {
            System.out.println(s);
        }
    }
}