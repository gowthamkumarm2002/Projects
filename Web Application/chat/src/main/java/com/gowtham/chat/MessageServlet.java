package com.gowtham.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import com.gowtham.chat.LoginServlet;
import com.gowtham.chat.FriendServlet;
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final int PORT_TWO = 9201;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX = "my-data-stream";
	String name = LoginServlet.Email;
	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME)));
		}
		return restHighLevelClient;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");
		String name = LoginServlet.Email;
		String friname = FriendServlet.FriendName;
		PrintWriter out = response.getWriter(); 
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if( msg != "") {
	    	HashMap<String, Object> dataMap = new HashMap<String, Object>();
	    	dataMap.put("@timestamp", instant);
		    dataMap.put("Sender", name);
		    dataMap.put("Receiver", friname);
		    dataMap.put("Message", msg);
		    dataMap.put("Time", s.format(timestamp));
	    
		    IndexRequest indexRequest = new IndexRequest(INDEX)
		            .source(dataMap);
		    try {
		    	MessageServlet.makeconnection();
		        IndexResponse response1 = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
		        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
				BoolQueryBuilder qb = QueryBuilders.boolQuery().must(QueryBuilders.multiMatchQuery(name ,"Sender.keyword", "Receiver.keyword"))
						.must(QueryBuilders.multiMatchQuery(friname ,"Sender.keyword", "Receiver.keyword"));
				sourceBuilder.query(qb).size(1000).sort("Time.keyword",SortOrder.ASC);
				SearchRequest searchRequest = new SearchRequest(INDEX);
				searchRequest.source(sourceBuilder);
				try {
					MessageServlet.makeconnection();
					SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
					long val = searchResponse.getHits().getTotalHits().value;
					if (val > 0) {
						try {
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
								request.setAttribute("status", "Success");
								request.getRequestDispatcher("chat.jsp").forward(request, response);
							}	
						}catch (ElasticsearchException e) {
							e.getDetailedMessage();
						}
					}else {
						request.setAttribute("status", "Success");
						request.getRequestDispatcher("newfriend.jsp").forward(request, response);
					}
			    } catch(ElasticsearchException e) {
			        e.getDetailedMessage();
			    } catch (java.io.IOException ex){
			        ex.getLocalizedMessage();
			    }
	        }catch (ElasticsearchException e) {
				e.getDetailedMessage();
			}
        }
	}
}
