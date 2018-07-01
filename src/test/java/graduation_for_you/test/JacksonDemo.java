
package graduation_for_you.test;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {
    
    @Test
    public void test() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
      /*  String json = "{\"alipay_trade_query_response\":{\"code\":\"40004\",\"msg\":\"Business Failed\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map params = objectMapper.readValue(json, Map.class);
        System.out.println(((Map)params.get("alipay_trade_query_response")).get("code"));*/
      //  String json= "{\"one\":{\"id\":\"1\",\"name\":\"tom\"},\"one\":{\"id\":\"2\",\"name\":\"tom2\"},\"one\":{\"id\":\"3\",\"name\":\"tom3\"}}";
       // JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, User.class);
      //  List<User> users = objectMapper.readValue(json, javaType);
      //  Map map = objectMapper.readValue(json, Map.class);
       // System.out.println(map);
      // String json = "[{\"id\":\"1\",\"name\":\"tom\",\"address\":{\"id\":\"11\",\"name\":\"shanghai\"}}]";
       /* User user = new User();
        user.setId("1");
        user.setName("tom");
        Address add = new Address();
        add.setId("11");
        add.setName("shanghai");
        user.setAddresss(add);
        StringWriter string = new StringWriter();
        objectMapper.writeValue(string, user);
        System.out.println(string.toString());*/
        String json = "[{\"id\":\"1\",\"name\":\"tom\",\"address\":{\"aid\":\"11\",\"aname\":\"shanghai\"}},{\"id\":\"2\",\"name\":\"toms\",\"address\":{\"aid\":\"21\",\"aname\":\"shanghai22\"}}]";
        /*JavaType javatype = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, User.class);
        List<User> users = objectMapper.readValue(json,javatype);
        System.out.println(users);*/
        /*List<User> users = JsonUtil.json2List(json, User.class);
        System.out.println(users);
        System.out.println(JsonUtil.bean2Json(users));*/
    }
    
    @Test
    public void test2() throws JsonParseException, JsonMappingException, IOException{
        //带双引号的数字会被转成字符串  不带的会被转成integer
        String s = "{\"code\":'200'}";
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(s, Map.class);
        System.out.println(map.get("code").getClass());
        
    }
    
    

}
