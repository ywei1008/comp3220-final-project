public class main {
    public static void main(String[] args) {
        System.out.println("Basic Java Application");
        System.out.println("Usage: java main [name]");

        if (args.length > 0) {
            System.out.println("Hello, " + String.join(" ", args) + "!");
        } else {
            System.out.println("Hello, World!");
        }

        // simple demo: sum of first 5 integers
        int sum = 0;
        for (int i = 1; i <= 5; i++) sum += i;
        System.out.println("Sum of 1..5 = " + sum);


        
    }
}
