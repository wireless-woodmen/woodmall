package org.wireless.woodmen.woodmall.api.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class HttpLogClient {
	private final RestClient restClient;
//
//	public void write(HttpLog httpLog) {
////		IndexRequest request = new IndexRequest().index("http_log").source(httpLog);
//		Request request = new Request();
//		request.
//		 restClient.performRequest(request);
//	}
}
