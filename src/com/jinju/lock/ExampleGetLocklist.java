package com.jinju.lock;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExampleGetLocklist {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("cmd", "lock_node");
		String comeback=MyHttpClient.getWebmainRequest("datalist", map);
		System.out.println(comeback);
		JSONArray jsonArr=JSON.parseArray(comeback);
		for(int i=0;i<jsonArr.size();i++) {
			JSONObject obj=jsonArr.getJSONObject(i);
			System.out.print("节点ID:"+obj.getString("NodeId")+"  ");
			System.out.print("锁类型:"+obj.getString("LockType")+"  ");
			System.out.print("锁状态:"+obj.getString("Status")+"  ");
			System.out.print("电池电量:"+obj.getString("Battery")+"  ");
			System.out.print("时间戳:"+obj.getString("Timebase")+"  ");
			System.out.print("轮询时间(ms):"+obj.getString("AskTimeInterval")+"  ");
			System.out.print("固件版本:"+obj.getString("FirewareVersion")+"  ");
			System.out.print("配置版本:"+obj.getString("ConfigVersion")+"  ");
			System.out.println();
		}
	}

}
