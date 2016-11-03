package myservlet.control.mybean.data;

public class Scenicspot {
String backnews;
int number;
Boolean suc;
StringBuffer introduction,name,result;
public void setNumber(int newnumber){
	number=newnumber;
}
public int getNumber(){
	return number;
}
public void setIntroduction(StringBuffer newintroduction){
	introduction=newintroduction;
}
public StringBuffer getIntroduction(){
	return introduction;
}
public void setName(StringBuffer newname){
	name=newname;
}
public StringBuffer getName(){
	return name;
}
public void setBacknews(String newbacknews){
	backnews=newbacknews;
}
public String getBacknews(){
	return backnews;
}
public void setResult(StringBuffer newresult){
	result=newresult;
}
public StringBuffer getResult(){
	return result;
}
public void setSuc(Boolean newsuc){
	suc=newsuc;
}
public Boolean getSuc(){
	return suc;
}
}