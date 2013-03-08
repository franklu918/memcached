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
	 * �����û�ע��
	 * @return 
	*/ 	
	public boolean newUser(Userinfo userinfo) {
		List<Userinfo> list = this.findByUsername(userinfo.getUsername());
		log.info("list="+list.size());
		if(list.size()>0){
			log.info("�û��Ѵ��ڣ�");			
			return false;
		}
		/*try{
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(userinfo);
			transaction.commit();
			session.flush();
			session.close();
			log.info("ע��ɹ���");
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
	 * ��
	 */
	public void save(Userinfo userinfo) {
			getHibernateTemplate().save(userinfo);
	}
	/**
	 * ɾ
	 * @param userinfo
	 */
	public void delete(Userinfo userinfo) {
			getHibernateTemplate().delete(userinfo);			
	}	
	/**
	 * ��
	 * @param userinfo
	 */
	public void attachDirty(Userinfo userinfo) {
			getHibernateTemplate().saveOrUpdate(userinfo);		
	}
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Userinfo> findAllUserinfo() {		
		String queryString = "from Userinfo";
		return this.getHibernateTemplate().find(queryString);
	}
	/**
	 * �������Բ�ѯ
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<Userinfo> findByProperty(String propertyName, Object value) {
			String queryString = "from Userinfo as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
	}	
	/**
	 * ͨ���û�������
	 * @param username
	 * @return
	 */
	public List<Userinfo> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}
}
