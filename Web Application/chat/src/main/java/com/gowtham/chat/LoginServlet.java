package com.gowtham.chat;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final int PORT_TWO = 9201;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX = "chat";
	public static String Email;
	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME),new HttpHost(HOST, PORT_TWO, SCHEME)));
		}
		return restHighLevelClient;
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("Email");
		String upass = request.getParameter("Password");
		Email = uemail;
		LoginServlet.makeconnection();
		try {
			String encodepassword = null;
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(upass.getBytes());
			byte[] bytes = m.digest();
			StringBuilder s = new StringBuilder();
			for (byte b : bytes) {
				s.append(String.format("%02x", b));
			}
			encodepassword = s.toString();

			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
			BoolQueryBuilder qb = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("Name.keyword", uemail))
					.must(QueryBuilders.matchQuery("Password.keyword", encodepassword));
			sourceBuilder.query(qb);
			SearchRequest searchRequest = new SearchRequest(INDEX);
			searchRequest.source(sourceBuilder);
			try {
				HttpSession session = request.getSession();
				LoginServlet.makeconnection();
				SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
				long val = searchResponse.getHits().getTotalHits().value;
				if(val>0) {
					session.setAttribute("Email", uemail);
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}else {
					request.setAttribute("status", "Failed");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (ElasticsearchException e) {
				e.getDetailedMessage();
			} catch (java.io.IOException e) {
				e.getLocalizedMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
