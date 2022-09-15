import java.util.regex.Pattern;

class Validator {

    static boolean isValid(String input){
        try {
            isCorrectFormat(input);
            return true;
        } catch (IncorrectFormatException e) {
            System.out.println("Некорректный формат выражения");
            return false;
        }

    }
    static void isCorrectFormat(String input) throws IncorrectFormatException {
        if (!input.matches("\\w+ [+\\-/*] \\w+")) {
            throw new IncorrectFormatException();
        }
    }

    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
