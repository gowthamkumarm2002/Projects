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

@WebServlet("/groups")
public class GroupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final int PORT_TWO = 9201;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX = "group-data-stream";
	private static final String INDEX1 = "groups";
	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME)));
		}
		return restHighLevelClient;
	}
	
	public static String Groupname;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String groupname = request.getParameter("Groupname");
		Groupname = groupname;
		HttpSession session = request.getSession();
		SearchSourceBuilder sourceBuilder2 = new SearchSourceBuilder();
		BoolQueryBuilder qb2 = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("GroupName.keyword", groupname));
		sourceBuilder2.query(qb2).size(5000).sort("Time.keyword",SortOrder.ASC);
		SearchRequest searchRequest2 = new SearchRequest(INDEX);
		searchRequest2.source(sourceBuilder2);
		try {
			GroupsServlet.makeconnection();
			SearchResponse searchResponse2 = restHighLevelClient.search(searchRequest2, RequestOptions.DEFAULT);
			long val2 = searchResponse2.getHits().getTotalHits().value;
			if (val2 > 0) {
				try {
					ArrayList<Details> log = new ArrayList<Details>();
					Map<String, Object> map = null;
					SearchHit[] searchHit = searchResponse2.getHits().getHits();
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
						session.setAttribute("GrpName", groupname);
						request.getRequestDispatcher("groupmessage.jsp").forward(request, response);
					}	
				}catch (ElasticsearchException e) {
					e.getDetailedMessage();
				}
			}else {
				session.setAttribute("GrpName", groupname);
				request.getRequestDispatcher("newgrpmsg.jsp").forward(request, response);
			}
		}catch (ElasticsearchException e) {
			e.getDetailedMessage();
		}
	}
}
