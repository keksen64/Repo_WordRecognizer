package workers;

import java.util.Date;
import java.util.List;
import java.util.Set;


public class StaplerClass {
    public static String staple(List<String> list){
        Date date = new Date();
        System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || начало подготовки текста");
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<list.size()){
            try {
                sb.append(RequestSender.sendGet(list.get(i)));
            }catch (Exception e){
                System.out.println(e);
            }
            i++;
        }
        try {
            date = new Date();
            System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || возвращение текста");
            return sb.toString();
        }catch (Exception e){
            date = new Date();
            System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || степлер вернул пустое тело");
            return "";
        }

    }
}
