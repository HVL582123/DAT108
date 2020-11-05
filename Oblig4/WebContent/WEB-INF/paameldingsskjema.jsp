<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>

</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" value="${skjema.fornavn}" />
					 <font id=feilFnavn color="red">${skjema.feilFornavn}</font>
			</div>
			
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" value="${skjema.etternavn}" />
					 <font id="feilEnavn" color="red">${skjema.feilEtternavn}</font>
			</div>
			
			<div class="pure-control-group">
				<label for="mobilnr">Mobil:</label> <input type="text" 
				name="mobilnr" value="${skjema.mobilnr}" /> 
					<font id="feilMnr" color="red">${skjema.feilMobilnr}</font>
			</div>
			
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input 
				type="password" name="passord" value="" /> 
				<font id="feilPass" color="red">${skjema.feilPassord}</font>
			</div>
			
			<div class="pure-control-group">
				<label for="passordMatch">Passord repetert:</label> <input
					type="password" name="passordMatch" value="" /> 
					<font id="feilPassMatch" color="red">${skjema.feilPassordMatch}</font>
			</div>
			
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" />mann <input type="radio" name="kjonn"
					value="kvinne" />kvinne 
					<font id="feilK" color="red">${skjema.feilKjonn}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>