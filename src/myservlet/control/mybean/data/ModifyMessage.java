package myservlet.control.mybean.data;

public class ModifyMessage {
	String logname,newemail,newphone,backnews;
	public void setLogname(String name){
		logname=name;
	}
	public String getLogname(){
		return logname;
	}
	public void setNewemail(String em){
		newemail=em;
	}
	public String getNewemail(){
		return newemail;
	}
	public void setNewphone(String ph){
		newphone=ph;
	}
	public String getNewphone(){
		return newphone;
	}
	public String getBacknews(){
		return backnews;
	}
	public void setBacknews(String bn){
		backnews=bn;
	}
}
