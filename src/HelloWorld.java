public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println("Teller til ti");
        for (int i=1; i<=10; ++i) {
            System.out.println(i);
        }

        System.out.println("Andre teller til femti");
        for (int i=11; i<50; ++i) {
            System.out.println("Andre teller og sier " + i);
        }
    }
}
