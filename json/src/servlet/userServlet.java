package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.UserService;


@WebServlet("/susa/*")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Gson gson = new Gson();
       private UserService us = new UserService();
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);		//  1을 안써주면 '/list'로 출력되어 equals 문에 비교가 되기에 문제가 발생
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(cmd.equals("listt")) {
			String json = gson.toJson(us.getUserInfoList());	// 11 gson 덕분에 사용
			pw.print(json);
		}else {
			response.setStatus(404);
			pw.print("자네 주소 이상");
			return;
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
