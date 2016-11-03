package myservlet.control.mybean.data;

public class routinecomment {
StringBuffer article,result;
String uri,backnews,comment;
boolean ok=false;
double score;
int number;
public void setOk(boolean newok){
	ok=newok;
}
public boolean getOk(){
	return ok;
}
public void setNumber(int newnumber){
	number=newnumber;
}
public int getNumber(){
	return number;
}
public void setScore(double newscore){
	score=newscore;
}
public double getScore(){
	return score;
}
public void setUri(String newuri){
	uri=newuri;
}
public String getUri(){
	return uri;
}
public void setArticle(StringBuffer newarticle){
	article=newarticle;
}
public StringBuffer getArticle(){
	return article;
}
public void setBacknews(String newbacknews){
	backnews=newbacknews;
}
public String getBacknews(){
	return backnews;
}
public void setComment(String newcomment){
	comment=newcomment;
}
public String getComment(){
	return comment;
}
public void setResult(StringBuffer newresult){
	result=newresult;
}
public StringBuffer getResult(){
	return result;
}
}
