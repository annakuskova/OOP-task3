import java.util.ArrayList;

public class Third {
    public static void main(String[] args) {
        System.out.println("1. " + solutions(1, 0, -1));
        System.out.println("2. " + findZip("all zip files are zipped"));
        System.out.println("3. " + checkPerfect(6));
        System.out.println("4. " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("5. " + isValidHexCode("#CD5C5C"));
        int[] array1 = {1, 3, 4, 4, 4};
        int[] array2 = {2, 5, 7};
        System.out.println("6. " + same(array1, array2));
        System.out.println("7. " + isKaprekar(297));
        System.out.println("8. " + longestZero("01100001011000"));
        System.out.println("9. " + nextPrime(12));
        System.out.println("10. " + rightTriangle(3,4,5));
    }


    // количество решений квадратного уравнения
    public static String solutions (int a, int b, int c) {
        if (a == 0 && b != 0) {
            return "1";
        }
        if (a == 0 && b == 0 && c != 0) {
            return "0";
        }
        if (a == 0 && b == 0 && c == 0) {
            return "infinity";
        }
        if ((b*b - 4*a*c) < 0) {
            return "0";
        }
        if ((b*b - 4*a*c) == 0) {
            return "1";
        }
        if ((b*b - 4*a*c) > 0) {
            return "2";
        }
        return "";
    }

    // возвращает позицию второго вхождения " zip " в строку,
    // или -1, если оно не происходит по крайней мере дважды
    public static int findZip(String s) {
        if (s.indexOf("zip") > 0) {
            s = s.substring(0, s.indexOf("zip")) + " " + s.substring(s.indexOf("zip") + 1);
            if (s.indexOf("zip") >= 0) {
                return s.indexOf("zip");
            }
        }
        return -1;
    }

    //
    public static boolean checkPerfect(int b) {
        ArrayList<Integer> multipliers = new ArrayList<>();
        for (int i = 1; i < b; i++) {
            if (b%i == 0) {
                multipliers.add(i);
            }
        }
        if (multipliers.size() > 0) {
            int sum = 0;
            for (int i : multipliers) {
                sum += i;
            }
            if (sum == b) {
                return true;
            }
        }
        return false;
    }

    //Замена первого и последнего символов строки
    //– Если длина строки меньше двух, верните "несовместимо".".
    //– Если первый и последний символы совпадают, верните "два-это пара.".
    public static String flipEndChars(String s) {
        if (s.length() >= 2) {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                return "Two's a pair.";
            }
            return s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
        }
        return "Incompatible.";
    }

    //  является ли строка допустимым шестнадцатеричным кодом
    public static boolean isValidHexCode(String a) {
        if (a.length() == 7) {
            if (a.charAt(0) == '#') {
                for (int i = 1; i < a.length(); i++) {
                    if (!Character.isDigit(a.charAt(i))) {
                        char symbol = a.charAt(i);
                        if (!Character.isLetter(symbol)) {
                            return false;
                        }
                        symbol = Character.toUpperCase(symbol);
                        if (symbol != 'A' && symbol!= 'B' && symbol != 'C' && symbol != 'D' && symbol != 'E' && symbol != 'F') {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    // имеют ли 2 массива одинаковое количество уникальных элементов
    public static boolean same(int[] array1, int[] array2) {
        ArrayList<Integer> unique1 = new ArrayList<>();
        ArrayList<Integer> unique2 = new ArrayList<>();
        for (int i: array1) {
            if (!unique1.contains(i)) {
                unique1.add(i);
            }
        }
        for (int i: array2) {
            if (!unique2.contains(i)) {
                unique2.add(i);
            }
        }
        return unique1.size() == unique2.size();
    }

    // является ли число числом Капрекара
    public static boolean isKaprekar(int a) {
        int left = 0, right = 0;
        if (a*a/10 == 0) {
            return a == a*a;
        }
        int s = a*a, len = 0;
        while (s>0) {
            s = s/10;
            len++;
        }
        left = a*a/(int)Math.pow(10, len - len/2);
        right = a*a % (int)Math.pow(10, len - len/2);
        return a == left + right;
    }

    // возвращает самую длинную последовательность
    //последовательных нулей в двоичной строке
    public static String longestZero(String s) {
        String zeros = "";
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros += "0";
            }
            if (s.charAt(i) == '1') {
                if (zeros.length() > max.length()) {
                    max = zeros.substring(0);
                }
                zeros = "";
            }
        }
        if (zeros.length() > max.length()){
            max = zeros.substring(0);
        }
        return max;
    }

    // возвращает следующее простое число.
    // Если число простое, верните само число.
    public static int nextPrime(int a) {
        while (true) {
            boolean notPrime = false;
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    notPrime = true;
                }
            }
            if (!notPrime) {
                break;
            }
            a++;
        }
        return a;
    }

    //
    public static boolean rightTriangle (int x, int y, int z){
        return (x*x + y*y == z*z) || (x*x + z*z == y*y) || (y*y + z*z == x*x);
    }
}
