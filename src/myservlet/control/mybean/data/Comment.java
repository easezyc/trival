package myservlet.control.mybean.data;

public class Comment {
String comment,name,backnews="",introduction,province;
double score;
StringBuffer result;
int number;
boolean ok=false;
public void setOk(boolean newok){
	ok=newok;
}
public boolean getOk(){
	return ok;
}
public void setProvince(String newprovince){
	province=newprovince;
}
public String getProvince(){
	return province;
}
public void setComment(String newcomment){
	comment=newcomment;
}
public String getComment(){
	return comment;
}
public void setName(String newname){
	name=newname;
}
public String getName(){
	return name;
}
public void setScore(double newscore){
	score=newscore;
}
public double getScore(){
	return score;
}
public void setBacknews(String newbacknews){
	backnews=newbacknews;
}
public String getBacknews(){
	return backnews;
}
public void setIntroduction(String newintroduction){
	introduction=newintroduction;
}
public String getIntroduction(){
	return introduction;
}
public void setResult(StringBuffer newresult){
	result=newresult;
}
public StringBuffer getResult(){
	return result;
}
public void setNumber(int newnumber){
	number=newnumber;
}
public int getNumber(){
	return number;
}
}
