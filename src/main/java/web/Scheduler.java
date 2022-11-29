package web;

import workers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Scheduler extends Thread{
    public void run(){
        System.out.println("поток_"+Thread.currentThread().getName());
        System.out.println("поток__"+this.getName());
        while (true){
            Date date = new Date();
            try {
                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || запуск расчета по расписанию");
               // WordCountObject[] r = WordMatcher3.match(WordExtractor3.start(StaplerClass.staple(Reader2List.read("siteList.csv"))));
                WordCountObject[] r = WordMatcher3.match(BundleBuilder.build (Word2ArrayExtractor.start(StaplerClass.staple(Reader2List.read("siteList.csv")))));
                MainClass.wordsThree ="{"+date.toString()+"} "+ WordCountOrderClass.valueSort(r).toString();
                date = new Date();
                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || окончание расчета по расписанию");
            }catch (Exception e){
                date = new Date();
                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || ошибка расчета по расписанию");
                System.err.println(e);
            }
            try {
                date = new Date();
                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || запуск ожидания");
                Scheduler.sleep(120000);
            } catch (InterruptedException e) {
                date = new Date();
                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || ошибка ожидания");
                e.printStackTrace();
            }
        }


    }
}

