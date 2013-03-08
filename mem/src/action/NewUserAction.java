package action;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entity.Userinfo;
import service.Userinfo_Service;

import com.opensymphony.xwork2.ActionSupport;;

public class NewUserAction extends ActionSupport {
	private static final Log log = LogFactory.getLog(NewUserAction.class);
	private Userinfo userinfo;
	private Userinfo_Service userinfo_service;
	/**
	 * 接收表单的输入信息
	 * @return
	 */
	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	/**
	 * spring注入userinfo_service
	 * @param userinfo_service
	 */
	public void setUserinfo_service(Userinfo_Service userinfo_service) {
		this.userinfo_service = userinfo_service;
	}

	@Override
	public String execute() throws Exception {
		boolean b = userinfo_service.NewUser(userinfo);
		//输出信息，用来测试
		log.info("username="+userinfo.getUsername());
		if(b){
			return "success";
		}
		return "fail";
	}

}
