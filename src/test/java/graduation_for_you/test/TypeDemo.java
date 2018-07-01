
package graduation_for_you.test;

import org.junit.Test;

import com.nap.entity.vo.GdProjectExtend;

public class TypeDemo {
    
    @Test
    public void test(){
        String param = "dd&";
       System.out.println(param.substring(0,param.length()-1));
    }
    
   /* @Test
    public void test(){
        GdProjectQueryVo gdProjectQueryVo = new GdProjectQueryVo();
        
      //gdProjectQueryVo.setTypecode("t2");
        gdProjectQueryVo.setLancode("l3");
        
        
        List<GdTypeExtend> types = new ArrayList<GdTypeExtend>();
        GdTypeExtend g1 = new GdTypeExtend();
        g1.setTcode("t1");
        GdTypeExtend g2 = new GdTypeExtend();
        g2.setTcode("t2");
        GdTypeExtend g3 = new GdTypeExtend();
        g3.setTcode("t3");
        types.add(g1);
        types.add(g2);
        types.add(g3);
        handleUrl(types, "typecode", gdProjectQueryVo);
        
        List<GdTypeExtend> lans = new ArrayList<GdTypeExtend>();
        GdTypeExtend l1 = new GdTypeExtend();
        l1.setTcode("l1");
        GdTypeExtend l2 = new GdTypeExtend();
        l2.setTcode("l2");
        GdTypeExtend l3 = new GdTypeExtend();
        l3.setTcode("l3");
        lans.add(l1);
        lans.add(l2);
        lans.add(l3);
        handleUrl(lans, "lancode", gdProjectQueryVo);
        
        System.out.println(types);
        System.out.println(lans);
    }*/
    
    @Test
    public void test1(){
       /* String s = "5";
        System.out.println(5.0 == 5.00);
        boolean ss = false;
        ss = (5.0 == 5.0);
        System.out.println(ss);*/
    //    System.out.println(Integer.valueOf("3") >= 3);
        GdProjectExtend p = new GdProjectExtend();
        p.setRemainmoney(9.9);
        Double s = Double.valueOf("9.9");
        Double ss = 9.9;
        System.out.println((double)ss == p.getRemainmoney());
    }

}
