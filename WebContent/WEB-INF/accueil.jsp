<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<div class="container mt-5">
		<form method="post" action="">
		<div class="card-group">
			<div class="card">
				<img class="card-img-top"
					src="https://www.angers-developpement.com/wp-content/uploads/2018/09/PalmaresEXPRESS2018.png"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Ville 1</h5>
					<p class="card-text">Sélectionner ici une première ville</p>
					<div>
					<select class="custom-select" name="selectville1" size="1">
						<c:forEach items="${listevilles}" var="ville" varStatus="status">
							<option name="ville1" value="${ville.getCode_commune_INSEE()}">${ville.getNom_commune()}</option>
						</c:forEach>
					</select>
					</div>
				</div>
			</div>
			<div class="card text-white text-center p-3">
				<img class="card-img-top mt-5"
					src="https://www.archifacile.fr/objet/pointille-m14129.png"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Calcul de distance</h5>
					<a href="/ESEO_TP_C/listeville">
						<button type="button" class="btn btn-dark">Voir la liste des villes</button>
					</a>
				</div>
			</div>
			<div class="card">
				<img class="card-img-top"
					src="https://www.posadas-patrimoine.com/images/userupload/7e5fae0046224da7cc0d435e6c1bf520.jpg"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Ville 2</h5>
					<p class="card-text">Sélectionner ici une deuxième ville</p>
					<div>
					<select class="custom-select" name="selectville2" size="1">
						<c:forEach items="${listevilles}" var="ville" varStatus="status">
							<option name="ville2" value="${ville.getCode_commune_INSEE()}">${ville.getNom_commune()}</option>
						</c:forEach>
					</select>
					</div>
					<p class="card-text">Puis cliquez sur calculer pour connaitre
						la distance</p>
						<div>
						<input type="submit" value="Calculer" class="btn btn-info"/>
						</div>
				</div>
			</div>
		</div>
		</form>
	</div>
	<div class="container mt-5">
	<c:if test="${ !empty sessionScope.distance }">
						<h4>La distance entre <c:out value="${sessionScope.ville1}"></c:out> et  
						<c:out value="${sessionScope.ville2}"></c:out>
						est de <c:out value="${sessionScope.distance}"></c:out> KM</h4></c:if>
	</div>

</body>
</html>