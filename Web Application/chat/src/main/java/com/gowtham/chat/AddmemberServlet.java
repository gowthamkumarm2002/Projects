package com.gowtham.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

@WebServlet("/addmember")
public class AddmemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final int PORT_TWO = 9201;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX1 = "chat";
	public static String Email;
	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME),new HttpHost(HOST, PORT_TWO, SCHEME)));
		}
		return restHighLevelClient;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = LoginServlet.Email;
		try {
			AddmemberServlet.makeconnection();
			HttpSession session = request.getSession();
			SearchSourceBuilder sourceBuilder1 = new SearchSourceBuilder();
			SearchRequest searchRequest1 = new SearchRequest(INDEX1);
			BoolQueryBuilder qb1 = QueryBuilders.boolQuery();
			sourceBuilder1.query(qb1);
			searchRequest1.source(sourceBuilder1);
			SearchResponse searchResponse1 = restHighLevelClient.search(searchRequest1,
					RequestOptions.DEFAULT);
			ArrayList<String> log = new ArrayList<String>();
			Map<String, Object> map = null;
			SearchHit[] searchHit = searchResponse1.getHits().getHits();
			String t1 = "";
			for (SearchHit hit : searchHit) {
				map = hit.getSourceAsMap();
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if (entry.getKey() == "Name") {
						t1 = (String) entry.getValue();
					}
				}
				if(!t1.equals(uemail)) {
					log.add(t1);
				}
			}
			request.setAttribute("list", log);
			session.setAttribute("Email", uemail);
			request.getRequestDispatcher("creategroup.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
