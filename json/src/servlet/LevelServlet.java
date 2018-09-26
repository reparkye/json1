package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.LevelService;
import vo.LevelInfo;

/**
 * Servlet implementation class LevelServlet
 */
@WebServlet("/api/level/*")
public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LevelService ls = new LevelService();
	private Gson gson = new Gson();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("params");
		LevelInfo li = new LevelInfo();
		
		if(li!=null&&!li.equals("")) {
			li = gson.fromJson(param, LevelInfo.class);
		}
		
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("list")) {
			doWrite(response, ls.selectgetLevel(li));
		}else if(cmd.equals("view"))	{
			doWrite(response, ls.selectLevel(li));
		}
		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LevelInfo li = gson.fromJson(request.getReader(), LevelInfo.class);
		
	
	
	}
	protected void doPos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	protected void doPo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	private void doWrite(HttpServletResponse res,Object obj)throws IOException{
		res.setContentType("application/json;char=utf-8");
		PrintWriter pw = res.getWriter();
		pw.write(gson.toJson(gson.toJson(obj)));
		pw.flush();
	}

}
