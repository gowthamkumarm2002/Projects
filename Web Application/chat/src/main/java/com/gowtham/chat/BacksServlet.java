package com.gowtham.chat;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.gowtham.chat.LoginServlet;

@WebServlet("/back2")
public class BacksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX = "groups";

	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME)));
		}
		return restHighLevelClient;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = LoginServlet.Email;
		try{
			BacksServlet.makeconnection();
			HttpSession session = request.getSession();
			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
			SearchRequest searchRequest = new SearchRequest(INDEX);
			BoolQueryBuilder qb = QueryBuilders.boolQuery();
			sourceBuilder.query(qb);
			searchRequest.source(sourceBuilder);
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest,
					RequestOptions.DEFAULT);
			ArrayList<String> log = new ArrayList<String>();
			Map<String, Object> map = null;
			SearchHit[] searchHit = searchResponse.getHits().getHits();
			String t1 = "";
			for (SearchHit hit : searchHit) {
				map = hit.getSourceAsMap();
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if (entry.getKey() == "GroupName") {
						t1 = (String) entry.getValue();
					}
				}
				if(!t1.equals(name)) {
					log.add(t1);
				}
			}
			request.setAttribute("list", log);
			session.setAttribute("Email", name);
			request.getRequestDispatcher("groups.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
