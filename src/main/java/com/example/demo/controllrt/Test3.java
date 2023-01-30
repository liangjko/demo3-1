package com.example.demo.controllrt;

import com.alibaba.druid.util.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test3 {
	
	
	public static void main(String[] args){
		CloseableHttpClient client = HttpClients.createDefault();
	
//		File file  = new File("E:\\data.txt");
		try{
//			FileOutputStream out = new FileOutputStream(file);
			for(int i = 2022; i < 2023; i++){
				for(int j = 1; j < 114; j++){
					String str = "";
					if(j<10){
						str = String.valueOf(i)+"00"+String.valueOf(j);
					}else if(j>=10&& j<100){
						str = String.valueOf(i)+"0"+String.valueOf(j);
					}else{
						str = String.valueOf(i)+String.valueOf(j);
					}
					HttpPost httpPost = new HttpPost("https://www.cjcp.com.cn/ajax_kj.php?jsoncallback=jsonp16318292&dlt_qs="+str);
					CloseableHttpResponse response = client.execute(httpPost);
					HttpEntity entity = response.getEntity();
					String result = EntityUtils.toString(entity,"UTF-8");
					response.close();
//					client.close();
					String[] tempStr = null;
					if(!StringUtils.isEmpty(result)){
						tempStr = result.split("\\*");
					}
					System.out.println("result:"+result);
					if(tempStr != null && tempStr.length > 10){
						String data = str+","+tempStr[4]+","+tempStr[5]+","+tempStr[6]+","+tempStr[7]+","+tempStr[8]+","+tempStr[9]+","+tempStr[10]+"\n";
//						out.write(data.getBytes());
					}
				}
			}
		}catch (Exception e){
			System.out.println("异常："+e);
		}
	}
}