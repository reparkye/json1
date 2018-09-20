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

import org.apache.catalina.util.DOMWriter;

import com.google.gson.Gson;

import service.testtestService;
import vo.Ticket;

/**
 * Servlet implementation class tesServlet
 */
@WebServlet("/tes/*")
public class tesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private testtestService ts = new testtestService();
    private Gson gson = new Gson();
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String param = request.getParameter("param");
    	Ticket t = new Ticket();
    	
    	if(t!=null&&!t.equals("")) {
    		t = gson.fromJson(param, Ticket.class);
    	}
		
		String uri = request.getRequestURI();
    	String cmd = uri.substring(uri.lastIndexOf("/")+1);
    	
    	if(cmd.equals("list")) {
    		doWrite(response, ts.selectgetList(t));
    	}else if(cmd.equals("view")) {
    		doWrite(response, ts.selectgetList(t));
    	}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ticket t = gson.fromJson(request.getReader(), Ticket.class);	//post 방식으로 사용하기 위해선 fromjson으로 해줘야 한다.
		
		int rCnt = ts.selectgetList(ti);
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response, rMap);
	}
	
	private void doWrite(HttpServletResponse res,Object obj)throws IOException{
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.write(gson.toJson(obj));
		pw.flush();
	}	
}
