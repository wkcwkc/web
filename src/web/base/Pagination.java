package web.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pager pager = new Pager();

	private List<T> records = new ArrayList<T>();

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Pagination() {
	}

	public Pagination(List<T> records, Pager pager) {
		super();
		this.records = records;
		this.pager = pager;
	}

}
