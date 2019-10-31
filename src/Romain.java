import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Romain {

    private static HashMap<Character, Integer> map = new HashMap(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
    }}; //таблица с уникальными значениями
                                                                            // римских цифор
    private static Map<String, Integer> map1 = new HashMap(){{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};         // римские единицы

    private static Map <String, Integer>map2 = new HashMap(){{
        put("X", 1);
        put("XX", 2);
        put("XXX", 3);
        put("XL", 4);
        put("L", 5);
        put("LX", 6);
        put("LXX", 7);
        put("LXXX", 8);
        put("XC", 9);
        put("C", 10);
    }};         // римские десятки

    public static String toPrint(int a) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a / 100 == 1) return founder(a/10,map2);
        if (a / 10 > 1){
            stringBuilder.append(founder(a/10, map2));
            if (a % 10 > 0){
                stringBuilder.append(founder(a%10,map1));
            }
            return stringBuilder.toString();
        }
        return stringBuilder.append(founder(a, map1)).toString();
    } // возвращаем строку с ответом выражения в римских цифрах

    public static int romainToArabian(String s){
        int value = 0;
        for (int i = 0; i < s.toUpperCase().toCharArray().length; i ++){
            try {
                value += map.get(s.toUpperCase().toCharArray()[i]);
            } catch (Exception e){
                System.out.println("Необходимо вводить только римские или только арабские цифры");
            }
            if (i > 0 && map.get(s.toUpperCase().toCharArray()[i]) > map.get(s.toUpperCase().toCharArray()[i-1])) {
                value -= map.get(s.toUpperCase().toCharArray()[i-1]) * 2;
            }
        }
        return value;
    } // перевод рисмких цифр в арабские

    public static Boolean isRomain (String s) {
        if (map1.containsKey(s.toUpperCase())) return true;
        return false;
    } // проверка, является ли строчка римским числом

    private static String founder (Integer a, Map b) {
        Set<Map.Entry<String, Integer>> entrySet = b.entrySet();
        Integer desiredObject = new Integer(a);//что хотим найти
        for (Map.Entry<String, Integer> pair : entrySet) {
            if (desiredObject.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }
        return null;
    } // костыль, которые ищет ключ по значению в map'ах

}
