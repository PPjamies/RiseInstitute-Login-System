
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import com.healthmarketscience.jackcess.*;
import com.healthmarketscience.jackcess.Table.ColumnOrder;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/* 
 * @author Pazuz
 *
 */
public class AccessConnectivity {
	private String sid;
	private String fname;
	private String lname;
	private String email;
	
	public AccessConnectivity(ArrayList<String>list) {
		try {
			Database db = DatabaseBuilder.open(new File("C:\\Users\\Pazuz\\Documents\\RISE SIGN IN\\relational_signin.accdb"));
			Table table = db.getTable("relational_signin");
						
			for(int i=0; i<list.size(); i++) {
				if(i==0) {
					sid = list.get(i);
				}else if(i==1) {
					fname = list.get(i);
				}else if(i==2) {
					lname = list.get(i);
				}else if(i==3) {
					email = list.get(i);
				}
			}

			Calendar cal = Calendar.getInstance();
			table.addRow(Column.AUTO_NUMBER,sid,fname,lname,email,cal);
			
			db.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

