import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        int a, b, value;

        Scanner scanner = new Scanner(System.in); //принимаем строку
        String [] str = inputString(scanner);

        if (Arabian.isArabian(str[0])){
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[2]);
        } else {
            a = Romain.romainToArabian(str[0]);
            b = Romain.romainToArabian(str[2]);
        }
        if (a > 10 || b > 10) throw new Exception("Максимальное число - 10");
        value = toCalculate(str[1].charAt(0), a, b);
        if (Romain.isRomain(str[0])){
            System.out.println(Romain.toPrint(value));
        } else System.out.println(Arabian.toPrint(value));
    }

    private static String [] inputString(Scanner scanner) {
        String [] value = null;
        try {
            String str = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\s");
            value = pattern.split(str);
            if (value.length != 3) throw new Exception("Некорректный ввод");
        } catch (Exception ex){
            System.out.println(ex);
        }
        return value;
    } // метод возвращает массив с оператором и строками чисел

    static int toCalculate(Character op, int a, int b) {
        int value;
        switch (op) {
            case '+':
                value = a + b;
                break;
            case '-':
                value = a - b;
                break;
            case '*':
                value = a * b;
                break;
            case '/':
                try {
                    if (b == 0) throw new Exception("Делить на ноль нельзя");
                    value = a / b;
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    value = 0;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + op);
        }
        return value;
    } // проводим математическую операцию
}