package com.spring.rest.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

import com.spring.rest.to.StudentTO;
import com.spring.rest.to.Students;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class StudentJSONClient {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// 1. Add the Student
		String url1 = "http://localhost:8989/Lab20/services/student/add/";
		url1 = url1 + "bbbb" + "/" + "bbbb@jlc.com" + "/" + 2222+".json";
		WebResource webres1 = client.resource(url1);
		webres1.post();
		System.out.println("********************************************");

		// 2. Get All the Students
		String url2 = "http://localhost:8989/Lab20/services/student/getall.json";
		WebResource webres2 = client.resource(url2);
		ClientResponse cresp1 = webres2.accept("text/json").get(ClientResponse.class);

		String res = cresp1.getEntity(String.class);
		JSONTokener tok = new JSONTokener(res);
		
		Object obj = tok.nextValue();
		JSONObject jobj = (JSONObject)obj;
		JSONObject list = jobj.getJSONObject("LIST");
		JSONArray studList = list.getJSONArray("studList");
		Students studs = new Students();
		List<StudentTO> studtoList = new ArrayList<StudentTO>();
		Iterator<JSONObject> it = studList.iterator();
		
		while(it.hasNext()){
			JSONObject stobj = (JSONObject)it.next();
			int id = stobj.getInt("sid");
			String nm = stobj.getString("name");
			String em = stobj.getString("email");
			long ph = stobj.getLong("phone");
			
			StudentTO st = new StudentTO(id, nm, em, ph);
			System.out.println(st);
			studtoList.add(st);
		}

		studs.setStudList(studtoList);
		System.out.println("No of Students : "+studtoList.size());
		
		System.out.println("********************************************");
		
		// 3. get Student by ID
		String url3 = "http://localhost:8989/Lab20/services/student/getbyid/";
		url3 = url3 + "1.json";
		WebResource webres3 = client.resource(url3);
		ClientResponse cresp2 = webres3.accept("text/json").get(ClientResponse.class);

		String res1 = cresp2.getEntity(String.class);
		JSONTokener tok1 = new JSONTokener(res1);
		
		JSONObject jobj1 = (JSONObject)tok1.nextValue();
		JSONObject studobj = jobj1.getJSONObject("STUD");
		
		int id = studobj.getInt("sid");
		String nm = studobj.getString("name");
		String em = studobj.getString("email");
		long ph = studobj.getLong("phone");
		
		StudentTO stud = new StudentTO(id, nm, em, ph);
		System.out.println(stud);
		
		
	}
}
