package www.zzz.seal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.zzz.dao.DaGou;
import www.zzz.dao.Login;
import www.zzz.tuil.JdbcUtil;

public class Qdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public Login login(String name, String pwd) {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		Login ln = null;
		try {
			ps = conn.prepareStatement("select * from denglu where name=? and pwd=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				ln = new Login();
				ln.setName(rs.getString("name"));
				ln.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ln;
	}
	public List<DaGou> list() {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		List<DaGou> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select * from dagou");
			rs = ps.executeQuery();
			while(rs.next()){
				DaGou dg = new DaGou();
				dg.setId(rs.getInt("id"));
				dg.setName(rs.getString("name"));
				dg.setPwd(rs.getString("pwd"));
				dg.setSex(rs.getString("sex"));
				dg.setHobby(rs.getString("hobby"));
				dg.setBir(rs.getString("bir"));
				list.add(dg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public DaGou toupdate(String id) {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		DaGou dg = null;
		try {
			ps = conn.prepareStatement("select * from dagou where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				dg = new DaGou();
				dg.setId(rs.getInt("id"));
				dg.setName(rs.getString("name"));
				dg.setPwd(rs.getString("pwd"));
				dg.setSex(rs.getString("sex"));
				dg.setHobby(rs.getString("hobby"));
				dg.setBir(rs.getString("bir"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dg;
	}
	public int update(String id, String name, String pwd, String sex, String hobby, String bir) {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		int i = 0;
		try {
			ps = conn.prepareStatement("update dagou set name=?,pwd=?,sex=?,hobby=?,bir=? where id=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.setString(3, sex);
			ps.setString(4, hobby);
			ps.setString(5, bir);
			ps.setString(6, id);
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int del(String id) {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		int i = 0;
		try {
			ps = conn.prepareStatement("delete from dagou where id in("+id+")");
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int insert(String name, String pwd, String sex, String hobby, String bir) {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		int i = 0;
		try {
			ps = conn.prepareStatement("insert into dagou VALUES(0,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.setString(3, sex);
			ps.setString(4, hobby);
			ps.setString(5, bir);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
