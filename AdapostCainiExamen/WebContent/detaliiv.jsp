<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voluntar</title>
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

									<h1>Detalii voluntar</h1>
									Id:
									<c:out value="${voluntari.id}" />
									<br /> Nume:
									<c:out value="${voluntari.nume}" />
									<br /> Functie:
									<c:out value="${voluntari.functie}" />
									<br /> Vechime:
									<c:out value="${voluntari.vechime}" />
					
									<br /> <br></br> <a href="<c:url value ="/listv.htm?id=${vl.id}"/>">Inapoi la lista</a>

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