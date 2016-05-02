package com.jlcindia.jboss;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

public class DataSourceUtil {
	public static DataSource getDataSource() {
		DataSource ds = null;
		try{
			Properties p = new Properties();
			p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			p.put(Context.PROVIDER_URL, "localhost:1099");
			p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			Context ctx = new InitialContext(p);
			Object obj = ctx.lookup("MySqlDS");
			ds = (DataSource)obj;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public static void cleanup(ResultSet re, Connection con, Statement st){
		try{
			if(re != null)	re.close();
			if(st != null)	st.close();
			if(con != null)	con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
