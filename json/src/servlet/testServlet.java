package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.TestService;


@WebServlet("/test/*")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TestService ts = new TestService();
    private Gson gson = new Gson();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(cmd.equals("ttlist")) {
			String json = gson.toJson(ts.getSelectList()); //String 형태??
			pw.print(json);
		}else {
			response.setStatus(404);
			pw.print("주소가 이상합니다 다시 확인점");
			pw.flush();//현재 버퍼에 출력된 내용들을 클라이언트로 전송합니다.
			return;
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
