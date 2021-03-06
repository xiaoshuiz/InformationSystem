package action;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

import dao.InfoDao;

import entity.Info;

public class InfoAction {

	private Info info;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	public String save() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		// request
		HttpServletResponse response = ServletActionContext.getResponse();
		// response
		ServletContext application = ServletActionContext.getServletContext();
		// application
		Map session = ActionContext.getContext().getSession();
		// session

		InfoDao infoDao = new InfoDao();
		info.setTime(new Timestamp(System.currentTimeMillis()));
		int result = infoDao.save(info);
		System.out.println("LoginAction execute");
		if (result==1) {
			return "success";
		}
		return "success";
	}
}
