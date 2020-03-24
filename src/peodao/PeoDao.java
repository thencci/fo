package peodao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import peo.DBUtil;
import peo.Peo;

public class PeoDao {
    private Connection conn;//连接
    private PreparedStatement pstmt;//模板
    private ResultSet rs;//结果
    
  //查看学生列表（1所有）
    public List<Peo> list() throws SQLException {
           List<Peo> list=new ArrayList<Peo>();//是线性列表，ArrayList是
       
           String sql="select * from yiqing";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
    //pstmt.executeUpdate();//用于增删改
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                Peo peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
                
                list.add(peo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        	conn.close();
        	pstmt.close();
        	rs.close();
            //DBUtil.close(conn, pstmt, rs);
        }
        return list;
    }
    
  //添加学生信息
    public boolean add(Peo peo) {
           String sql="insert into yiqing(id,name,sex,college,address,suspect,confirm,contact,time) values(?,?,?,?,?,?,?,?,?)";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, peo.getId());
            pstmt.setString(2, peo.getName());
            pstmt.setString(3, peo.getSex());
            pstmt.setString(4, peo.getCollege());
            pstmt.setString(5, peo.getAddress());
            pstmt.setString(6, peo.getSuspect());
            pstmt.setString(7, peo.getConfirm());
            pstmt.setString(8, peo.getContact());
            pstmt.setString(9, peo.getTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return true;
    }
    //修改学生信息
    public boolean update(Peo peo) {
           String sql="update yiqing set name=?,sex=?,college=?,address=?,suspect=?,confirm=?,contact=?,time=? where id=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, peo.getId());
            pstmt.setString(2, peo.getName());
            pstmt.setString(3, peo.getSex());
            pstmt.setString(4, peo.getCollege());
            pstmt.setString(5, peo.getAddress());
            pstmt.setString(6, peo.getSuspect());
            pstmt.setString(7, peo.getConfirm());
            pstmt.setString(8, peo.getContact());
            pstmt.setString(9, peo.getTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return true;
       }
  //删除学生信息
    public boolean del(String id) throws SQLException {
           String sql="delete from yiqing where id=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return true;
       }
    
	//查看列表   按学号   1
    public Peo findSomeone(String id) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where id=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1,id);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        }  catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    
   /* public void findday(){
    	System.out.println("输入时间：");
    	Scanner s=new Scanner(System.in);
    	String date = s.next();
    	//showMessage(finddate(date));
    	System.out.println("在"+date+"参与统计的人数\n");
    	//showNum(selectDate(date));
    }*/ 
    
  //刚改的按时间查询
    public List<Peo> list1(String time) throws SQLException {
           List<Peo> list1=new ArrayList<Peo>();//是线性列表，ArrayList是
           String sql="select * from yiqing where time=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,time);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                Peo peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
                Peo Peo = new Peo();
                list1.add(peo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
        	conn.close();
        	pstmt.close();
        	rs.close();
        }
        return list1;
    }
    //按时间
  //查看列表  2
    public Peo finddate(String time) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where time=?";
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,time);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }

  //查看列表   按学院  3
    public Peo findcollege(String college) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where college=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1,college);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //查看列表   按姓名  4
    public Peo findname(String name) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where name=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1,name);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //查看列表   是否感染   5
    public Peo findconfirm(String confirm) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where confirm=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1,confirm);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //查看列表   疑似  6
    public Peo findsuspect(String suspect) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where suspect=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1,suspect);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
    //查看列表   是否接触
    public Peo findcontact(String contact) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where contact=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1,contact);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
  //查看列表   按学院  3
    public Peo findaddress(String address) throws SQLException {
           Peo peo=null;
           String sql="select * from yiqing where address=?";
        
        try {
            conn=DBUtil.getConn();
            pstmt=conn.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1,address);
            rs=pstmt.executeQuery();//用于查询
            while (rs.next()) {
                peo=new Peo();
                peo.setId(rs.getString("id"));//取结果集里面学号这一列的值赋给
                peo.setName(rs.getString("name"));
                peo.setSex(rs.getString("sex"));
                peo.setCollege(rs.getString("college"));
                peo.setAddress(rs.getString("address"));
                peo.setSuspect(rs.getString("suspect"));
                peo.setConfirm(rs.getString("confirm"));
                peo.setContact(rs.getString("contact"));
                peo.setTime(rs.getString("time"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		} 
        pstmt.close();
		conn.close(); 
        return peo;
    }
    
}

