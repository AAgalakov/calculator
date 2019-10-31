public class Arabian {

    public static String toPrint(int a) {
        return "" + a;
    } // возвращаем строку с ответом выражения

    public static Boolean isArabian (String str){
        String regex = "\\d+";
        return str.matches(regex);
    } // проверка является ли число арабским

}
