package workers;

import web.MainClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BundleBuilder {
    public static WordCountObject[] build (List<String> list){
        int i =0;
        WordCountObject[] wk = new WordCountObject[list.size()-2];
        while (i<(list.size()-2)){
            String res3 = list.get(i) + " " + list.get(i+1) + " " + list.get(i+2);
            if(MainClass.secondBlackList.isInBlackList(res3.toLowerCase())==true){
                i++;
                continue;
            }
            wk[i] = new WordCountObject(res3,1);
            i++;
        }
        return wk;
    }
}
