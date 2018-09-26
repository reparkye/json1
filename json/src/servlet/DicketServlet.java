package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.DicketService;
import vo.Dicket;

/**
 * Servlet implementation class DicketServlet
 */
@WebServlet("/api/dicket/*")
public class DicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Gson gson = new Gson();
	private DicketService ds = new DicketService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getParameter("params");
		Dicket d = new Dicket();
		if(d!=null&!d.equals("")) {
			d = gson.fromJson(params, Dicket.class);
		}
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("list")) {
			doWrite(response,ds.selectDicketList(d));
		}else if(cmd.equals("view")) {
			doWrite(response,ds.selectDicket(d));
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dicket d = gson.fromJson(request.getReader(), Dicket.class);
		int rCnt = ds.insertDicket(d);
		Map<String,Integer> rMap =  new HashMap<String, Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dicket d = gson.fromJson(request.getReader(), Dicket.class);
		int rCnt = ds.updateDicket(d);
		Map<String,Integer> rMap = new HashMap<String, Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
		

	}
	private void doWrite(HttpServletResponse res, Object obj) throws IOException{
	res.setContentType("application/json;charset=utf-8");
	PrintWriter pw = res.getWriter();
	pw.write(gson.toJson(obj));
	pw.flush();
	}
}
