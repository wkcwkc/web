package web.model;

/**
 * VideoImg entity. @author MyEclipse Persistence Tools
 */

public class VideoImg implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer videoId;//所属视频的ID
	private Integer size=0;//图片大小
	private String type="jpg";//图片格式
	private String url;//图片存放路径

	// Constructors

	/** default constructor */
	public VideoImg() {
	}

	/** minimal constructor */
	public VideoImg(Integer videoId) {
		this.videoId = videoId;
	}

	/** full constructor */
	public VideoImg(Integer videoId, Integer size, String type, String url) {
		this.videoId = videoId;
		this.size = size;
		this.type = type;
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVideoId() {
		return this.videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}