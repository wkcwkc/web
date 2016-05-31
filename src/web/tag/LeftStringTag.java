package web.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import web.util.StringUtil;


/**
 * 截字标签
 * 
 * @author carvin.chen
 * 
 */
public class LeftStringTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	private String ellipsis;
	private String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getEllipsis() {
		return ellipsis;
	}

	public void setEllipsis(String ellipsis) {
		this.ellipsis = ellipsis;
	}

	@Override
	public int doEndTag() throws JspException {
		String text = "";
		if (super.bodyContent != null) {
			StringWriter body = new StringWriter();
			try {
				super.bodyContent.writeOut(body);
				text = body.toString();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		JspWriter writer = super.pageContext.getOut();
		try {
			writer.print(StringUtil.leftString(text, Double.parseDouble(this.count), isEllipsis()));
		} catch (IOException e) {
			throw new JspException(e.toString());
		}

		return 6;
	}

	private boolean isEllipsis() {
		if (this.ellipsis != null && ("true".equalsIgnoreCase(this.ellipsis.trim()) || "yes".equalsIgnoreCase(this.ellipsis.trim()))) {
			return true;
		}
		return false;
	}

	public void release() {
		super.release();
		ellipsis = null;
		count = null;
	}
}
