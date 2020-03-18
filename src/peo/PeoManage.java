package peo;
//学生信息管理系统的菜单选择
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor.INPUT_STREAM;
import org.omg.CORBA.PUBLIC_MEMBER;
import peodao.PeoDao;

public class PeoManage {
	
	
	
    private static final String String = null;

	public void  menu() throws SQLException {
        //1.打印菜单
        //2.输入菜单
        //3.switch菜单选择
        int choose;
        do {
            System.out.println("******************************");
            System.out.println("=======欢迎进入疫情信息管理系统=======");
            System.out.println("1.新增信息");
            System.out.println("2.修改信息");
            System.out.println("3.删除信息");
            System.out.println("4.查询信息");
            System.out.println("5.按时间查");
            System.out.println("6.按地址查");
            System.out.println("7.查确诊");
            System.out.println("8.查疑似");
            System.out.println("9.退出该系统");
            System.out.println("请选择（1-9）：");
            
            Scanner scanner=new Scanner(System.in);
            choose=scanner.nextInt();
            System.out.println("******************************");
            switch (choose) {
            case 1:
                myAdd(); //菜单选择1，是新增学生
                break;
            case 2:
                myUpdate();  //菜单选择2，是修改学生
                break;
            case 3:
                myDel();  //菜单选择3，是删除学生
                break;
            case 4:
                myList();  //菜单选择4，是查询学生
                break;
                
            case 5:
            	findday();//菜单选择5，按时间
            	break;
            case 6:
            	findaddress();//菜单选择6，按地址
            	break;
            case 7:
            	findconfirm();//菜单选择7，查确诊
            	break;
            case 8:
            	findsuspect();//菜单选择8，查疑似
            	break;
            case 9:     //菜单选择9，是退出该系统
                System.out.println("您选择了退出系统，确定要退出吗？(y/n)");
                Scanner scan=new Scanner(System.in);
                String scanExit=scan.next();
                if(scanExit.equals("y")){
                System.exit(-1);
                System.out.println("您已成功退出系统，欢迎您再次使用！");
                }
                break;
            default:
                break;
            }
        } while (choose!=5);
    }
    
    //新增学生信息
    public void myAdd() {
        
        String continute;
        do {
            Scanner s=new Scanner(System.in);
            String id,name,sex,college,address,suspect,confirm,contact,time;
            System.out.println("====新增信息====");
            System.out.println("学号：");
            id=s.next();
            System.out.println("姓名：");
            name=s.next();
            System.out.println("性别：");
            sex=s.next();
            System.out.println("学院：");
            college=s.next();
            System.out.println("地址：");
            address=s.next();
            System.out.println("是否疑似：");
            suspect=s.next();
            System.out.println("是否确诊：");
            confirm=s.next();
            System.out.println("是否与患者接触：");
            contact=s.next();
            System.out.println("日期：");
            time=s.next();
            
            Peo peo=new Peo(id,name,sex,college,address,suspect,confirm,contact,time);
            PeoDao dao=new PeoDao();
            boolean ok=dao.add(peo);
            if (ok) {
                System.out.println("保存成功！");
            }else {
                System.out.println("保存失败！");
            }
            System.out.println("是否继续添加(y/n)：");
            Scanner scanner2=new Scanner(System.in);
            continute=scanner2.next();
        } while (continute.equals("y"));
    }
    
    //删除学生信息
    public void myDel() throws SQLException{
        Scanner s=new Scanner(System.in);
        String id;
        System.out.println("====删除信息====");
        System.out.println("请输入要删除的学生学号：");
        id=s.next();
        System.out.println("该学生的信息如下：");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("学生学号："+peoDao.findSomeone(id).getId());
        System.out.println("学生姓名："+peoDao.findSomeone(id).getName());
        System.out.println("学生性别："+peoDao.findSomeone(id).getSex());
        System.out.println("所在学院："+peoDao.findSomeone(id).getCollege());
        System.out.println("居住地："+peoDao.findSomeone(id).getAddress());
        System.out.println("是否疑似："+peoDao.findSomeone(id).getSuspect());
        System.out.println("是否确诊："+peoDao.findSomeone(id).getConfirm());
        System.out.println("是否与患者接触："+peoDao.findSomeone(id).getContact());
        System.out.println("日期："+peoDao.findSomeone(id).getTime());
        
        System.out.println("是否真的删除(y/n)：");
        Scanner scanner3=new Scanner(System.in);
        String x=scanner3.next();
        if (x.equals("y")) {
        	Peo peo=new Peo(id,null,null,null,null,null,null,null,null);
            PeoDao dao=new PeoDao();
            boolean ok=dao.del(id);
            if (ok) {
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }
        }
    }
    //修改学生信息
    public void myUpdate() throws SQLException{
        Scanner s=new Scanner(System.in);
        String id;
        System.out.println("====修改信息====");
        System.out.println("请输入要修改的学生学号：");
        id=s.next();
        System.out.println("该学生的信息如下：");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("学生学号："+peoDao.findSomeone(id).getId());
        System.out.println("学生姓名："+peoDao.findSomeone(id).getName());
        System.out.println("学生性别："+peoDao.findSomeone(id).getSex());
        System.out.println("所在学院："+peoDao.findSomeone(id).getCollege());
        System.out.println("居住地："+peoDao.findSomeone(id).getAddress());
        System.out.println("是否疑似："+peoDao.findSomeone(id).getSuspect());
        System.out.println("是否确诊："+peoDao.findSomeone(id).getConfirm());
        System.out.println("是否与患者接触："+peoDao.findSomeone(id).getContact());
        System.out.println("日期："+peoDao.findSomeone(id).getTime());
        
        System.out.println("请输入新的学生信息：");
        
        Scanner peoUp=new Scanner(System.in);
        
        String name,sex,college,address,suspect,confirm,contact,time;
        System.out.println("学号：");
        id=s.next();
        System.out.println("姓名：");
        name=s.next();
        System.out.println("性别：");
        sex=s.next();
        System.out.println("学院：");
        college=s.next();
        System.out.println("地址：");
        address=s.next();
        System.out.println("是否疑似：");
        suspect=s.next();
        System.out.println("是否确诊：");
        confirm=s.next();
        System.out.println("是否与患者接触：");
        contact=s.next();
        System.out.println("日期：");
        time=s.next();
        
        Peo peo=new Peo(id,name,sex,college,address,suspect,confirm,contact,time);
        
        PeoDao dao=new PeoDao();
        boolean ok=dao.update(peo);
        if (ok) {
            System.out.println("保存成功！");
        }else {
            System.out.println("保存失败！");
        }
    }
    //查询学生信息
    public void myList() throws SQLException{
    	Connection conn =DBUtil.getConn();
        System.out.println("************************");
        System.out.println("====查询学生====");
        System.out.println("该学生的信息如下：");
        System.out.println("学号\t姓名\t性别\t学院\t地址\t是否疑似\t是否确诊\t是否与患者接触\t日期");
        PeoDao peoDao=new PeoDao();
        List<Peo> list=peoDao.list();
        for (Peo peoList:list) { //循环打印出查询结果
            System.out.println(peoList.getId()+"\t"+peoList.getName()+"\t"+peoList.getSex()+"\t"
            		+peoList.getCollege()+"\t"+peoList.getAddress()+"\t"+peoList.getSuspect()+"\t"
             		+peoList.getConfirm()+"\t"+peoList.getContact()+"\t\t"+peoList.getTime());
        }
        
        System.out.println("************************");
    }
    
    
    
    
  //按时间
	public void findday() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String time;
        System.out.println("====按日期查询====");
        System.out.println("请输入要查询的日期：");
        time=s.next();
        System.out.println("该日情况如下：");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("学生学号："+peoDao.finddate(time).getId());
        System.out.println("学生姓名："+peoDao.finddate(time).getName());
        System.out.println("学生性别："+peoDao.finddate(time).getSex());
        System.out.println("所在学院："+peoDao.finddate(time).getCollege());
        System.out.println("居住地："+peoDao.finddate(time).getAddress());
        System.out.println("是否疑似："+peoDao.finddate(time).getSuspect());
        System.out.println("是否确诊："+peoDao.finddate(time).getConfirm());
        System.out.println("是否与患者接触："+peoDao.finddate(time).getContact());
        System.out.println("日期："+peoDao.finddate(time).getTime());
	}
        /*List<Peo> list=peoDao.list1(toString(time));
        for (Peo peoList:list) { //循环打印出查询结果
            System.out.println(peoList.getId()+"\t"+peoList.getName()+"\t"+peoList.getSex()+"\t"
            		+peoList.getCollege()+"\t"+peoList.getAddress()+"\t"+peoList.getSuspect()+"\t"
             		+peoList.getConfirm()+"\t"+peoList.getContact()+"\t\t"+peoList.getTime());*/
	//按地址
	public void findaddress() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String address;
        System.out.println("====按地址查询====");
        System.out.println("请输入要查询的地址：");
        address=s.next();
        System.out.println("该地址情况如下：");
        
        PeoDao peoDao=new PeoDao();
        System.out.println("学生学号："+peoDao.findaddress(address).getId());
        System.out.println("学生姓名："+peoDao.findaddress(address).getName());
        System.out.println("学生性别："+peoDao.findaddress(address).getSex());
        System.out.println("所在学院："+peoDao.findaddress(address).getCollege());
        System.out.println("居住地："+peoDao.findaddress(address).getAddress());
        System.out.println("是否疑似："+peoDao.findaddress(address).getSuspect());
        System.out.println("是否确诊："+peoDao.findaddress(address).getConfirm());
        System.out.println("是否与患者接触："+peoDao.findaddress(address).getContact());
        System.out.println("日期："+peoDao.findaddress(address).getTime());
	}
        
  
	
	
	private String toString(String time) {
	// TODO Auto-generated method stub
	return null;
}

	//是否确诊
	public void findconfirm() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String confirm;
        System.out.println("====按确诊查询====");
        System.out.println("请输入要查询的情况：");
        confirm=s.next();
        System.out.println("该情况如下：");
        
        PeoDao peoDao=new PeoDao();
        
        System.out.println("学生学号："+peoDao.findconfirm(confirm).getId());
        System.out.println("学生姓名："+peoDao.findconfirm(confirm).getName());
        System.out.println("学生性别："+peoDao.findconfirm(confirm).getSex());
        System.out.println("所在学院："+peoDao.findconfirm(confirm).getCollege());
        System.out.println("居住地："+peoDao.findconfirm(confirm).getAddress());
        System.out.println("是否疑似："+peoDao.findconfirm(confirm).getSuspect());
        System.out.println("是否确诊："+peoDao.findconfirm(confirm).getConfirm());
        System.out.println("是否与患者接触："+peoDao.findconfirm(confirm).getContact());
        System.out.println("日期："+peoDao.findconfirm(confirm).getTime());
  
	}
	
	//是否疑似
	public void findsuspect() throws SQLException{
		Connection conn =DBUtil.getConn();
		System.out.println("************************");
		Scanner s=new Scanner(System.in);
        String suspect;
        System.out.println("====按疑似查询====");
        System.out.println("请输入要查询的情况：");
        suspect=s.next();
        System.out.println("该情况如下：");
        
        PeoDao peoDao=new PeoDao();
        
        System.out.println("学生学号："+peoDao.findsuspect(suspect).getId());
        System.out.println("学生姓名："+peoDao.findsuspect(suspect).getName());
        System.out.println("学生性别："+peoDao.findsuspect(suspect).getSex());
        System.out.println("所在学院："+peoDao.findsuspect(suspect).getCollege());
        System.out.println("居住地："+peoDao.findsuspect(suspect).getAddress());
        System.out.println("是否疑似："+peoDao.findsuspect(suspect).getSuspect());
        System.out.println("是否确诊："+peoDao.findsuspect(suspect).getConfirm());
        System.out.println("是否与患者接触："+peoDao.findsuspect(suspect).getContact());
        System.out.println("日期："+peoDao.findsuspect(suspect).getTime());
  
	}
}