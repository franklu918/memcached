package test;

import entity.Admi;
import service.Admi_Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Admi_Service admi_service = (Admi_Service)ctx.getBean("admi_service");
		for(Admi t:admi_service.getAdmi_all()){
			System.out.println(t.getUsername());
		}
	}

}
