package test;

import java.io.IOException;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.Userinfo_DAO;

public class ApacheHttpClient {
	private static final Log log = LogFactory.getLog(Userinfo_DAO.class);
	/**
	 * 使用 GET 方式提交数据
	 * @return
	 * @throws IOException 
	 * @throws HttpException 
	 */
 	private static void doGet(HttpClient client, String url) throws HttpException, IOException {
 		// 各个参数的值
 		String data = "?userinfo.username=nss14123456700"
			  		 +"&userinfo.password=0"
			  		 +"&userinfo.name=小李"
			  		 +"&userinfo.idnumber=410333199010010001"
			  		 +"&userinfo.email=123@126.com"
			  		 +"&userinfo.sex=男"
			  		 +"&userinfo.tel=13500000000"
			  		 +"&userinfo.mac=006E3A4F6902"
			  		 +"&userinfo.campus=南区"
			  		 +"&userinfo.build=14号男生公寓楼"	
			  		 +"&userinfo.room=111"
			  		 +"&userinfo.department=信息工程学院"
			  		 +"&userinfo.type=学生"
			  		 +"&userinfo.typeid=123456789"
			  		 +"&userinfo.isverify=审核通过"; 
 		data = new String(data.getBytes("ISO-8859-1"),"GB2312");
 		// 创建GET方法的实例
 		HttpMethod method = new GetMethod(url+data);
 		// 执行方法
 		client.executeMethod(method);
        //输出服务器返回的状态
        log.info(method.getStatusLine());
        //输出返回的信息
        log.info(method.getResponseBodyAsString());
        //释放连接
        method.releaseConnection();
 	}
	/**
 	 * 使用POST方式提交数据
 	 * @return
	 * @throws IOException 
	 * @throws HttpException 
 	 */    
	private static void doPost(HttpClient client, String url) throws HttpException, IOException {	
        // 填入各个表单域的值
        NameValuePair[] data = {new NameValuePair("table1.username", "tom"),				
        						new NameValuePair("table1.password", "tomps")};       
        // 创建POST方法的实例
        HttpMethod method = new PostMethod(url);
        // 将表单的值放入postMethod中
        method.setQueryString(data);
        // 执行方法
        client.executeMethod(method);
        //输出服务器返回的状态
        log.info(method.getStatusLine());
        //输出返回的信息
        log.info(method.getResponseBodyAsString());
        //释放连接
        method.releaseConnection();
	}
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient(); 
		String url = "http://localhost:8090/base2/NewUserAction";
		doGet(client, url);
		//doPost(client, url);  
	}
}
