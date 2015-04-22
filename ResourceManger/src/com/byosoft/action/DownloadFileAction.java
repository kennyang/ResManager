package com.byosoft.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.struts2.ServletActionContext;

import com.byosoft.util.downloadUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadFileAction extends ActionSupport {
	private String alias;
	private String path;
	private String filename;
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
		String username = this.getFtpusername();
		String password = this.getFtppassword();
		String remotePath = this.getPath();
		String fileName = this.getFilename();
		
		Map session =ActionContext.getContext().getSession();
		if(session.get("ftpusername")==null)
		{
			session.put("ftpusername", username);
		}
		if(session.get("ftppassword")==null)
		{
			session.put("ftppassword", password);
		}
			
        HttpServletResponse response = ServletActionContext.getResponse();
        String path = "ftp://"+username+":"+password+"@"+url+"/"+remotePath+fileName;
        System.out.println(path);
        response.setHeader("Content-Disposition", "attachment; filename=\\"+fileName);  
        response.sendRedirect(path);	
        return this.SUCCESS;
		
/*		else
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("url", "toollist.jsp");
			request.setAttribute("info", "<h2>操			作		 失 		败！</h2><br> "
					+ "<font style='color:red'>请检查FTP用户名和FTP密码是否正确</font><br>"
					+ "<font style='color:red'>请检查保存路径是否正确</font><br>"
					+ "<font style='color:red'>请检查保存路径是否存在</font><br>"
					+ "<font style='color:red'>正在跳转....</font>");
			return this.ERROR;
		}*/
	}

/*	public boolean isLogin(String url,int port,String username,String password,String remotePath,String fileName, FTPClient ftp)
	{
		boolean success = false;        
        try {    
            int reply;    
            ftp.connect(url, port);    
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器     
            ftp.login(username, password);//登录     
            reply = ftp.getReplyCode();    
            if (!FTPReply.isPositiveCompletion(reply)) {    
                ftp.disconnect();    
                return success;    
            	} 
            success = true; 
            
            HttpServletResponse response = ServletActionContext.getResponse();
            String path = "ftp://"+username+":"+password+"@"+url+"/"+remotePath+fileName;
            System.out.println(path);
            response.sendRedirect(path);
            
            
            }catch (IOException e) {    
                e.printStackTrace();    
            } finally {    
                if (ftp.isConnected()) {    
                    try {    
                        ftp.disconnect();    
                    } catch (IOException ioe) {    
                   }    
                }    
            }
        return success; 
	}*/
	
}
