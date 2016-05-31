package web.model;

import web.globel.GlobalDefine;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;//用户名
	private String password;//用户密码
	private String nickName;//昵称
	private String realName;//真实姓名
	private Integer age;//年龄
	private Integer level=1;//等级
	private Integer status=GlobalDefine.USER_STATUS.NOMORL;//状态
	private String descript;//描述
	private String sex;//性别
	private String phone;//电话

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public User(String name, String password, String nickName, String realName,
			Integer age, Integer level, Integer status, String descript,
			String sex, String phone) {
		this.name = name;
		this.password = password;
		this.nickName = nickName;
		this.realName = realName;
		this.age = age;
		this.level = level;
		this.status = status;
		this.descript = descript;
		this.sex = sex;
		this.phone = phone;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}