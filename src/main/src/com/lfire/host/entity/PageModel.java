package com.lfire.host.entity;

import java.util.List;
/**
 * ��ҳ���?
 * @author Li Yongqiang
 * @param <T> ʵ�����?
 */
public class PageModel<T> {
	private int totalRecords;//�ܼ�¼��
	private List<T> list;//���?
	private int pageNo;//��ǰҳ
	private int pageSize;//ÿҳ��ʾ������ 
	/**
	 * ȡ�õ�һҳ
	 * @return ��һҳ
	 */
	public int getTopPageNo() {
		return 1;
	}
	/**
	 * ȡ����һҳ
	 * @return ��һҳ
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo -1;
	}
	/**
	 * ȡ����һҳ
	 * @return ��һҳ
	 */
	public int getNextPageNo() {
		if (pageNo >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return pageNo + 1;
	}
	/**
	 * ȡ�����һ�?
	 * @return ���һ�?
	 */
	public int getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}
	/**
	 * ȡ����ҳ��
	 * @return
	 */
	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}
