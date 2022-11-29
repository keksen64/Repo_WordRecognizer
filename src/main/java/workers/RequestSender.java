package workers;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;


public class RequestSender {
    public static String sendGet(String url) {
        String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36";
        String USER_AGENT1 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.52";
        String USER_AGENT2 = "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko";
        String kk = "_ym_uid=1668803496396145239; _ym_d=1668803496; tmr_lvid=c720a7a7afee9f527422657f42b4920d; tmr_lvidTS=1668803495559; _ga=GA1.2.296993918.1668803496; kommersantSessionId=xnromoylpc5p6zer; UIDForPoll=1228657596; _ym_isad=2; _gid=GA1.2.252685075.1668939803; _gat=1; tmr_detect=0%7C1668940993596; tmr_reqNum=13";
        String kk1 = "FTID=0; VID=33XMRQ2pb6oD00000j1QL4YD:::0-0-0-8945f49:CAASEITnnTb3ikuwP_7wV68b4dcaYK7nuB7Ed_uBjfL0JaOpzftDureL8dY2YXss2FfqbR5VVmLgm5qSbIcv7vdiji_Igywaxu1OMAnIr-3Q0yLHFuxHhfD86g9F57tdBpa9qx7mePM0nznlfFcYKISXc5WkIQ";
        String kk2 = "tmr_lvid=7f5aa393bc36ad15495640c17ab46376; tmr_lvidTS=1668941317362; _ym_uid=166894131826762098; _ym_d=1668941318; UIDForPoll=496069831; _ga=GA1.2.543079501.1668941318; _gid=GA1.2.1073824723.1668941318; _ym_isad=2; tmr_detect=0%7C1668941320478; tmr_reqNum=4";
        String sec = "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"";
        String sec1 = "\"Microsoft Edge\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"";
        String sec2 = "";


        int r = (int)(Math.random()*3);
        int r1 = (int)(Math.random()*3);
        int r2 = (int)(Math.random()*3);

        String kkSet = null;
        String secSet =null;
        String userSet = null;
        if(r==0){
            kkSet = kk;
        }
        if(r==1){
            kkSet = kk1;
        }
        if(r==2){
            kkSet = kk2;
        }
        if(r1==0){
            secSet = sec;
        }
        if(r1==1){
            secSet = sec1;
        }
        if(r1==2){
            secSet = sec2;
        }
        if(r2==0){
            userSet = USER_AGENT;
        }
        if(r2==1){
            userSet = USER_AGENT1;
        }
        if(r2==2){
            userSet = USER_AGENT2;
        }

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setConfig(RequestConfig.custom()
                .setConnectTimeout(3000)
                .setSocketTimeout(3000)
                .setConnectionRequestTimeout(3000)
                .build()
        );
        //request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.54 Safari/537.36");
        //request.addHeader(":path:", "/film/"+ id +"/like/");
        request.addHeader("method", "GET");
        request.addHeader("cookie", kkSet);
        request.addHeader("Connection", "keep-alive");
        request.addHeader("accept-encoding", "gzip, UTF-8");
        request.addHeader("sec-ch-ua", secSet);
        request.addHeader("accept-language", "ru-RU,ru;q=0.9");
        request.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        request.addHeader("User-Agent", userSet);




        try {
            Date date = new Date();
            System.out.println("поток_"+Thread.currentThread().getName()+" "+date+" || отправка запроса к " + url);
            HttpResponse response = client.execute(request);
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode()!=200){
                System.err.println("поток_"+Thread.currentThread().getName()+" "+"получен код отличный от 200 " + url +" "+ response.getStatusLine().getStatusCode());
            }
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String str;
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        }catch (Exception e){
            System.out.println(e);
            System.err.println("поток_"+Thread.currentThread().getName()+" "+"ошибка отправки запроса гет к " + url);
            return null;
        }
    }
}