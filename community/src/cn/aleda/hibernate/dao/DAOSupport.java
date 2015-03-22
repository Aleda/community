package cn.aleda.hibernate.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class DAOSupport {
	protected HibernateTemplate hibernateTemplate; //这里一定是protected，使得继承类可以继承hibernateTemplate；

	public DAOSupport(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
