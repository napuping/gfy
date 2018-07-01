
package split;

import org.junit.Test;

public class SplitDemo {
    
    @Test
    public void tes1(){
        String c = "c:\\static\\123rt.txt";
        String tmp[] = c.split("\\\\");
        System.out.println(tmp[tmp.length-1]);
    }

}
