package web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import web.base.Pagination;


public class PagerTag<T> extends TagSupport {

	private static final long serialVersionUID = -5110170357558797958L;

	private Pagination<T> pagination;

	private String targetForm;

	/**
	 *   <ul class="pagination my-margin-0">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
	 * */
	public int doStartTag() throws JspException {
		if(pagination != null){
			StringBuffer pagerHtml = new StringBuffer();
			pagerHtml.append("<script>function goPage(p){$('#" + targetForm + " #page').val(p);list.loadDataList();}</script>");
			int currentPage = pagination.getPager().getPageth();
			int totalPage = pagination.getPager().getPageCount();
			int pageSize = pagination.getPager().getPageSize();
			pagerHtml.append("<input type='hidden' id='page' name='page' value='" + currentPage + "'/>");
			pagerHtml.append("<input type='hidden' id='pageSize' name='pageSize' value='" + pageSize + "'/>");

			if(pagination.getPager().getPageCount()>1){
			    pagerHtml.append("<ul class=\"pagination my-margin-0 pull-right\">");
				if (currentPage == 1) {
					pagerHtml.append("<li><a href=\"#\" class='disable' aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
				} else {
					pagerHtml.append("<li><a href='javascript:goPage(" + (currentPage - 1) + ")' aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
				}
		
				if (totalPage <= 6) {
					for (int p = 1; p <= totalPage; p++) {
						String on = (p == currentPage ? "class='active'" : "class=''");
						pagerHtml.append("<li  " + on + "><a href=\"javascript:goPage(" + p + ")\">" + p + "</a></li>");
					}
				} else {
					if (currentPage > 3) {
						pagerHtml.append("<li><a href=\"javascript:goPage(1)\">1</a></li>");
						pagerHtml.append("<li><a>...</a></li>");
					}
					int start = currentPage - 2;
					if (start < 1)
						start = 1;
					int end = start + 4;
					if (end > totalPage)
						end = totalPage;
					for (int p = start; p <= end; p++) {
						String on = (p == currentPage ? "class='active'" : "class=''");
						pagerHtml.append("<li  " + on + "><a href=\"javascript:goPage(" + p + ")\">" + p + "</a></li>");
					}
		
					if (currentPage < totalPage - 2) {
						pagerHtml.append("<li><a>...</a></li>");
						pagerHtml.append("<li><a href=\"javascript:goPage(" + totalPage + ")\">" + totalPage + "</a></li>");
					}
				}
		
				if (currentPage == totalPage) {
					pagerHtml.append("<li><a href=\"#\" class='disable' aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
				} else {
					pagerHtml.append("<li><a href=\"javascript:goPage(" + (currentPage + 1) + ")' aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
				}
				pagerHtml.append("</ul>");
			}
			try {
				pageContext.getOut().write(pagerHtml.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return super.doStartTag();

	}

	public Pagination<T> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<T> pagination) {
		this.pagination = pagination;
	}

	public String getTargetForm() {
		return targetForm;
	}

	public void setTargetForm(String targetForm) {
		this.targetForm = targetForm;
	}

}
