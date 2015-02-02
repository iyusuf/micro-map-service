package com.sortedset.blog.micromapservice.spring;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class RestGisResource {

	public String getCountryBorder(String countryName) throws Exception {

		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:file:data/myspatialdb");
		Statement stat = conn.createStatement();

		StringBuilder sb = new StringBuilder();

		ResultSet rs;
		rs = stat.executeQuery("select ST_AsGeoJSON(the_geom) , name  from world_borders where name='"+countryName+"'");
		while (rs.next()) {
			//Append to make a proper GeoJSON JSON string.
			sb.append(" { \"type\": \"FeatureCollection\", \"features\": [{ \"type\": \"Feature\",\"properties\": {\"name\": \""+ countryName +"\"},\"geometry\": ");
			sb.append(rs.getString(1) );
			sb.append("}]}");
		}
		rs.close();
		stat.close();
		conn.close();

		return sb.toString();
	}
}