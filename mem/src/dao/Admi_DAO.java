package dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Admi;

/**
 * @author 
 */
public class Admi_DAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(Admi_DAO.class);
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	protected void initDao() {}
	/**
	 * 新增数据
	 * @param admi
	 */
	public void save(Admi admi) {
		log.debug("saving admi instance");
		try {
			getHibernateTemplate().save(admi);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * 删除数据
	 * @param admi
	 */
	public void delete(Admi admi) {
		log.debug("deleting admi instance");
		try {
			getHibernateTemplate().delete(admi);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public Admi findById(int id) {
		log.debug("getting admi instance with id: " + id);
		try {
			Admi admi = (Admi) getHibernateTemplate().get("dao.Admi",
					id);
			return admi;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 通过example查询
	 * @param admi
	 * @return
	 */
	public List findByExample(Admi admi) {
		log.debug("finding admi instance by example");
		try {
			List results = getHibernateTemplate().findByExample(admi);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	/**
	 * 通过属性名查询
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding admi instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admi as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 通过username查询
	 * @param username
	 * @return
	 */
	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}
	/**
	 * 查询所有
	 * @return
	 */
	public List findAll() {
		log.debug("finding all admi instances");
		try {
			String queryString = "from Admi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 归并
	 * @param admi
	 * @return
	 */
	public Admi merge(Admi admi) {
		log.debug("merging admi instance");
		try {
			Admi result = (Admi) getHibernateTemplate().merge(
					admi);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * 更新数据
	 * @param admi
	 */
	public void attachDirty(Admi admi) {
		log.debug("attaching dirty admi instance");
		try {
			getHibernateTemplate().saveOrUpdate(admi);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	/**
	 * 
	 * @param admi
	 */
	public void attachClean(Admi admi) {
		log.debug("attaching clean admi instance");
		try {
			getHibernateTemplate().lock(admi, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	/**
	 * 
	 * @param ctx
	 * @return
	 */
	public static Admi_DAO getFromApplicationContext(ApplicationContext ctx) {
		return (Admi_DAO) ctx.getBean("Admi_DAO");
	}
	/**
	 * 处理登录
	 */
	public Admi login(Admi admi) {
		//编写HQL语句
		String queryString = "from Admi t where t.username=?" + "and t.password=?";
		//进行查询，返回list
		try{
			List<Admi> list = this.getHibernateTemplate().find(queryString,
					new Object[]{
						admi.getUsername(),
						admi.getPassword()
					}
			);
			//如果list不为null返回第一个user，否则返回null
			if(list.size()>0){
				return list.get(0);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		return null;
	}
}