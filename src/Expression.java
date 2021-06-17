import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression extends RomanArabicNums {

    boolean romanStyle;
    int firstNum, secondNum;
    String operator;

    public String calculate() {
        int result = 0;

        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
        }

        if (romanStyle) return arabicToRoman(result);
        return Integer.toString(result);

    }

    public void parse(String input){

        String[] array = input.toUpperCase().split(" ");

        if (romanStyle){
            firstNum = romanToArabic(array[0]);
            secondNum = romanToArabic(array[2]);
        } else {
            firstNum = Integer.parseInt(array[0]);
            secondNum = Integer.parseInt(array[2]);
        }

        operator = array[1];

    }

    public boolean checkInput(String input) throws Exception {
        if (isArabic(input) || isRoman(input)){
            return true;
        } else {
            throw new Exception("Введенное выражение не соответсвует требованиям.");
        }
    }

    protected boolean isArabic(String input){
        String expreg = "^([1-9]|10)\\s([+\\-*/])\\s([1-9]|10)$";
        Pattern patternArabic = Pattern.compile(expreg);
        Matcher matcherArabic = patternArabic.matcher(input);
        if (!matcherArabic.find()) return false;
        romanStyle = false;
        return true;
    }

    protected boolean isRoman(String input){
        String expreg = "^(I{1,3}|IV|VI{0,3}|IX|X)\\s([+\\-*/])\\s(I{1,3}|IV|VI{0,3}|IX|X)$";
        Pattern patternRoman = Pattern.compile(expreg, Pattern.CASE_INSENSITIVE);
        Matcher matcherRoman = patternRoman.matcher(input);
        if (!matcherRoman.find()) return false;
        romanStyle = true;
        return true;
    }

}
