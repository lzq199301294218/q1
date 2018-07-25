package www.zzz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import www.zzz.dao.DaGou;
import www.zzz.dao.Login;
import www.zzz.service.Qservice;

/**
 * Servlet implementation class Qservlet
 */
@WebServlet("/qservlet")
public class Qservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	Qservice ser = new Qservice();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  m = request.getParameter("mh");
		if(m.equals("login")){
			login(request,response);
		}
		if(m.equals("list")){
			list(request,response);
		}
		if(m.equals("toupdate")){
			toupdate(request,response);
		}
		if(m.equals("update")){
			update(request,response);
		}
		if(m.equals("del")){
			del(request,response);
		}
		if(m.equals("insert")){
			insert(request,response);
		}
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String hobby="";
		String[] hobbys = request.getParameterValues("hobby");
		for (String s : hobbys) {
			hobby+=" "+s;
		}
		hobby = hobby.substring(1);
		String bir = request.getParameter("bir");
		int i = ser.insert(name,pwd,sex,hobby,bir);
		response.getWriter().print(i);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int i = ser.del(id);
		response.getWriter().print(i);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String hobby = "";
		String[] hobbys = request.getParameterValues("hobby");
		for (String s : hobbys) {
			hobby+=" "+s;
		};
		hobby=hobby.substring(1);
		String bir = request.getParameter("bir");
		int i = ser.update(id,name,pwd,sex,hobby,bir);
		response.getWriter().print(i);
		

	}
	private void toupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		DaGou dg = ser.toupdate(id);
		JSONObject obj = JSONObject.fromObject(dg);
		response.getWriter().print(obj);
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		List<DaGou> list = ser.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Login ln = ser.login(name,pwd);
		if(ln!=null){
			response.getWriter().print("yes");
		}else{
		response.getWriter().print("no");
		}
	}

}
