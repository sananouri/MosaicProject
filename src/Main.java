import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the field: ");
        int size = scanner.nextInt();
        System.out.println("Enter the position of the empty square");
        System.out.print("x: ");
        int x = scanner.nextInt();
        System.out.print("y: ");
        int y = scanner.nextInt();
        Field.fillField(size, x, y, args);
    }
}
