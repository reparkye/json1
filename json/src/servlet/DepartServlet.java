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

import service.DepartService;
import vo.DepartInfo;

/**
 * Servlet implementation class DepartServlet
 */
@WebServlet("/zxc/depart/*")
public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();   
    private DepartService ds = new DepartService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getParameter("params");
		DepartInfo di = new DepartInfo();
		if(di!=null && !di.equals("")) {
			di = gson.fromJson(params, DepartInfo.class);
		}
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("list")) {
			doWrite(response,ds.selectDepartList(di));
		}else if(cmd.equals("view")) {
			doWrite(response,ds.selectDepartList(di)); //오류 날것 왜냐면 36번과 동일한 리스트라서
		}else {
			
		}
		
			
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartInfo di = gson.fromJson(request.getReader(), DepartInfo.class);
		int rCnt = ds.insert뭐시기;
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rCnt);		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartInfo di = gson.fromJson(request.getReader(),DepartInfo.class);
		int rCnt = ds.dfsdf;
		Map<String,Integer> rMap = new HashMap<String,Integer>();
		rMap.put("rCnt", rCnt);
		doWrite(response,rMap);
	
		
	}
	private void doWrite(HttpServletResponse res,Object obj)throws IOException{
		res.setContentType("application/json;charset=uft-8");
		PrintWriter pw = res.getWriter();
		pw.write(gson.toJson(obj));
		pw.flush();
		
	}
	
	
	
}
