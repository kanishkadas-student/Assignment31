<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter Information of Student</h1>
	${msg }

	<form action="insert" method="post">

		Id : <input type="text" name="id" /><br />
		Name : <input type="text" name="name" /><br />
		<input  type="submit" name="submit" value="submit" />
		<br/>
		<input type="reset" value="reset">
		<!-- a href="../mvc-javaconfig-master"><input type="button" value="Home"></a-->
		
	</form>
</body>
</html>
		
	</form>

</body>
</html>