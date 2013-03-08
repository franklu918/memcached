package service;

import dao.All_DAO;
import entity.Userinfo;
/**
 * 用户业务实现类
 * @author Administrator
 *
 */
public class Userinfo_Service {
	private All_DAO all_dao;
	/**
	 * 通过spring进行依赖注入
	 * @param all_dao
	 */
	public void setAll_dao(All_DAO all_dao){
		this.all_dao=all_dao;
	}
	/**
	 * 处理用户注册
	 */
	public boolean NewUser(Userinfo userinfo) {
		/**
		 * 注册成功返回true，否则返回false
		 */
		return all_dao.getUserinfo_dao().newUser(userinfo);
	}
}
