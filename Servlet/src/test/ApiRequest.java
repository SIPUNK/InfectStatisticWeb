package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;



public class ApiRequest {
	
    public static String result(String info) {
    	//�ӿڵ�ַ
    	String requestUrl = "http://wuliang.art/ncov/statistics/getProvinceHistoryList";  
    	//params���ڴ洢Ҫ����Ĳ���
        Map params = new HashMap();
        //showapi_appid��ֵ����###�滻�����appid
        params.put("provinceName",info);
        //����httpRequest���������������Ҫ���������ַ���������������
        String string = httpRequest(requestUrl,params);
        System.out.println(string);
        //�����ص�JSON���ݲ�����
        JSONObject pageBean = JSONObject.parseObject(string);
    	return pageBean.getString("date");
    }
    
    private static String httpRequest(String requestUrl,Map params) {  
    	//buffer���ڽ��ܷ��ص��ַ�
    	StringBuffer buffer = new StringBuffer();
        try {  
        	//����URL���������ַ����ȫ������urlencode�����������ڰ�params��Ĳ�����ȡ����
            URL url = new URL(requestUrl+"?"+urlencode(params));  
            //��http����
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.connect();  
            
            //�������
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            //��bufferReader��ֵ���ŵ�buffer��
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            //�ر�bufferReader��������
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            inputStream = null;  
            //�Ͽ�����
            httpUrlConn.disconnect();
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        	//�����ַ���
        return buffer.toString();  
    }  
    
    public static String urlencode(Map<String,Object>data) {
    	//��map��Ĳ�������� showapi_appid=###&showapi_sign=###&������
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    //�����Ƿ���Ч
	public static void main(String[] args) {
	
		System.out.println(result("����"));
	}
 
}