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

import service.TticketService;
import vo.Tticket;

/**
 * Servlet implementation class TticketServlet
 */
@WebServlet("/aap/tticket/*")
public class TticketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TticketService tts = new TticketService();
    private Gson gson = new Gson();
     
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getParameter("params");
		Tticket t = new Tticket();
		System.out.println(t);
		if(t!=null&& !t.equals("")) {
			t = gson.fromJson(params, Tticket.class);
		}
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("list")) {
			doWrite(response, tts.selectTticketList(t));
		}else if(cmd.equals("view")) {
			System.out.println(t);
			doWrite(response, tts.selectTticket(t));
		}else {
			
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tticket t = gson.fromJson(request.getReader(), Tticket.class);
		System.out.println(t);
		int rCnt = tts.insertTticket(t);
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
				
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tticket t = gson.fromJson(request.getReader(), Tticket.class);
		System.out.println(t);
		int rCnt = tts.updateTticket(t);
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
				
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tticket t = gson.fromJson(request.getReader(), Tticket.class);
		System.out.println(t);
		int rCnt = tts.deleteTticket(t);
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
				
	}

	private void doWrite(HttpServletResponse res,Object obj)throws IOException{
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.write(gson.toJson(obj));
		pw.flush();
	}
	
	
}
