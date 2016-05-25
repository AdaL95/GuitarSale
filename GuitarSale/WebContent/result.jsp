<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
<h1>搜索结果</h1>
      <div class="reta">
			<table class="table">
				<thead>
					<tr>
						<th>
							type
						</th>
						<th>
							price
						</th>
						<th>
							builder
						</th>
						<th>
							backwood
						</th>
						<th>
							topwood
						</th>
					</tr>
				</thead>
				</table>
				</div>
		<c:forEach var="SearchGuitar" item="${requestScope.theGuitars}">
		               
		               <td>${SearchGuitar.type}</td>
		               <td>${SearchGuitar.price}</td>
		               <td>${SearchGuitar.builder}</td>
		               <td>${SearchGuitar.backwood}</td>
		               <td>${SearchGuitar.topwood}</td>        

		</c:forEach>
</body>
</html>