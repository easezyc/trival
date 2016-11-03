package myservlet.control.mybean.data;

public class Searchroutine {
StringBuffer name,introduce,routine,routinenumber,tablenumber,day;
String city,time;
public void setDay(StringBuffer newday){
	day=newday;
}
public StringBuffer getDay(){
	return day;
}
public void setTablenumber(StringBuffer newtablenumber){
	tablenumber=newtablenumber;
}
public StringBuffer getTablenumber(){
	return tablenumber;
}
public void setRoutinenumber(StringBuffer newroutinenumber){
	routinenumber=newroutinenumber;
}
public StringBuffer getRoutinenumber(){
	return routinenumber;
}
public void setCity(String newcity){
	city=newcity;
}
public String getCity(){
	return city;
}
public void setTime(String newtime){
	time=newtime;
}
public String getTime(){
	return time;
}
public void setRoutine(StringBuffer newroutine){
	routine=newroutine;
}
public StringBuffer getRoutine(){
	return routine;
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
