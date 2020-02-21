package oracle.java.joongang.service;
public class Paging {
	private int currentPage = 1;	private int rowPage   = 10;
	private int pageBlock = 10;		
	private int start;		private int end;
	private int startPage;	private int endPage;
	private int total;		private int totalPage;
	
	public Paging(int total, String currentPage1) {
		this.total = total;
		if (currentPage1 != null) {
			this.currentPage = Integer.parseInt(currentPage1);			
		}
		start = (currentPage - 1) * rowPage + 1;  // ?��?��?�� 1
		end   = start + rowPage - 1;              // ?��?��?�� 10 
		totalPage = (int) Math.ceil((double)total / rowPage);  // ?��?��?�� 2
		startPage = currentPage - (currentPage - 1) % pageBlock; // ?��?��?�� 1
		endPage = startPage + pageBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}

	public int getCurrentPage() {	return currentPage;	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRowPage() {		return rowPage;	}
	public void setRowPage(int rowPage) {	this.rowPage = rowPage;	}
	public int getPageBlock() {	return pageBlock;	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStart() {		return start;	}
	public void setStart(int start) {	this.start = start;	}
	public int getEnd() {		return end;	}
	public void setEnd(int end) {		this.end = end;	}
	public int getStartPage() {		return startPage;	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {		return endPage;	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {		return total;	}

	public void setTotal(int total) {	this.total = total;	}
	public int getTotalPage() {		return totalPage;	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}	
}