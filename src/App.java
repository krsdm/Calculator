public class App {

    static final String info = "Калькулятор складывает, вычитает, умножает и делит арабские и римские числа от 1 до 10\n" +
            "Разделяйте числа и оператор одним пробелом. Например: 4 + 3, X - V, 6 * 2, xi / iii";

    static String userInput;
    static Expression expression = new Expression();
    static InOut io = new InOut();

    public static void main (String[] args){

        io.show(info);
        userInput = io.getInput();

        try{
            if (expression.checkInput(userInput)) expression.parse(userInput);
            io.show(expression.calculate());
        } catch (Exception e){
            io.show(e.getMessage());
            io.show("Программа завершена.");
            System.exit(0);
        }

    }

}
