<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>

</head>
<body>

	<script>
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
	</script>

	<div class="container mb-3 mt-3">
		<table class="table table-striped table-bordered" id="myTable"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<th data-sortable="true" scope="col">Code_commune_INSEE</th>
					<th scope="col">Nom_commune</th>
					<th scope="col">Code_postal</th>
					<th scope="col">Libelle</th>
					<th scope="col">Ligne_5</th>
					<th scope="col">Latitude</th>
					<th scope="col">Longitude</th>
					<th scope="col"><a href="/ESEO_TP_C">Retour</a></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listevilles}" var="ville">
					<tr>
						<th scope="row">${ville.getCode_commune_INSEE()}</th>
						<td>${ville.getNom_commune()}</td>
						<td>${ville.getCode_postal()}</td>
						<td>${ville.getLibelle_acheminement()}</td>
						<td>${ville.getLigne_5()}</td>
						<td>${ville.getLatitude()}</td>
						<td>${ville.getLongitude()}</td>
						<td><a
							href="/ESEO_TP_C/listeville/modifier?insee=${ville.getCode_commune_INSEE()}"><button
									type="button" class="btn btn-primary">Modifier</button></a></td>
						<td><form method="post">
								<button name="delete" value="${ville.getCode_commune_INSEE()}"
									type="submit" class="btn btn-danger">X</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>