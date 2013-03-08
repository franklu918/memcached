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
	 * ʹ�� GET ��ʽ�ύ����
	 * @return
	 * @throws IOException 
	 * @throws HttpException 
	 */
 	private static void doGet(HttpClient client, String url) throws HttpException, IOException {
 		// ����������ֵ
 		String data = "?userinfo.username=nss14123456700"
			  		 +"&userinfo.password=0"
			  		 +"&userinfo.name=С��"
			  		 +"&userinfo.idnumber=410333199010010001"
			  		 +"&userinfo.email=123@126.com"
			  		 +"&userinfo.sex=��"
			  		 +"&userinfo.tel=13500000000"
			  		 +"&userinfo.mac=006E3A4F6902"
			  		 +"&userinfo.campus=����"
			  		 +"&userinfo.build=14��������Ԣ¥"	
			  		 +"&userinfo.room=111"
			  		 +"&userinfo.department=��Ϣ����ѧԺ"
			  		 +"&userinfo.type=ѧ��"
			  		 +"&userinfo.typeid=123456789"
			  		 +"&userinfo.isverify=���ͨ��"; 
 		data = new String(data.getBytes("ISO-8859-1"),"GB2312");
 		// ����GET������ʵ��
 		HttpMethod method = new GetMethod(url+data);
 		// ִ�з���
 		client.executeMethod(method);
        //������������ص�״̬
        log.info(method.getStatusLine());
        //������ص���Ϣ
        log.info(method.getResponseBodyAsString());
        //�ͷ�����
        method.releaseConnection();
 	}
	/**
 	 * ʹ��POST��ʽ�ύ����
 	 * @return
	 * @throws IOException 
	 * @throws HttpException 
 	 */    
	private static void doPost(HttpClient client, String url) throws HttpException, IOException {	
        // ������������ֵ
        NameValuePair[] data = {new NameValuePair("table1.username", "tom"),				
        						new NameValuePair("table1.password", "tomps")};       
        // ����POST������ʵ��
        HttpMethod method = new PostMethod(url);
        // ������ֵ����postMethod��
        method.setQueryString(data);
        // ִ�з���
        client.executeMethod(method);
        //������������ص�״̬
        log.info(method.getStatusLine());
        //������ص���Ϣ
        log.info(method.getResponseBodyAsString());
        //�ͷ�����
        method.releaseConnection();
	}
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient(); 
		String url = "http://localhost:8090/base2/NewUserAction";
		doGet(client, url);
		//doPost(client, url);  
	}
}
