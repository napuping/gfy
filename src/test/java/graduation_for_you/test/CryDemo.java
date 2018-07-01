
package graduation_for_you.test;

import org.junit.Test;
import org.springframework.util.DigestUtils;

public class CryDemo {
    
    @Test
    public void crytest(){
        String s = "sa";
        System.out.println(DigestUtils.md5DigestAsHex(s.getBytes()));
    }

}
