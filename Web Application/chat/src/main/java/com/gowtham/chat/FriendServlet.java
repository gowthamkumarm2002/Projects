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
import org.elasticsearch.search.sort.SortOrder;

import com.gowtham.chat.LoginServlet;

@WebServlet("/friend")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final int PORT_TWO = 9201;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX = "my-data-stream";
	private static final String INDEX1 = "chat";
	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME)));
		}
		return restHighLevelClient;
	}

	public static String FriendName;
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String friname = request.getParameter("FriName");
		String  member[] = request.getParameterValues("Friname");
		String friname = member[0];
		String name = LoginServlet.Email;
		FriendName = friname;
		HttpSession session = request.getSession();
		if (friname != "" && (!friname.equals(name))) {
			PrintWriter out = response.getWriter();
			
			SearchSourceBuilder sourceBuilder2 = new SearchSourceBuilder();
			BoolQueryBuilder qb2 = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("Name.keyword", friname));
			sourceBuilder2.query(qb2);
			SearchRequest searchRequest2 = new SearchRequest(INDEX1);
			searchRequest2.source(sourceBuilder2);
			try {
				FriendServlet.makeconnection();
				SearchResponse searchResponse2 = restHighLevelClient.search(searchRequest2, RequestOptions.DEFAULT);
				long val2 = searchResponse2.getHits().getTotalHits().value;
				if (val2 > 0) {
					SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
					BoolQueryBuilder qb = QueryBuilders.boolQuery().must(QueryBuilders.multiMatchQuery(name ,"Sender.keyword", "Receiver.keyword"))
							.must(QueryBuilders.multiMatchQuery(friname ,"Sender.keyword", "Receiver.keyword"));
					sourceBuilder.query(qb).size(5000).sort("Time.keyword",SortOrder.ASC);
					SearchRequest searchRequest = new SearchRequest(INDEX);
					searchRequest.source(sourceBuilder);
					try {
						FriendServlet.makeconnection();
						SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
						long val = searchResponse.getHits().getTotalHits().value;
						if (val > 0) {
							try {
								long val3 = searchResponse.getHits().getTotalHits().value;
								ArrayList<Details> log = new ArrayList<Details>();
								Map<String, Object> map = null;
								SearchHit[] searchHit = searchResponse.getHits().getHits();
								String t1 = "", t2 = "", t3 = "";
								for (SearchHit hit : searchHit) {
									map = hit.getSourceAsMap();
									for (Map.Entry<String, Object> entry : map.entrySet()) {
										if (entry.getKey() == "Sender") {
											t1 = (String) entry.getValue();
										} else if (entry.getKey() == "Message") {
											t2 = (String) entry.getValue();
										} else if (entry.getKey() == "Time") {
											t3 = (String) entry.getValue();
										}
									}
									log.add(new Details(t1, t2, t3));
								}
								if(log.size() > 0) {
									request.setAttribute("list", log);
									session.setAttribute("FriName", FriendName);
									request.getRequestDispatcher("chat.jsp").forward(request, response);
								}	
							}catch (ElasticsearchException e) {
								e.getDetailedMessage();
							}
						}else {
							session.setAttribute("FriName", FriendName);
							request.getRequestDispatcher("newfriend.jsp").forward(request, response);
						}
					} catch (ElasticsearchException e) {
						e.getDetailedMessage();
					}
				}else {
					FriendServlet.makeconnection();
					SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
					SearchRequest searchRequest = new SearchRequest(INDEX1);
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
							if (entry.getKey() == "Name") {
								t1 = (String) entry.getValue();
							}
						}
						if(!t1.equals(name)) {
							log.add(t1);
						}
					}
					request.setAttribute("list", log);
					request.setAttribute("status", "Failed");
					request.getRequestDispatcher("friend.jsp").forward(request, response);
				}
			}catch (ElasticsearchException e) {
				e.getDetailedMessage();
			}
		}else {
			FriendServlet.makeconnection();
			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
			SearchRequest searchRequest = new SearchRequest(INDEX1);
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
					if (entry.getKey() == "Name") {
						t1 = (String) entry.getValue();
					}
				}
				if(!t1.equals(name)) {
					log.add(t1);
				}
			}
			request.setAttribute("list", log);
			request.setAttribute("status", "You");
			request.getRequestDispatcher("friend.jsp").forward(request, response);
		}
	}
}
