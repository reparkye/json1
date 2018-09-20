package service;

import java.util.List;

import dao.TestDAO;
import vo.TestInfo;

public class TestService {

	TestDAO tdao = new TestDAO();
	
	public List<TestInfo> getSelectList() {
		
		return tdao.selectTestList();
				
	}
	
}
