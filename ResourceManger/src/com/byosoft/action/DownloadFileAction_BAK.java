package com.byosoft.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.byosoft.util.downloadUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadFileAction_BAK extends ActionSupport {
	private String alias;
	private String path;
	private String filename;
	private String savepath;
	private String ftpusername;
	private String ftppassword;
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public String getFtpusername() {
		return ftpusername;
	}

	public void setFtpusername(String ftpusername) {
		this.ftpusername = ftpusername;
	}

	public String getFtppassword() {
		return ftppassword;
	}

	public void setFtppassword(String ftppassword) {
		this.ftppassword = ftppassword;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String url = "192.168.6.10";
		int port = 21;
		String username = this.getFtpusername();
		String password = this.getFtppassword();
		String remotePath = this.getPath();
		String fileName = this.getFilename();
		String localPath = this.getSavepath();
		
		Map session =ActionContext.getContext().getSession();
		if(session.get("ftpusername")==null)
		{
			session.put("ftpusername", username);
		}
		if(session.get("ftppassword")==null)
		{
			session.put("ftppassword", password);
		}
		if(session.get("savepath")==null)
		{
			session.put("savepath", localPath);
		}
		if(session.get("savepath")!=null&&session.get("savepath")!=this.getSavepath())
		{
			session.put("savepath", this.getSavepath());
		}
		
		System.out.println("url="+url);
		System.out.println("port="+port);
		System.out.println("username="+username);
		System.out.println("password="+password);
		System.out.println("remotePath="+remotePath);
		System.out.println("fileName="+fileName);
		System.out.println("localPath="+localPath);
		
		if(downloadUtil.downFile(url, port, username, password, remotePath, fileName, localPath))
		{
			System.out.println("downFile success");
			return this.SUCCESS;
		}
		else
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("url", "toollist.jsp");
			request.setAttribute("info", "<h2>操			作		 失 		败！</h2><br> "
					+ "<font style='color:red'>请检查FTP用户名和FTP密码是否正确</font><br>"
					+ "<font style='color:red'>请检查保存路径是否正确</font><br>"
					+ "<font style='color:red'>请检查保存路径是否存在</font><br>"
					+ "<font style='color:red'>正在跳转....</font>");
			return this.ERROR;
		}
	}
	
}
