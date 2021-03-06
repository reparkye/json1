package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.DepartService;


/**
 * Servlet implementation class jsonServlet
 */
@WebServlet("/json/*")
public class jsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();   				
	private DepartService ds = new DepartService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);		//(0부터시작하여 마지막'/' 위치를 순서로, 1을 안써주면 '/list'로 출력되어 equals 문에 비교가 되기에 문제가 발생
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(cmd.equals("list")) {
			String json = gson.toJson(ds.getDepartInfoList()); //리스트 받아오는걸 스트링으로 바꾸는 작업?  gson 덕분에 사용
			pw.print(json);
			
			
		}else {
			response.setStatus(404);
			pw.print("너 주소 이상해");
			pw.flush();//현재 버퍼에 출력된 내용들을 클라이언트로 전송합니다.
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
