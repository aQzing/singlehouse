package com.qzing.singlehouse.common.result;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

public class ResultMsg {
	
	public static final String errorMsgKey = "errorMsg";
	public static final String successMsgKey = "successMsg";
	
	private String errorMsg;
	private String successMsg;
	
	public boolean isSuccess() {
		return errorMsg == null;
	}
	public String getErrMsg() {
		return errorMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errorMsg = errMsg;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	
	public static ResultMsg errorMsg(String errorMsg) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setErrMsg(errorMsg);
		return resultMsg;
	}

	public static ResultMsg successMsg(String successMsg) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setErrMsg(successMsg);
		return resultMsg;
	}
	
	public Map<String,String>asMap(){
		Map<String,String>map = Maps.newHashMap();
		map.put(errorMsgKey, errorMsg);
		map.put(successMsgKey, successMsg);
		return map;
	}
	
	public String asUrlParams() {
		Map<String, String> asMap = asMap();
		Map<String, String> map = Maps.newHashMap();
		asMap.forEach((k,v) -> {if(null!=v) {
				try {
					map.put(k,URLEncoder.encode(v, "utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		});
		return Joiner.on("&").useForNull("").withKeyValueSeparator("=").join(map);
	}
}
