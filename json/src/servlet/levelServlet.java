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


@WebServlet("/level/*")
public class levelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LevelService ls = new LevelService();
	private Gson gson = new Gson();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(cmd.equals("leve")) {
			String json = gson.toJson(ls.getLevelList());
			pw.print(json);
		}else {
			response.setStatus(404);
			pw.print("이상");
			pw.flush();
			return;
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
