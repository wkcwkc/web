package web.model;

import java.sql.Timestamp;

/**
 * UserComment entity. @author MyEclipse Persistence Tools
 */

public class UserComment implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;//发评论的用户
	private Video video;//评论的视频
	private Timestamp createTime;//发表时间
	private String word;//评论

	// Constructors

	/** default constructor */
	public UserComment() {
	}

	/** minimal constructor */
	public UserComment(User user, Video video) {
		this.user = user;
		this.video = video;
	}

	/** full constructor */
	public UserComment(User user, Video video, Timestamp createTime,
			String word) {
		this.user = user;
		this.video = video;
		this.createTime = createTime;
		this.word = word;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}