import java.util.List;

class Convertor {

    private static List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

    public static String romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            }
            else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(romanNumeral + " невозможно конвертировать в Римские цифры");
        }

        return String.valueOf(result);

    }

    public static String arabicToRoman(int number) {
        if ((number <= 0)) {
            throw new IllegalArgumentException("В римской системе ответ может быть только больше нуля");
        }

        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                stringBuilder.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            }
            else {
                i++;
            }
        }

        return stringBuilder.toString();

    }

}
