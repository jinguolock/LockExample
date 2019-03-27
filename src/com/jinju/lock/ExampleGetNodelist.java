package com.jinju.lock;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExampleGetNodelist {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("cmd", "node");
		String comeback=MyHttpClient.getWebmainRequest("datalist", map);
		System.out.println(comeback);
		JSONArray jsonArr=JSON.parseArray(comeback);
		for(int i=0;i<jsonArr.size();i++) {
			JSONObject obj=jsonArr.getJSONObject(i);
			System.out.print("节点ID:"+obj.getString("Id")+"  ");
			System.out.print("通道号:"+obj.getString("Channel")+"  ");
			System.out.print("最近上传数据时间:"+obj.getString("LastMsgTime")+"  ");
			System.out.print("lora带宽:"+obj.getString("LoraBw")+"  ");
			System.out.print("lora码率:"+obj.getString("LoraCodingRate")+"  ");
			System.out.print("lora频率:"+obj.getString("LoraFrequency")+"  ");
			System.out.print("lora功率:"+obj.getString("LoraPower")+"  ");
			System.out.print("lora扩频因子:"+obj.getString("LoraSpreadFactor")+"  ");
			System.out.print("节点名称:"+obj.getString("Name")+"  ");
			System.out.print("重发次数:"+obj.getString("Resent")+"  ");
			System.out.print("等待返回时间:"+obj.getString("ResponseTime")+"  ");
			System.out.print("所属基站:"+obj.getString("Station")+"  ");
			System.out.print("节点类型:"+obj.getString("type")+"  ");
			System.out.println();
		}
	}

}
