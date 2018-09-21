package service;

import java.util.HashMap;
import java.util.Map;

import dao.TicketDAO;
import vo.Ticket;

public class TicketService {
	private TicketDAO tdao = new TicketDAO();
	
	
	
	public Map<String,Object> selectTicketList(Ticket ticket){
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("list", tdao.selectTicketList(ticket));				// 페이지 1~5 등 과 같이 페이지 클래스를 가져가기 위해 map 형태사용
		rMap.put("page", 10);	//{ list: [{tm}]  ??
		
		return rMap;
	
		/*return tdao.selectTicketList(ticket);*/
	}
	
	public Ticket selectTicket(Ticket ticket) {
		
		
		return tdao.selectTicket(ticket);
		
	}
	
	public int insertTicket(Ticket ticket) {
		
		return tdao.insertTicket(ticket);
	}
	
	public int deleteTicket(Ticket ticket) {
		
		return tdao.deleteTicket(ticket);
	}

	public int updateTicket(Ticket ticket) {
	
		return tdao.updateTicket(ticket);
	}
	
	
}
