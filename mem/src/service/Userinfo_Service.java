package service;

import dao.All_DAO;
import entity.Userinfo;
/**
 * �û�ҵ��ʵ����
 * @author Administrator
 *
 */
public class Userinfo_Service {
	private All_DAO all_dao;
	/**
	 * ͨ��spring��������ע��
	 * @param all_dao
	 */
	public void setAll_dao(All_DAO all_dao){
		this.all_dao=all_dao;
	}
	/**
	 * �����û�ע��
	 */
	public boolean NewUser(Userinfo userinfo) {
		/**
		 * ע��ɹ�����true�����򷵻�false
		 */
		return all_dao.getUserinfo_dao().newUser(userinfo);
	}
}
