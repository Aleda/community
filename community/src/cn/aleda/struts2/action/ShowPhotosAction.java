package cn.aleda.struts2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Photo;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.PhotoService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowPhotosAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;
	private List<Photo> photos;
	private int size;
	private ServiceManager serviceManager;

	public String execute() throws Exception {
		PhotoService service = serviceManager.getPhotoService();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		photos = service.loadPhoto(username);
		size = photos.size();
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
