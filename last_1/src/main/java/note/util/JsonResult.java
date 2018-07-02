package note.util;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{
	private static final long serialVersionUID = 6918980907370660234L;
	final static int SUCCESS=1;
	final static int ERROR=0;
	
	private int state;
	private T data;
	private String message;
	
	private T rows;
	private int total;
	
	private int totalPage;
	private int currentPage;
	private int numPerPage;
	private int nextPage;
	private int previousPage;
	private boolean firstPage;
	private boolean lastPage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	
	
	
	public JsonResult(int state,Throwable e){
		this.state=state;
		this.data=null;
		this.message=e.getMessage();
	}
	
	public JsonResult(Throwable e){
		this.state=ERROR;
		this.data=null;
		this.message=e.getMessage();
	}
	public JsonResult(T data){
		this.state=SUCCESS;
		this.data=data;
		this.message="";
	}
	
	public JsonResult(T rows,int total) {
		this.rows=rows;
		this.total=total;
	}
	
	
	public JsonResult(T data,int totalPage,int currentPage,
			int numPerPage,int nextPage,int previousPage){
		this.state=SUCCESS;
		this.data=data;
		this.message="";
		//topjui
		this.rows=data;
		this.totalPage=totalPage;
		this.currentPage=currentPage;
		this.numPerPage=numPerPage;
		this.nextPage=nextPage;
		this.previousPage=previousPage;
		this.firstPage=true;
		this.lastPage=true;
		this.hasPreviousPage=false;
		this.hasNextPage=false;
		//topJUI格式
		/*modelMap.put("rows", page.getRecords());
		modelMap.put("totalPage", page.getPages());
		modelMap.put("currentPage", page.getCurrent());
		modelMap.put("numPerPage", page.getSize());
		modelMap.put("nextPage", page.getCurrent()<page.getPages()?page.getCurrent()+1:page.getCurrent());
		modelMap.put("previousPage", page.getCurrent()>1?page.getCurrent()-1:1);
		modelMap.put("firstPage", true);
		modelMap.put("lastPage", true);
		modelMap.put("hasPreviousPage", false);
		modelMap.put("hasNextPage", false);*/
	}
	
	
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public static int getSuccess() {
		return SUCCESS;
	}

	public JsonResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + ", rows=" + rows + ", total="
				+ total + ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", numPerPage=" + numPerPage
				+ ", nextPage=" + nextPage + ", previousPage=" + previousPage + ", firstPage=" + firstPage
				+ ", lastPage=" + lastPage + ", hasPreviousPage=" + hasPreviousPage + ", hasNextPage=" + hasNextPage
				+ "]";
	}

	public JsonResult(int state, T data, String message, T rows, int total, int totalPage, int currentPage,
			int numPerPage, int nextPage, int previousPage, boolean firstPage, boolean lastPage,
			boolean hasPreviousPage, boolean hasNextPage) {
		super();
		this.state = state;
		this.data = data;
		this.message = message;
		this.rows = rows;
		this.total = total;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.numPerPage = numPerPage;
		this.nextPage = nextPage;
		this.previousPage = previousPage;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.hasPreviousPage = hasPreviousPage;
		this.hasNextPage = hasNextPage;
	}

	
	
	
	
	
	
	
	
}
