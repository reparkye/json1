package service;

import java.util.List;

import dao.testtesttest;
import vo.Ticket;

public class testtestService {

	testtesttest tdao = new testtesttest();
	
	public List<Ticket> selectgetList(Ticket ti){
		
		return tdao.selectTicketList(ti);
	}
	
	
}
