package org.wireless.woodmen.woodmall.api.logging;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

public interface HttpLogRepository extends CrudRepository<HttpLog, String> {
	@Async
	@Override
	<S extends HttpLog> S save(S entity);
}
