package parameter;

public class SpecsListData {
	/// <summary>
    /// 每页条目数
    /// </summary>
//    public int pageSize { get; set; }
	public int pageSize;

    /// <summary>
    /// 第几页
    /// </summary>
//    public int pageIndex { get; set; }
	public int pageIndex;

    

	/// <summary>
    /// 账套
    /// </summary>
//    public string ck { get; set; }
	public String ck;

    /// <summary>
    /// 企业号
    /// </summary>
//    public string conn { get; set; }
	public String conn;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getCk() {
		return ck;
	}

	public void setCk(String ck) {
		this.ck = ck;
	}

	public String getConn() {
		return conn;
	}

	public void setConn(String conn) {
		this.conn = conn;
	}	
}
