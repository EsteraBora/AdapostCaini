<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii caini</title>
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

									<h1>Detalii caini</h1>
									Id:
									<c:out value="${caini.id}" />
									<br /> Nume:
									<c:out value="${caini.nume}" />
									<br /> Rasa:
									<c:out value="${caini.rasa}" />
									<br /> Varsta:
									<c:out value="${caini.varsta}" />
									
									<br /> <br></br> <a href="<c:url value ="/listCaini.htm?id=${cn.id}"/>">Inapoi la lista</a>

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