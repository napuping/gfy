
package com.nap.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.nap.entity.result.ResultData;

public class MessageUtil {

    private static CloseableHttpClient getHttpClient() {
        return HttpClients.createDefault();
    }

    private static HttpPost getPost(String url, String mobile, String appKey, String appScrect, String templateid,
            String codeLen) {
        HttpPost post = new HttpPost(url);
        String nonce = UUID.randomUUID().toString();
        String curTime = new Date().getTime() + "";
        String checkSum = CheckSumBuilder.getCheckSum(appScrect, nonce, curTime);
        // 设置请求头
        post.addHeader("AppKey", appKey);
        post.addHeader("Nonce", nonce);
        post.addHeader("CurTime", curTime);
        post.addHeader("CheckSum", checkSum);
        // 设置请求参数
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("mobile", mobile));
        pairs.add(new BasicNameValuePair("templateid", templateid));
        pairs.add(new BasicNameValuePair("codeLen", codeLen));
        UrlEncodedFormEntity formEntity = null;
        // 编码
        try {
            formEntity = new UrlEncodedFormEntity(pairs, "utf-8");
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(formEntity);
        return post;
    }

    private static Map<String, Object> getData
            (CloseableHttpResponse response) throws ParseException, IOException {
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        return JsonUtil.json2Map(result);
    }

    public static ResultData sendMessage(String url, 
            String mobile, String appKey, String appScrect, String templateid,
            String codeLen) {
        ResultData data = new ResultData();
        String premessage = "发送信息时出现错误！";
        CloseableHttpClient client = getHttpClient();
        HttpPost post = getPost(url, mobile, appKey, appScrect, templateid, codeLen);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            Map<String, Object> map = getData(response);
            if((String.valueOf(map.get("code"))).equals("200")) {
                // 如果是200 发送成功 则将验证码写进resultData
                data.setCode("200");
                data.setData(map.get("obj"));
                data.setMessage("信息发送成功！");
            } else {
                writeToData(data, "300", premessage);
            }
        } catch(IOException e) {
            writeToData(data, "300", premessage);
            e.printStackTrace();
        }
        return data;
    }

    private static void writeToData(ResultData data, String code, String message) {
        data.setCode(code);
        data.setMessage(message);
    }
}
