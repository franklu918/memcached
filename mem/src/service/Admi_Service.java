package service;

import java.util.List;

import dao.All_DAO;
import dao.Admi_DAO;
import entity.Admi;

public class Admi_Service {
	private All_DAO all_dao;
	/**
	 * ͨ��spring��������ע��
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
	 * �����û���¼
	 */
	public Admi doLogin(Admi admi) {
		return this.all_dao.getAdmi_dao().login(admi);
	}
}
