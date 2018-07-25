package www.zzz.service;

import java.util.List;

import www.zzz.dao.DaGou;
import www.zzz.dao.Login;
import www.zzz.seal.Qdao;

public class Qservice {
	Qdao dao = new Qdao();
	public Login login(String name, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(name,pwd);
	}
	public List<DaGou> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	public DaGou toupdate(String id) {
		// TODO Auto-generated method stub
		return dao.toupdate(id);
	}
	public int update(String id, String name, String pwd, String sex, String hobby, String bir) {
		// TODO Auto-generated method stub
		return dao.update(id,name,pwd,sex,hobby,bir);
	}
	public int del(String id) {
		// TODO Auto-generated method stub
		return dao.del(id);
	}
	public int insert(String name, String pwd, String sex, String hobby, String bir) {
		// TODO Auto-generated method stub
		return dao.insert(name,pwd,sex,hobby,bir);
	}

}
