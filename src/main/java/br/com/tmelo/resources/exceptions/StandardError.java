package br.com.tmelo.resources.exceptions;

public class StandardError {

	private Integer status;
	private String msg;
	private Long timeStamp;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String pMsg) {
		this.msg = pMsg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long pTimeStamp) {
		this.timeStamp = pTimeStamp;
	}

	public StandardError(Integer pStatus, String pMsg, Long pTimeStamp) {
		super();
		this.status = pStatus;
		this.msg = pMsg;
		this.timeStamp = pTimeStamp;
	}

}
