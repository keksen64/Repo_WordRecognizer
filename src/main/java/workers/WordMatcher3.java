package workers;


import web.MainClass;

import java.util.Date;

// класс выполняет вторичный подсчет групп одинаковых слов игнорируя порядок и отличающиеся окончания
public class WordMatcher3 {
    public static WordCountObject[] match(WordCountObject[] arr){

        Date date = new Date();
        System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || начало повторной сверки");
        int replaseCount =0;
        int deleteCount =0;
        int size = arr.length;
        int i=0;
        while (i<size){
            int k =0;
            while (k<size){
                if(arr[i]!=null&&arr[k]!=null&&i!=k){
                    //System.out.println("встретились не нули");
                    String[] words1 = arr[i].getWord().split(" ");
                    String[] words2 = arr[k].getWord().split(" ");
                    if((reconciliation(words1[0],words2[0])&&reconciliation(words1[1],words2[1])&&reconciliation(words1[2],words2[2]))||
                            (reconciliation(words1[1],words2[0])&&reconciliation(words1[0],words2[1])&&reconciliation(words1[2],words2[2]))||
                            (reconciliation(words1[0],words2[0])&&reconciliation(words1[1],words2[2])&&reconciliation(words1[2],words2[1]))||
                            (reconciliation(words1[0],words2[2])&&reconciliation(words1[1],words2[1])&&reconciliation(words1[2],words2[0]))
                    ){
                        arr[i].setCount(arr[i].getCount()+arr[k].getCount());
                        arr[k]=null;
                        replaseCount++;
                    }
                }
                k++;
            }
            i++;
        }
         date = new Date();
         int d=0;
        while (d<size) {

            if(arr[d] != null){
                //System.out.println(arr[d].word.toLowerCase());
                if (MainClass.secondBlackList.isInBlackList(arr[d].getWord().toLowerCase())==true) {
                    arr[d] = null;
                    deleteCount++;
                }
            }
            d++;
        }
        System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || сделано "+ replaseCount + " замен "+deleteCount + " удалено");

        return arr;
    }




    public static boolean reconciliation(String s1,String s2){
        Boolean b = false;
        //если отличие больше двух символов
        if(Math.abs(s1.length()-s2.length())>2){
            return false;
        }
        //если длины равны
        if(Math.abs(s1.length()-s2.length())==0){
            if (s1.length()>4){
                //-2
                String ss1 = s1.substring(0, s1.length() - 2);
                String ss2 = s2.substring(0, s2.length() - 2);
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }else {
                //-1
                String ss1 = s1.substring(0, s1.length() - 1);
                String ss2 = s2.substring(0, s2.length() - 1);
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }
        }
        //если отличие два символа то у бОльшего надо отнять два символа и сравнить
        if(Math.abs(s1.length()-s2.length())==2){
            if (s1.length()>s2.length()){
                //s1 длиннее
                String ss1 = s1.substring(0, s1.length() - 2);
                String ss2 = s2;
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }else {
                //s2 длиннее
                String ss1 = s1;
                String ss2 = s2.substring(0, s2.length() - 2);
                if(ss1.equals(ss2)){
                    return true;
                }else {
                    return false;
                }
            }
        }
        //если отличие один символ
        if(Math.abs(s1.length()-s2.length())==1){
            if (s1.length()>s2.length()){
                //s1 длиннее
                if(s2.length()>3){
                    String ss1 = s1.substring(0, s1.length() - 2);
                    String ss2 = s2.substring(0, s2.length() - 1);
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    String ss1 = s1.substring(0, s1.length() - 1);
                    String ss2 = s2;
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }
            }else {
                //s2 длиннее
                if(s1.length()>3){
                    String ss1 = s1.substring(0, s1.length() - 1);
                    String ss2 = s2.substring(0, s2.length() - 2);
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    String ss1 = s1;
                    String ss2 = s2.substring(0, s2.length() - 1);
                    if(ss1.equals(ss2)){
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        }
        return b;
    }

}
