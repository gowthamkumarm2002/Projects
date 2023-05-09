package com.gowtham.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
import org.elasticsearch.client.indices.CreateDataStreamRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;


@WebServlet("/creategroup")
public class CreategroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HOST = "localhost";
	private static final int PORT_ONE = 9200;
	private static final String SCHEME = "http";
	private static RestHighLevelClient restHighLevelClient;
	private static final String INDEX = "groups";
	private static final String INDEX1 = "chat";
	public static String Email;

	private static synchronized RestHighLevelClient makeconnection() {
		if (restHighLevelClient == null) {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost(HOST, PORT_ONE, SCHEME)));
		}
		return restHighLevelClient;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = LoginServlet.Email;
		String member[] = request.getParameterValues("members");
		String groupname = request.getParameter("groupname");
		PrintWriter out = response.getWriter();
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder qb= QueryBuilders.boolQuery().must(QueryBuilders.matchPhraseQuery("GroupName.keyword", groupname));
		sourceBuilder.query(qb);
		SearchRequest searchRequest = new SearchRequest(INDEX);
		searchRequest.source(sourceBuilder);
		try {
			CreategroupServlet.makeconnection();
			SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			long val = searchResponse.getHits().getTotalHits().value;
			if( val > 0) {
				try {
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
					request.setAttribute("status", "Exist");
					request.getRequestDispatcher("creategroup.jsp").forward(request, response);
		        }catch (Exception e) {
					e.printStackTrace();
				}

			}else {
				 HashMap<String, Object> dataMap = new HashMap<String, Object>();
				 dataMap.put("GroupName", groupname);
				 dataMap.put("members", member);
				 dataMap.put("Created", uemail);
				 IndexRequest indexRequest = new IndexRequest(INDEX)
				            .source(dataMap);
			    try {
			    	CreategroupServlet.makeconnection();
			        IndexResponse response1 = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
			        try {
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
								System.out.println(t1);
							}
						}
						request.setAttribute("list", log);
						request.setAttribute("status", "Success");
				        request.getRequestDispatcher("creategroup.jsp").forward(request, response);
			        }catch (Exception e) {
						e.printStackTrace();
					}	
			    } catch(ElasticsearchException e) {
			        e.getDetailedMessage();
			    } catch (java.io.IOException ex){
			        ex.getLocalizedMessage();
			    }
			}
		}catch(ElasticsearchException e) {
	        e.getDetailedMessage();
	    }
	}
}
