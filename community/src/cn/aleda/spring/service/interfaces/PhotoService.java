package cn.aleda.spring.service.interfaces;

import java.util.List;

import cn.aleda.hibernate.entity.Photo;

public interface PhotoService {
	public void addPhoto(Photo photo);
	public void deletePhoto(Photo photo);
	public List<Photo> loadPhoto(String username);
	public Photo loadPhotoByName(String photoName, String username);
}
