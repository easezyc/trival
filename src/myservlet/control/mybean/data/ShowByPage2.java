package myservlet.control.mybean.data;
import com.sun.rowset.*;
public class ShowByPage2 {
CachedRowSetImpl rowset=null;
int pagesize=7;
int pageallcount=0;
int showpage=1;//当前页数
int nowpage=0;//当前页显示条数
int number=0;//记录条数
StringBuffer name,introduce,timemark;
String city,time;//city城市个数
String backnews;
Boolean suc;
public void setTimemark(StringBuffer newtimemark){
	timemark=newtimemark;
}

public StringBuffer getTimemark(){
	return timemark;
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
public void setNumber(int newnumber){
	number=newnumber;
}
public int getNumber(){
	return number;
}
public void qiuNowpage(){
	int l=number-pagesize*(showpage-1);
	if(l<=7)nowpage=l;
		else{
			nowpage=7;
		}
}
public void setNowpage(int newnowpage){
	nowpage=newnowpage;
}
public int getNowpage(){
	return nowpage;
}
public void setSuc(Boolean newsuc){
	suc=newsuc;
}
public Boolean getSuc(){
	return suc;
}
public void setBacknews(String newbacknews){
	backnews=newbacknews;
}
public String getBacknews(){
	return backnews;
}
public void setRowset(CachedRowSetImpl newrowset){
	rowset=newrowset;
}
public CachedRowSetImpl getRowset(){
	return rowset;
}
public void setPagesize(int newpagesize){
	pagesize=newpagesize;
}
public int getPagesize(){
	return pagesize;
}
public void setPageallcount(int newpageallcount){
	pageallcount=newpageallcount;
}
public int getPageallcount(){
	return pageallcount;
}
public void setShowpage(int newshowpage){
	showpage=newshowpage;
}
public int getShowpage(){
	return showpage;
}
}
