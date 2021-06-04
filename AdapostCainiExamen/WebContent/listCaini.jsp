<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista cainilor din adapost</title>
    <jsp:include page="/jsp/common/head_imports.jsp"/>
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<jsp:include page="/jsp/common/sidebar.jsp"/>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <div class="card card-primary card-outline">
              <div class="card-header">
                <h5 class="m-0">Caini</h5>
              </div>
              <div class="card-body">
              
              <table class="table table-striped">
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>Nume</strong></td>
					<td><strong>Rasa</strong></td>
					<td><strong>Varsta</strong></td>
					
					<td><strong>Detalii</strong></td>
					<td><strong>Editare</strong></td>
					<td><strong>Adoptat</strong></td>
				</tr>
				<c:forEach var="cn" items="${caini}">
					<tr>
						<td><c:out value="${cn.id}"/></td> 
						<td><c:out value="${cn.nume}"/></td>
						<td><c:out value="${cn.rasa}"/></td> 
						<td><c:out value="${cn.varsta}"/></td>
					
						
						<td><a href="<c:url value="/detaliiCaini.htm?id=${cn.id}"/>">Detalii</a></td>
						<td><a href="<c:url value="/editare-caini.htm?id=${cn.id}"/>">Editare</a></td>
						<td><a href="<c:url value="/deleteCaini.htm?id=${cn.id}"/>">Delete</a></td>
					</tr>
				</c:forEach>
				</table>
				<br/><br/>
				<a class="btn btn-primary" href="<c:url value="/adaugare-caini.htm"/>">Caine nou</a>
           
              </div>
            </div>
          </div>
          <!-- /.col-md-6 -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
      <jsp:include page="/jsp/common/footer.jsp"/>
  
</div>
<!-- ./wrapper -->

    <jsp:include page="/jsp/common/bottom_imports.jsp"/>

</body>
</html>