package myservlet.control.mybean.data;

public class Login {
String name,password,mail,phone,backnews="";
boolean success=false;
public void setName(String newname){
	name=newname;
}
public String getName(){
	return name;
}
public void setPassword(String newpassword){
	password=newpassword;
}
public String getPassword(){
	return password;
}
public void setBacknews(String newbacknews){
	backnews=newbacknews;
}
public String getBacknews(){
	return backnews;
}
public void setSuccess(boolean b){
	success=b;
}
public boolean getSuccess(){
	return success;
}
public void setMail(String newmail){
	mail=newmail;
}
public String getMail(){
	return mail;
}
public void setPhone(String newphone){
	phone=newphone;
}
public String getPhone(){
	return phone;
}
}
