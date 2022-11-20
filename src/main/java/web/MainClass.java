package web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import workers.*;

public class MainClass {
    public static BlackList blackList = new BlackList();
    public static int ee;
    public static String wordsThree ="";

    public static void main(String[] args) throws Exception {
        System.out.println("поток_"+Thread.currentThread().getName());

        Scheduler sh = new Scheduler();
        sh.start();
        HttpServer server = HttpServer.create(new InetSocketAddress(8004), 0);
        server.createContext("/words/three", new GetThreeWords());
        server.setExecutor(java.util.concurrent.Executors.newFixedThreadPool(10));
        server.start();
    }




  //  static class getThreeWords  implements HttpHandler {
//        {
//            Date date = new Date();
//            System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || создание экземпляра обработчика ");
//        }
//        @Override
//        public void handle(HttpExchange httpExchange) throws IOException {
//            Date date = new Date();
//
//            try {
//                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || старт тестового замедления");
//                Thread.sleep(30000);
//            }catch (Exception e){
//
//            }
//            date = new Date();
//            System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || поступление запроса в обработчик handle");
//            try {
//                //WordCountObject[] r = WordMatcher3.match(WordExtractor3.start(StaplerClass.staple(Reader2List.read("siteList.csv"))));
//                String response = MainClass.wordsThree;
//                byte[] bytesErr = response.getBytes(StandardCharsets.UTF_8);
//                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
//                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
//                httpExchange.sendResponseHeaders(200, 0);
//                OutputStream os = httpExchange.getResponseBody();
//                Writer ow = new OutputStreamWriter(os);
//                ow.write(utf8EncodedStringErr);
//                ow.close();
//                os.close();
//                date = new Date();
//                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || отправлен ответ handle");
//
//            }catch (Exception e){
//                String responseErr = "Возникла какая-то ошибка ((";
//                byte[] bytesErr = responseErr.getBytes(StandardCharsets.UTF_8);
//                String utf8EncodedStringErr = new String(bytesErr, StandardCharsets.UTF_8);
//                httpExchange.getResponseHeaders().set("Access-Control-Allow-Origin", " *");
//                httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
//                // t.sendResponseHeaders("Access-Control-Allow-Origin: *");
//                httpExchange.sendResponseHeaders(200, 0);
//                OutputStream os = httpExchange.getResponseBody();
//                Writer ow = new OutputStreamWriter(os);
//                ow.write(utf8EncodedStringErr);
//                ow.close();
//                os.close();
//                date = new Date();
//                System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || отправлен ошибочный ответ handle");
//
//            }
//        }
  //  }
}