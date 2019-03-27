package com.jinju.lock;

import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class MyHttpClient {
	
	public static String getWebmainRequest(String requestName,Map<String,String> map){
		CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {  
            Set<String> set=map.keySet();
            StringBuilder sb=new StringBuilder();
            sb.append("http://127.0.0.1:8888").append("/api/").append(requestName).append("?");
            for(String s:set) {
            	sb.append(s).append("=").append(map.get(s)).append("&");
            }
            sb.deleteCharAt(sb.length()-1);
            HttpGet httpget = new HttpGet(sb.toString());  
            CloseableHttpResponse response = httpclient.execute(httpget);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    return EntityUtils.toString(entity);
                }  
            } finally {  
                response.close();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                httpclient.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
        return null;
	}
	

}
