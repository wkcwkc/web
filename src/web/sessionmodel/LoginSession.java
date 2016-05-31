package web.sessionmodel;

public class LoginSession implements java.io.Serializable{

	private static final long serialVersionUID = -1505745321572107449L;

	private Integer id;//用户id
	private String name;//用户名
	private Integer status;//登陆状态
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
