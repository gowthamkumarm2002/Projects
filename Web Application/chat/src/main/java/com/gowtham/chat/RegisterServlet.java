package com.gowtham.chat;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.gowtham.chat.RegisterServlet;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX = "chat";
	public static String Email;

	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME)));
		}
		return restHighLevelClient;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("Name");
		String uemail = request.getParameter("Email");
		String upass = request.getParameter("Password");
		String umob = request.getParameter("Mobile");
		String encodepassword = null;
		
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder qb= QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("Email.keyword", uemail));
		sourceBuilder.query(qb);
		SearchRequest searchRequest = new SearchRequest(INDEX);
		searchRequest.source(sourceBuilder);
		try {
			RegisterServlet.makeconnection();
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			long val = searchResponse.getHits().getTotalHits().value;
			if( val > 0) {
				request.setAttribute("status", "Exist");
		        request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			else {
				MessageDigest m = MessageDigest.getInstance("MD5");
				m.update(upass.getBytes());  
				byte[] bytes = m.digest();
				StringBuilder s = new StringBuilder();  
		        for(byte b: bytes)  
		        {  
		            s.append(String.format("%02x",b)); 
		        }  
		        encodepassword=s.toString();
	        
		        HashMap<String, Object> dataMap = new HashMap<String, Object>();
			    dataMap.put("Name", uname);
			    dataMap.put("Email", uemail);
			    dataMap.put("Password", encodepassword);
			    dataMap.put("Moblie", umob);
		    
			    IndexRequest indexRequest = new IndexRequest(INDEX)
			            .source(dataMap);
			    try {
			    	RegisterServlet.makeconnection();
			        IndexResponse response1 = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
			        request.setAttribute("status", "Success");
			        request.getRequestDispatcher("register.jsp").forward(request, response);
			    } catch(ElasticsearchException e) {
			        e.getDetailedMessage();
			    } catch (java.io.IOException ex){
			        ex.getLocalizedMessage();
			    }
			} 
		}catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} 
	
	}
}
