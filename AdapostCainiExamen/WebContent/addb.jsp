<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adauga un caine</title>
<jsp:include page="/jsp/common/head_imports.jsp" />
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<jsp:include page="/jsp/common/sidebar.jsp" />
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<div class="card card-primary card-outline">
								<div class="card-header"></div>
								<div class="card-body">

									<h1>Adaugare beneficiari</h1>
<form:form action="${pageContext.request.contextPath}/adaugare-beneficiari-save.htm" method="post" modelAttribute="beneficiariForm">
<div class="form-group">
<label for="nume">Nume</label>
<form:input path="nume" class ="form-control"/><br/></div>
<div class="form-group">
<label for="varsta">Varsta</label>
<form:input path="varsta" class ="form-control"/><br/></div>
<div class="form-group">
<label for="adresa">Adresa</label>
<form:input path="adresa" class ="form-control"/><br/></div>

<div class="form-group">
	<label for="caineID">Caine adoptat</label>
	<form:select path="caineID" class ="form-control"><br/></div>
	<form:options items="${caini}" itemValue="id" itemLabel="nume"/>
	</form:select>
<input class="btn btn-primary" type="submit" value="Salveaza"/><br/>
</form:form>
</br>

<a href="<c:url value="/listb.htm"/>">Inapoi la lista</a>

								</div>
							</div>
						</div>
						<!-- /.col-md-6 -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<jsp:include page="/jsp/common/footer.jsp" />

	</div>
	<!-- ./wrapper -->

	<jsp:include page="/jsp/common/bottom_imports.jsp" />

</body>
</html>

