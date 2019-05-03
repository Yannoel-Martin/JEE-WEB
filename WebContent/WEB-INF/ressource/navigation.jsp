<div class="d-flex justify-content-between navigation">
	<h1 class="h3 mb-0"><a href="/JEE-WEB/connexion-forum">JEE-WEB Forum</a></h1>
	<div class="d-flex">
		<c:if test="${user.role.id == 1}">
			<a href="/JEE-WEB/validation">ADMIN</a>
		</c:if>
		<a href="/JEE-WEB/identification">
			<c:choose>
				<c:when test="${token != ''}">
					<span>${user.name}<i class="fa fa-power-off"></i></span>
				</c:when>
				<c:otherwise>
					<span>Connexion / Inscription</span>
				</c:otherwise>
			</c:choose>
		</a>
	</div>
</div>

<style>
	.navigation { width: 100%; border-bottom: 1px solid black; }
	.navigation h1 { padding: 2px 0px 0px 8px; }
	.navigation a { color: black; }
	.navigation a:hover { text-decoration: none; }
	.navigation a i { font-size:25px; color:red; margin: 8px; }
</style>