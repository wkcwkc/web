package web.model;

import java.sql.Timestamp;


/**
 * Video entity. @author MyEclipse Persistence Tools
 */

public class Video implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;//视频名称 50字以内
	private User user;//发表视频的用户
	private Timestamp createTime;//视频发布时间
	private String descript;//视频描述
	private Integer size=0;//视频大小
	private String type="mp4";//视频格式
	private Integer status=1;//视频状态
	private String url;//视频存放路径
	private VideoImg videoImg;//视频封面图片

	// Constructors

	/** default constructor */
	public Video() {
	}

	/** minimal constructor */
	public Video(String name, User user) {
		this.name = name;
		this.user = user;
	}

	/** full constructor */
	public Video(String name, User user, Timestamp createTime,
			String descript, Integer size, String type, Integer status,
			String url, VideoImg videoImg) {
		this.name = name;
		this.user= user;
		this.createTime = createTime;
		this.descript = descript;
		this.size = size;
		this.type = type;
		this.status = status;
		this.url = url;
		this.videoImg = videoImg;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public VideoImg getVideoImg() {
		return this.videoImg;
	}

	public void setVideoImg(VideoImg videoImg) {
		this.videoImg = videoImg;
	}

}