package cn.aleda.hibernate.dao.interfaces;

import java.util.List;

import cn.aleda.hibernate.entity.Photo;

public interface PhotoDAO {
	public void save(Photo photo);
	public void delete(Photo photo);
	public List<Photo> load(String username);
	public Photo loadPhotoByName(String photoName, String username);
}
