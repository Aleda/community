package cn.aleda.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.aleda.hibernate.dao.interfaces.PhotoDAO;
import cn.aleda.hibernate.entity.Photo;

public class PhotoDAOImpl extends DAOSupport implements PhotoDAO {
   // private HibernateTemplate hibernateTemplate;
	public PhotoDAOImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	public void save(Photo photo) {
		hibernateTemplate.saveOrUpdate(photo);
	}

	public void delete(Photo photo) {
		hibernateTemplate.delete(photo);
	}

	public List<Photo> load(String username) {
		String hql = "from Photo where user_name = ?";
		List<Photo> photos = hibernateTemplate.find(hql, username);
		return photos;
	}

	public Photo loadPhotoByName(String photoName, String username) {
		String hql = "from Photo where photo_name = ? and user_name = ?";
		Object[] args = {photoName, username};
		List<Photo> photos = hibernateTemplate.find(hql, args);
		return photos.get(0);
	}
}
