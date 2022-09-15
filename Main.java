import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "check";


        while (!userInput.equals("")) {
            System.out.println("Input:");
            userInput = scanner.nextLine();
            userInput = calc(userInput);
            System.out.println(userInput);
        }

    }


    public static String calc(String input) {
        String[] inputArray;
        String type;
        String result;

        if (Validator.isValid(input)) {
            inputArray = input.split(" ");

            try {
                type = typeOfOperands(inputArray);
            } catch (IncorrectFormatException e) {
                System.out.println("Оба операнда должны принадлежать к единому типу счисления");
                return "";
            }

            if(!isInRange(inputArray, type)) {
                System.out.println("Оба операнда должны быть от 1 до 10 включительно");
                return "";
            }

            if (type.equals("arabic")) {
                result = String.valueOf(calculations(inputArray));
            }
            else {
                String[] operands = new String[] {
                        Convertor.romanToArabic(inputArray[0]),
                        inputArray[1],
                        Convertor.romanToArabic(inputArray[2])};

                result = Convertor.arabicToRoman(calculations(operands));
            }

            return result;
        }
        return "";
    }

    private static int calculations(String[] operands) {
        int a = Integer.parseInt(operands[0]);
        int b = Integer.parseInt(operands[2]);
        int result = 0;

        switch (operands[1]) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
        }

        return result;
    }

    private static String typeOfOperands(String[] operands) throws IncorrectFormatException {
        if(Validator.isNumeric(operands[0]) && Validator.isNumeric(operands[2])) {
            return "arabic";
        }
        else if ((!Validator.isNumeric(operands[0])) && (!Validator.isNumeric(operands[2]))) {
            return "roman";
        }
        else {
            throw new IncorrectFormatException();
        }
    }

    private static boolean isInRange(String[] strings, String type) {
        String operand1 = strings[0];
        String operand2 = strings[2];
        int a;
        int b;

        if (type.equals("roman")) {
            a = Integer.parseInt(Convertor.romanToArabic(operand1));
            b = Integer.parseInt(Convertor.romanToArabic(operand2));
        }
        else {
            a = Integer.parseInt(operand1);
            b = Integer.parseInt(operand2);
        }




        boolean aStatus = a > 0 && a <= 10;
        boolean bStatus = b > 0 && b <= 10;

        return aStatus && bStatus;
    }
}
