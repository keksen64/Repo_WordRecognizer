package workers;

import java.util.Arrays;
import java.util.Set;

public class BlackList {
    Set<String> set;
    String file;
    public BlackList(String file) {
        this.file = file;
    }
    {
    }
    public void read(){
        try {
            set = Reader2Set.read(file);
            Object[] ar = set.toArray();
            System.out.println(Arrays.toString(ar));
        }catch (Exception e){
            System.out.println("ОШИБКА ПРИ СОЗДАНИИ ЧЕРНОГО СПИСКА "+file);
        }
    }

    public boolean isInBlackList(String str){
        return set.contains(str);
    }
}
