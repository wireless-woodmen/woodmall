package org.wireless.woodmen.woodmall.api.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HttpLogInterceptor implements HandlerInterceptor, AsyncHandlerInterceptor {
	private final HttpLogRepository httpLogRepository;
	private final ObjectMapper objectMapper;
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String transactionId = UUID.randomUUID().toString();
		request.setAttribute("transactionId", transactionId);
		httpLogRepository.save(new HttpLog(
			transactionId,
			request.getMethod(),
			request.getRequestURI(),
			objectMapper.writeValueAsString(request.getParameterMap()),
			// TODO : https://meetup.toast.com/posts/44
//			request.getReader().lines().toList().toString(), request wrapper가 필요함
			null,
			null,
			new Date(),
			null
			)
		);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String transactionId = (String) request.getAttribute("transactionId");
		HttpLog httpLog = httpLogRepository.findById(transactionId).orElseGet(HttpLog::new);
		httpLog.updateResponseData(response.getStatus());
		httpLogRepository.save(httpLog);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}
