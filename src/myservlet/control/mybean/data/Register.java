package myservlet.control.mybean.data;

public class Register {
String name="",password="",mail="",phone="";
String backnews;
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
public void setBacknews(String newbacknews){
	backnews=newbacknews;
}
public String getBacknews(){
	return backnews;
}
}
