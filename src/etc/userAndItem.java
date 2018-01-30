package etc;

public class userAndItem {

	public static String insertUser = "INSERT INTO T_USER VALUES(?,?,?)";
	public static String selectUser = "SELECT * FROM T_USER WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM T_USER";
	
	public static String insertUserItem = "INSERT INTO T_USERITEM VALUES(?,?) ";
	public static String selectUserItem = "SELECT * FROM T_USERITEM WHERE USERID = ?";
	
	public static String selectItem = "SELECT * FROM T_ITEM WHERE ID = ?";
	
	public static String selectJoinUserItem = 
			"SELECT it.id, it.name, it.price \r\n" + 
			"FROM T_USER us, T_ITEM it, T_USERITEM ui\r\n" + 
			"WHERE us.id = ui.userid\r\n" + 
			"AND it.id = ui.itemid\r\n" + 
			"AND us.id = ?";
			
}
