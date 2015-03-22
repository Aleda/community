package cn.aleda.struts2.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Photo;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.PhotoService;

import com.opensymphony.xwork2.ActionSupport;

public class DeletePhotosAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;
	private String photosName;
	private ServiceManager serviceManager;
	
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String utf8 = new String(photosName.getBytes("iso-8859-1"), "utf-8");
		System.out.println("uft8 = " + utf8);
		String[] names = utf8.split(", ");
		PhotoService service = serviceManager.getPhotoService();
		Photo photo;
		for (String filename: names) {
			System.out.println("filename = " + filename);
			photo = service.loadPhotoByName(filename, username);
			FileUtils.forceDelete(new File(photo.getSmall_path()));
			FileUtils.forceDelete(new File(photo.getBig_path()));
			service.deletePhoto(photo);
			System.out.println("deleted photos!!!~~~");
		}
		return SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getPhotosName() {
		return photosName;
	}

	public void setPhotosName(String photosName) {
		this.photosName = photosName;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
}
