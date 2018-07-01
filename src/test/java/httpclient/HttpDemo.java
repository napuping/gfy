
package httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nap.util.CheckSumBuilder;

public class HttpDemo {

    @Test
    public void test() throws ClientProtocolException, IOException {

        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();

        CloseableHttpClient client = HttpClients.custom().setConnectionManager(manager).build();

        HttpPost post = new HttpPost("https://www.baidu.com");

        CloseableHttpResponse response = client.execute(post);

        HttpEntity entity = response.getEntity();

        System.out.println(EntityUtils.toString(entity, "utf-8"));

    }

    @Test
    public void testmessage() throws ClientProtocolException, IOException {
        /*
         * AppKey 开发者平台分配的appkey
         * Nonce 随机数（最大长度128个字符）
         * CurTime 当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
         * CheckSum SHA1(AppSecret + Nonce + CurTime),三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
         */
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://api.netease.im/sms/sendcode.action";
      //  Content-Type:application/x-www-form-urlencoded;charset=utf-8
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        //添加指定header
        String appKey = "044e4a6016100a2951fd5734b8a30b23";
        String appScret = "dd8506b95401";
        
        String nonce = UUID.randomUUID().toString();
        String curTime = new Date().getTime() + "";
        String checkSum = CheckSumBuilder.getCheckSum(appScret, nonce, curTime);
      //  String code = new Random().nextInt(999999) + "";
        post.addHeader("AppKey",appKey);
        post.addHeader("Nonce",nonce);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        
        //mobile templateid codeLen
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("mobile", "15737325487"));
        pairs.add(new BasicNameValuePair("templateid", "3932851"));
        pairs.add(new BasicNameValuePair("codeLen", "6"));
        
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(pairs,"utf-8");
        
        post.setEntity(formEntity);
        
        CloseableHttpResponse response = client.execute(post);
        
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        
        System.out.println(result);
        
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(result, Map.class);
        
        System.out.println(map.get("obj") + "_" + map.get("code"));
        
        
        
    }
    
    @Test
    public void getRandom(){
        //1527408158982 1527408180811
      //  System.out.println(new Date().getTime()); //100000 999999 899999
        Random ran = new Random();
        System.out.println(ran.nextInt(999999));
        System.out.println(Math.random());
    }
    
    @Test
    public void test2(){
        System.out.println(DigestUtils.md5DigestAsHex("sc".getBytes()));
    }

}
