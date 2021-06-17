import java.util.HashMap;

public class RomanArabicNums {

    public String arabicToRoman(int arabic){

        String[] romans = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabics = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();

        if (arabic < 0){
            arabic = Math.abs(arabic);
            result.append("-");
        }

        for (int i = 0; i < arabics.length; i++){
            while (arabics[i] <= arabic){
                result.append(romans[i]);
                arabic -= arabics[i];
            }
        }

        return result.toString();
    }

    public int romanToArabic(String romanNumber){

        HashMap<String, Integer> numbers = new HashMap<>();
            numbers.put("I", 1);
            numbers.put("V", 5);
            numbers.put("X", 10);
            numbers.put("L", 50);
            numbers.put("C", 100);

        String[] romanChars = romanNumber.split("");
        int result = 0;
        int previous = 0;
        int arabic;

        for (int i = romanChars.length - 1; i >= 0; i--){
            arabic = numbers.get(romanChars[i]);

            if (i == romanChars.length - 1){
                result = arabic;
            } else if (arabic < previous){
                result -= arabic;
            } else {
                result += arabic;
            }

            previous = arabic;
        }

        return result;
    }

}
