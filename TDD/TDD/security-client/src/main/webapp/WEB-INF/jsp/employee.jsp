<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Employee</title>
</head>
<body>
    <h3 style="color: red;">Get Employee</h3>

    <div id="getEmployee">
        <form:form action="http://localhost:8082/oauth/authorize"
            method="post" modelAttribute="employee">
            <p>
                <label>Enter Security Details</label>
                 <input type="text" name="response_type" value="code" /> 
                 <input type="text" name="client_id" value="iphone" />
                 <input type="text" name="redirect_uri" value="http://localhost:8091/showEmployee" />
                 <input type="text" name="scope" value="read" /> 
                 <input type="SUBMIT" value="Get Employee" />
        </form:form>
    </div>
</body>
</html>