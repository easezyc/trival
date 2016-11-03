package myservlet.control.mybean.data;

public class ShowRoutine {
StringBuffer name,introduce,photouri,result;
String number,city,tablenumber,backnews;
Boolean ok;
int n,person;
double average;
public void setPerson(int newn){
	person=newn;
}
public int getPerson(){
	return person;
}
public void setAverage(double newaverage){
	average=newaverage;
}
public double getAverage(){
	return average;
}
public void setN(int newn){
	n=newn;
}
public int getN(){
	return n;
}
public void setOk(Boolean newok){
	ok=newok;
}
public Boolean getOk(){
	return ok;
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
public void setNumber(String newnumber){
	number=newnumber;
}
public String getNumber(){
	return number;
}
public void setCity(String newcity){
	city=newcity;
}
public String getCity(){
	return city;
}
public void setTablenumber(String newtablenumber){
	tablenumber=newtablenumber;
}
public String getTablenumber(){
	return tablenumber;
}
public void setPhotouri(StringBuffer newphotouri){
	photouri=newphotouri;
}
public StringBuffer getPhotouri(){
	return photouri;
}
public void setName(StringBuffer newname){
	name=newname;
}
public StringBuffer getName(){
	return name;
}
public void setIntroduce(StringBuffer newintroduce){
	introduce=newintroduce;
}
public StringBuffer getIntroduce(){
	return introduce;
}
}
