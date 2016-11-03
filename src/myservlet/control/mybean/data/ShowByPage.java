package myservlet.control.mybean.data;
import com.sun.rowset.*;
public class ShowByPage {
CachedRowSetImpl rowset=null;
int pagesize=10;
int pageallcount=0;
int showpage=1;//当前页数
int nowpage=0;//当前页显示条数
int number=0;//记录条数
StringBuffer presentpageresult;
String backnews;
Boolean suc;
public void setNumber(int newnumber){
	number=newnumber;
}
public int getNumber(){
	return number;
}
public void qiuNowpage(){
	int l=number-pagesize*(showpage-1);
	if(l<=10)nowpage=l;
		else{
			nowpage=10;
		}
}
public void setNowpage(int newnowpage){
	nowpage=newnowpage;
}
public int getNowpage(){
	return nowpage;
}
public void setPresentpageresult(StringBuffer newpresentpageresult){
	presentpageresult=newpresentpageresult;
}
public StringBuffer getPresentpageresult(){
	return presentpageresult;
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
