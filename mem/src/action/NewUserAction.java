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
	 * ���ձ���������Ϣ
	 * @return
	 */
	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	/**
	 * springע��userinfo_service
	 * @param userinfo_service
	 */
	public void setUserinfo_service(Userinfo_Service userinfo_service) {
		this.userinfo_service = userinfo_service;
	}

	@Override
	public String execute() throws Exception {
		boolean b = userinfo_service.NewUser(userinfo);
		//�����Ϣ����������
		log.info("username="+userinfo.getUsername());
		if(b){
			return "success";
		}
		return "fail";
	}

}
