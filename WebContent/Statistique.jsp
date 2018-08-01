<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.google.gson.*"%>

<%
	String hostdb = "localhost:3306";  // MySQl host
	String userdb = "root";  // MySQL username
	String passdb = "";  // MySQL password
	String namedb = "project_breizhlink";  // MySQL database name
		
	// Establish a connection to the database
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	Connection con = DriverManager.getConnection("jdbc:mysql://" + hostdb + "/" + namedb , userdb , passdb);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Graphique</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script src="Script/fusioncharts.js"></script>
	</head>
	
	<body>
	
		<jsp:include page="header.jsp"/>

		<div id="chart"></div>
	
		<%@page import="fusioncharts.FusionCharts"%>
	
		<% 
		    	Gson gson = new Gson();
		        
		        // Form the SQL query that returns the top 10 most populous countries
		        String sql="SELECT url, nb_vues FROM url";
		
		        // Execute the query.
		        PreparedStatement pt = con.prepareStatement(sql);    
		        ResultSet rs = pt.executeQuery();
		        
		        // The 'chartobj' map object holds the chart attributes and data
		        Map<String, String> chartobj = new HashMap<String, String>();
		        
		        chartobj.put("caption", "Statistique URL pour toute les valeurs");
		        chartobj.put("showValues", "0");
	            chartobj.put("theme", "zune");
	
	            // Push the data into the array using map object.
	            ArrayList arrData = new ArrayList();
	            while(rs.next())
	            {
	                Map<String, String> lv = new HashMap<String, String>();
	                lv.put("label", rs.getString("url"));
	                lv.put("value", rs.getString("nb_vues"));
	                arrData.add(lv);    
	                //System.out.println(lv);
	            }
	            
	            //close the connection.
	            rs.close();
	            
	          	//create 'dataMap' map object to make a complete FC datasource.
	            Map<String, String> dataMap = new LinkedHashMap<String, String>();  
	
	            dataMap.put("chart", gson.toJson(chartobj));
	            dataMap.put("data", gson.toJson(arrData));
	
	          	FusionCharts columnChart = new FusionCharts(
	           		"column2d",// chartType
	                "chart1",// chartId
	                "600","400",// chartWidth, chartHeight
	                "chart",// chartContainer
	                "json",// dataFormat
	                gson.toJson(dataMap) //dataSource
				);
	          	
	          	 //System.out.println(dataMap);
			%>
	
		<%=columnChart.render()%>

	</body>
	
	<jsp:include page="footer.jsp"/>
	
</html>