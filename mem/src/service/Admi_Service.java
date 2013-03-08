package service;

import java.util.List;

import dao.All_DAO;
import dao.Admi_DAO;
import entity.Admi;

public class Admi_Service {
	private All_DAO all_dao;
	/**
	 * 通过spring进行依赖注入
	 * @param all_dao
	 */
	public void setAll_dao(All_DAO all_dao) {
		this.all_dao = all_dao;
	}
	public List<Admi> getAdmi_all(){
		return this.all_dao.getAdmi_dao().findAll();
	}
	public void saveAdmi(Admi admi) {
		this.all_dao.getAdmi_dao().save(admi);
	}
	/**
	 * 处理用户登录
	 */
	public Admi doLogin(Admi admi) {
		return this.all_dao.getAdmi_dao().login(admi);
	}
}
