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

import service.TicketService;
import vo.Ticket;

/**
 * Servlet implementation class TicketServlet
 */
@WebServlet("/api/ticket/*")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();   
	private TicketService ts = new TicketService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("params");			//키값을 가져와라
		Ticket t = new Ticket();
		//System.out.println(t);					// 확인을 위한 것
		if(t!=null&&!t.equals("")) {
			t = gson.fromJson(param, Ticket.class);
		}
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("list")) {
			doWrite(response,ts.selectTicketList(t));
		}else if(cmd.equals("view")) {
			//System.out.println(t);					// 확인을 위한 syso
			doWrite(response,ts.selectTicket(t));
			
			
		}else {
			
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ticket t = gson.fromJson(request.getReader(), Ticket.class);
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);

		/*String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);*/
		System.out.println(t);
		if(cmd.equals("insert")) {
		int rCnt = ts.insertTicket(t);
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
		
		}else if(cmd.equals("update")) {
		

		int uCnt = ts.updateTicket(t);
		Map<String,Integer> uMap = new HashMap<String,Integer>();
		uMap.put("rCnt", uCnt);
		doWrite(response,uMap);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ticket t = gson.fromJson(request.getReader(), Ticket.class);
		int rCnt = ts.updateTicket(t);
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ticket t = gson.fromJson(request.getReader(), Ticket.class);
		int rCnt = ts.deleteTicket(t);
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
	}
	
	private void doWrite(HttpServletResponse res,Object obj)throws IOException {	//각각 메소드에 전부 필요한데 하나로 만들기 위해 doservice창과 유사
		res.setContentType("application/json;charset=utf-8");		//<br>태그 인식 안하고 같이 '<br>'출력됨 하게 하려면 앞자리에application/json; 지우고 text/html; 뭐기시 입력
		PrintWriter pw = res.getWriter();
		pw.write(gson.toJson(obj));
		pw.flush();//현재 버퍼에 출력된 내용들을 클라이언트로 전송합니다.
	}
	
	
}
