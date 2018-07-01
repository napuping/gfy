
package graduation_for_you.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nap.mapper.extend.GdTypeMapperExtend;

public class TypeMapperDemo {
    
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     //   GdTypeMapper bean = ac.getBean(GdTypeMapper.class);
       GdTypeMapperExtend bean = ac.getBean(GdTypeMapperExtend.class);
     /*  GdTypeExample example = new GdTypeExample();
       Criteria criteria = example.createCriteria();
       criteria.andPcodeEqualTo("ptype");
       List<GdType> types = bean.selectByExample(example);
        System.out.println(types);*/
     //  List<GdTypeExtend> es = bean.tests();
      // System.out.println(es.get(1).getChildren());
    }
    
    @Test
   public void test2(){
       
       long i = 1;
       System.out.println(1/30);
   }

}
