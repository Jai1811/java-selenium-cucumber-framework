package coeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.PropertyType;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

public class Fieldvalidations {

	public static String extractsqldata(String tablename, String columnname) throws SQLException {
		Connection conn = null;
		String fieldvalue = null;
		if (tablename.equals("air_flight_details")) {
			conn = DBConnections.mysqlconnection();
			String sql = "Select * from " + tablename;
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				fieldvalue = rs.getString(columnname);
				System.out.println(fieldvalue);
			}
		}
		return fieldvalue;
	}

	public static void sqlmethod() throws SQLException {
		Connection conn = null;
		conn = DBConnections.mysqlconnection();
		String sql = "select f.flight_id,f.from_location,f.to_location,monthname(fd.flight_departure_date) as 			Month_name,avg(fd.price) as Average_price from air_flight f join air_flight_details fd on f.flight_id=fd.flight_id 			group by f.flight_id,Month_name order by f.flight_id,Month_name";

		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			HashMap<String, String> tablevalue = new HashMap<String, String>();
			tablevalue.put("f.flight_id", rs.getString("f.flight_id"));
			tablevalue.put("f.from_location", rs.getString("f.from_location"));
			tablevalue.put("Month_name", rs.getString("Month_name"));
			tablevalue.put("Average_price", rs.getString("Average_price"));
			System.out.println(tablevalue);
		}

	}
	
	public static HashMap<String, ArrayList<String>> crxdeDataExtraction() throws RepositoryException{
	
		
	Node n=DBConnections.jcrConnection();
	

	System.out.println(n.getPath());

	PropertyIterator propitr = n.getProperties();
	HashMap<String, ArrayList<String>> nodeprop = new HashMap<String, ArrayList<String>>();
	String propname = null;
	String propvalue=null;
	Value[] propvalues=null;
	int proptype;
	String proptypestr = null;
	PropertyType type = null;
	ArrayList multiValuList=new ArrayList();
	ArrayList<String> singlevalue = new ArrayList<String>();
	

	while(propitr.hasNext())
	{
		try {

		Property property = propitr.nextProperty();
		propname = property.getName();
		System.out.println(propname);
		proptype = property.getType();
		proptypestr = type.nameFromValue(proptype);
		System.out.println(proptypestr);
		if(property.isMultiple())
		{
			propvalues=property.getValues();
			System.out.println(propvalues);
			for (int i=0;i<=propvalues.length;i++)
			{
				String value=propvalues[i].getString();
				multiValuList.add(Arrays.asList(i));
			}

			nodeprop.put(propname, multiValuList);
			multiValuList.remove(0);
		}
		propvalue = property.getValue().getString();
		singlevalue.add(propvalue);
		System.out.println(propvalue);
		nodeprop.put(propname, singlevalue);
		System.out.println(nodeprop);
		

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	System.out.println(nodeprop);
	
	return nodeprop;
	}
}
