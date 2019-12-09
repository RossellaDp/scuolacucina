<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione utente</title>
</head>
<body>

<form action="IscrizioneServlet" method="POST">

<br>
<b>IdUtente:</b><input placeholder ="idUtente" type = "text" name="idUtente" maxlength="30" required> <br>
<br>

<br>
<b>Password:</b><input placeholder ="password" type = "password" name="password" maxlength="30" required> <br>
<br>

<br>
<b>Nome:</b><input placeholder ="nome" type = "text" name="nomecorsista" maxlength="30" required> <br>
<br>

<br>
<b>Cognome:</b><input placeholder ="cognome" type = "text" name="cognomecorsista" maxlength="30" required><br>
<br>

<br>
<b>Data di Nasctita:</b><input placeholder ="data" type = "date" name="dataNascita" required><br>
<br>

<br>
<b>Email:</b><input placeholder ="email" type = "text" name="email" maxlength="30" required> <br>
<br>

<br>
<b>Telefono:</b><input placeholder ="telefono" type = "text" name="telefono" maxlength="30" required> <br>
<br>

<input type="submit" value="Invia">
</form>
</body>
</html>