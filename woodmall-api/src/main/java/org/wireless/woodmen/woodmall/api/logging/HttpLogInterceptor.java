package org.wireless.woodmen.woodmall.api.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HttpLogInterceptor implements AsyncHandlerInterceptor {
	private final HttpLogRepository httpLogRepository;
	private final ObjectMapper objectMapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("transactionId", UUID.randomUUID().toString());
		request.setAttribute("requestAt", new Date());
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		String transactionId = (String) request.getAttribute("transactionId");
		Date requestAt = (Date) request.getAttribute("requestAt");
		
		httpLogRepository.save(new HttpLog(
				transactionId,
				request.getMethod(),
				request.getRequestURI(),
				objectMapper.writeValueAsString(request.getParameterMap()),
				// TODO : https://meetup.toast.com/posts/44
//			request.getReader().lines().toList().toString(), request wrapper가 필요함
				null,
				null,
				requestAt,
				new Date()
			)
		);
	}
}
