package workers;

import web.MainClass;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word2ArrayExtractor {
    public static List<String> start(String resp){

        Date date = new Date();
        System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || начало извлечения слов");
        List<String> list = new ArrayList<String>() {};
        Pattern pattern = Pattern.compile("([А-Яа-я][А-Яа-я][А-Яа-я][А-Яа-я]*)");
        Matcher matcher = pattern.matcher(resp);
        int i =0;
        while (matcher.find()){
            int start=matcher.start();
            int end=matcher.end();
            if(MainClass.blackList.isInBlackList(resp.substring(start,end).toLowerCase())==true){
                continue;
            }
            list.add(i,resp.substring(start,end).toLowerCase());
            i++;
        }
        date = new Date();
        System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || Первичный массив получен " + list.size());
        return list;
    }
}
