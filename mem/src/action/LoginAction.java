package action;

import entity.Admi;
import service.Admi_Service;

import com.opensymphony.xwork2.ActionSupport;;

public class LoginAction extends ActionSupport {	
	private Admi admi;
	private Admi_Service admi_service;
	/**
	 * 接收表单的输入信息
	 * @return
	 */
	public Admi getAdmi() {
		return admi;
	}
	public void setAdmi(Admi admi) {
		this.admi = admi;
	}
	/**
	 * spring自动注入admi_service
	 * @param admi_service
	 */
	public void setAdmi_service(Admi_Service admi_service) {
		this.admi_service = admi_service;
	}
	
	@Override
	public String execute() throws Exception {
		Admi t = admi_service.doLogin(admi);
		if(null!=t){
			return "success";
		}
		return "fail";
	}

}
