package cn.aleda.spring.service;

import java.util.List;

import cn.aleda.hibernate.dao.interfaces.PhotoDAO;
import cn.aleda.hibernate.entity.Photo;
import cn.aleda.spring.service.interfaces.PhotoService;

public class PhotoServiceImpl implements PhotoService {

	private PhotoDAO photoDAO;

	public PhotoServiceImpl(PhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}

	public void addPhoto(Photo photo) {
		photoDAO.save(photo);
	}

	public void deletePhoto(Photo photo) {
		photoDAO.delete(photo);
	}
	
	public List<Photo> loadPhoto(String username) {
		return photoDAO.load(username);
	}

	public Photo loadPhotoByName(String photoName, String username) {
		return photoDAO.loadPhotoByName(photoName, username);
	}
}
