package tpu.company;


import java.util.HashMap;
import java.util.Map;

public class Helper {

    private static Map<String,String> engRus = new HashMap<String,String>();
    private String string;
    private String result;
    public static void feel_the_dict(){
        engRus.put("q","й");engRus.put("w","ц");
        engRus.put("e","у");engRus.put("r","к");
        engRus.put("t","е");engRus.put("y","е");
        engRus.put("u","г");engRus.put("i","ш");
        engRus.put("o","щ");engRus.put("p","з");
        engRus.put("х","х");engRus.put("]","ъ");
        engRus.put("a","ф");engRus.put("s","ы");
        engRus.put("d","в");engRus.put("f","а");
        engRus.put("g","п");engRus.put("h","р");
        engRus.put("j","о");engRus.put("k","л");
        engRus.put("l","д");engRus.put(";","ж");
        engRus.put("'","э");engRus.put("z","я");
        engRus.put("x","ч");engRus.put("c","с");
        engRus.put("v","м");engRus.put("b","и");
        engRus.put("n","т");engRus.put("m","ь");
        engRus.put(",","б");engRus.put(".","ю");
    }

    Helper(String string){
        this.string = string;
        feel_the_dict();
        fromShitIntoRussian();
    }

    public void fromShitIntoRussian(){
        int length = string.length();
        String element;
        for( int i = 0; i < length; i++){
            element = String.valueOf(string.charAt(i)).toLowerCase();
            switch (element){
                case " ":
                    result += " ";
                    break;
                default:
                    result += engRus.get(element);
            }
        }
        System.out.println("Результат перевода: \n" + result + "\n");
    }
}
