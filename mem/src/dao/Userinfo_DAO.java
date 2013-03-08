package dao;

import java.util.List;

import entity.Userinfo;

import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.apache.commons.logging.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Userinfo_DAO extends HibernateDaoSupport{
	private static final Log log = LogFactory.getLog(Userinfo_DAO.class);
	public static final String USERNAME = "username";	
	/**
	 * 处理用户注册
	 * @return 
	*/ 	
	public boolean newUser(Userinfo userinfo) {
		List<Userinfo> list = this.findByUsername(userinfo.getUsername());
		log.info("list="+list.size());
		if(list.size()>0){
			log.info("用户已存在！");			
			return false;
		}
		/*try{
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(userinfo);
			transaction.commit();
			session.flush();
			session.close();
			log.info("注册成功！");
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		try {
			userinfo.setPassword("n");
			userinfo.setName("n");
			userinfo.setIdnumber("n");
			userinfo.setEmail("n");
			userinfo.setSex("n");
			userinfo.setTel("n");
			userinfo.setMac("n");
			userinfo.setCampus("n");
			userinfo.setBuild("n");
			userinfo.setRoom("n");
			userinfo.setDepartment("n");
			userinfo.setType("n");
			userinfo.setTypeid("n");
			userinfo.setIsverify("n");
			getHibernateTemplate().save(userinfo);
			getHibernateTemplate().flush();
			log.info("save successful");
		} catch (RuntimeException re) {
			log.info("save failed");
			throw re;
		}
		return true;
	}	
	/**
	 * 增
	 */
	public void save(Userinfo userinfo) {
			getHibernateTemplate().save(userinfo);
	}
	/**
	 * 删
	 * @param userinfo
	 */
	public void delete(Userinfo userinfo) {
			getHibernateTemplate().delete(userinfo);			
	}	
	/**
	 * 改
	 * @param userinfo
	 */
	public void attachDirty(Userinfo userinfo) {
			getHibernateTemplate().saveOrUpdate(userinfo);		
	}
	/**
	 * 查询所有
	 * @return
	 */
	public List<Userinfo> findAllUserinfo() {		
		String queryString = "from Userinfo";
		return this.getHibernateTemplate().find(queryString);
	}
	/**
	 * 根据属性查询
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<Userinfo> findByProperty(String propertyName, Object value) {
			String queryString = "from Userinfo as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
	}	
	/**
	 * 通过用户名查找
	 * @param username
	 * @return
	 */
	public List<Userinfo> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}
}
