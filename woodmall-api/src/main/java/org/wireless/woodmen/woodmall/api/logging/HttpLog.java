package org.wireless.woodmen.woodmall.api.logging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "http_logs")
public class HttpLog {
	@Id
	@Field(type = FieldType.Keyword)
	private String transactionId;
	
	@Field(type = FieldType.Keyword)
	private String httpMethod;
	
	@Field(type = FieldType.Keyword)
	private String url;
	
	@Field(type = FieldType.Text)
	private String requestParameters;
	
	@Field(type = FieldType.Text)
	private String requestBody;
	
	@Field(type = FieldType.Integer)
	private Integer responseStatus;
	
	@Field(type = FieldType.Date_Nanos)
	private Date requestAt;
	
	@Field(type = FieldType.Date_Nanos)
	private Date responseAt;
	
	public void updateResponseData(Integer responseStatus) {
		this.responseStatus = responseStatus;
		this.responseAt = new Date();
	}
}
