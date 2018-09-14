package json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ParseTest {

	public static void main(String[] args) {
		Gson gson = new Gson();
		String param = "{\"name\" : \"홍길동\"}";
		Map<String,String> map = new HashMap<String,String>();
		
		map = gson.fromJson(param, Map.class);   // param 이라는 것을 map 형태로 바꿔준다.
		
		//param = param.replace("\"" , "");
		//String[] params = param.split(":");
		//map.put(params[0].replace("{", ""),params[1],replace("}","") );
		System.out.println(map);
		
		
		System.out.println("\"");
		
		}
	}

