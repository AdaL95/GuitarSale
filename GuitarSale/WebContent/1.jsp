<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="js/bookstrap.js"></script>
<script src="js/jquery-1.8.2.min.js"></script>

 <script type="text/javascript">
             var type=null;
             var builder=null;
             var topwood=null;
             var backwood=null;
             $("#search").click(function(){
	              alert("213123");	 
             type=$("#type").val();
             builder=$("#builder").val();
             topwood=$("#topwood").val();
             backwood=$("#backwood").val();
	         alert(type);
	filter();
});
function filter() {
	$.get("SearchGuitar", {type:type,builder:builder,topwood:topwood,backwood:backwood},function(n){
			var html = "";
			alert("asdas22");
			$("#result tr").remove();
			for (var i=0; i < n.rows.length; i++) {
			var r = n.rows[i];
			html+="<tr class=\"info\"><td>"+r.type+"</td><td>"+r.builder+"</td><td>"+r.topwood+"</td><td>"+r.backwood+"</td><tr>";
		}
			$("#result").append(html);
	});
}
	
 	
</script>
</body>
</html>