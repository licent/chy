package com.tools;

import com.alibaba.fastjson.JSON;

/**
 * 返回对象封装
 */
public class ResponseInfo<T> {
	// 返回码
	private String code;
	// 返回描述
	private String msg;
	// 返回数据
	private T data;
	private long totalCount;
	private long pageSize;
	private long pageNo;
	private long totalPage;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) throws Exception {
		this.data = data;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public String toJsonString() {
		return JSON.toJSONString(this);
	}
}
