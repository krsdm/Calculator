import java.util.Scanner;

public class InOut {

    public String getInput() {
        show("Введите выражение:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        return input;
    }

    public void show(String string) {
        System.out.println(string);
    }

}