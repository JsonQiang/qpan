package cn.pq.com;

import java.util.HashMap;
import java.util.Map;

public class JsonResp {

	private long status;
	private String message;
	private Map<String, Object> result = new HashMap<String, Object>();
	
	/**
	 * 添加result元素
	 */
	public void addResultElement(String key , Object value){
		this.result.put(key, value) ;
	}
	
	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
//	public void setStatusByEnum(ErrCodeEnum errCodeEnum){
//		this.status = errCodeEnum.getCodeLong();
//		this.message = errCodeEnum.getMessage();
//	}
}
