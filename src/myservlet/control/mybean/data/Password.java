package myservlet.control.mybean.data;

public class Password {
String oldpassword,newpassword,backnews="";
public void setNewpassword(String password){
	newpassword=password;
}
public String getNewpassword(){
	return newpassword;
}
public void setOldpassword(String password){
	oldpassword=password;
}
public String getOldpassword(){
	return oldpassword;
}
public void setBacknews(String newbacknews){
	backnews=newbacknews;
}
public String getBacknews(){
	return backnews;
}
}
