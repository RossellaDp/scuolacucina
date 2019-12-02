<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <body>
  <form action="regUtente">
	<table>
	  
		<tr height="50" align="center">
			<th colspan="3" valign="middle">REGISTRAZIONE UTENTE</th>
		</tr>

		<tr height="50" >
			<td width="20%">Username</td>
			<td width="40%"><input type="text" name="idUtente"></td>
			<td width="40%"><c:forEach items="${lista}" var="errore">
								<c:if test="${errore.campoValidato=='idUtente'}" > ${errore.descrizioneErrore}</c:if>
							</c:forEach>
		</tr>
		<tr height="50" >
			<td width="20%">Password</td>
			<td width="40%"><input type="text" name="password"></td>
			<td width="40%"><c:forEach items="${lista}" var="errore">
								<c:if test="${errore.campoValidato=='password'}" > ${errore.descrizioneErrore}</c:if>
							</c:forEach>
		</tr>
		<tr height="50" >
			<td width="20%">Nome</td>
			<td width="40%"><input type="text" name="nome"></td>
			<td width="40%"><c:forEach items="${lista}" var="errore">
								<c:if test="${errore.campoValidato=='nome'}" > ${errore.descrizioneErrore}</c:if>
							</c:forEach>
		</tr>
		<tr height="50" >
			<td width="20%">Cognome</td>
			<td width="40%"><input type="text" name="cognome"></td>
			<td width="40%"><c:forEach items="${lista}" var="errore">
								<c:if test="${errore.campoValidato=='cognome'}" > ${errore.descrizioneErrore}</c:if>
							</c:forEach>
		</tr>
		<tr height="50">
			<td width="20%">Giorno di nascita</td>
			<td width="40%"><select name="giorno">
								<c:forEach begin="1" end="31" var="i" >
									<option value="${i}">${i} </option> 
								</c:forEach>								
							</select> </td></tr>
		<tr height="50"><td width="20%">Mese di nascita</td>
		<td width="40%"><select name="mese">
							<c:forEach begin="1" end="12" var="i" >
								<option value="${i}">${i} </option>				
							</c:forEach>				
						</select> </td></tr>

			
		<tr height="50">
		    <td width="20%">Anno di nascita</td>
			<td width="40%"><input type="text" name="anno"></td> 
			<td width="40%"><c:forEach items="${lista}" var="errore">
								<c:if test="${errore.campoValidato=='anno'}" > ${errore.descrizioneErrore}</c:if>
							</c:forEach></td></tr>
		<tr height="50">
			<td width="20%">EMail</td>
			<td width="40%"><input type="text" name="email"></td>
			<td width="40%"><c:forEach items="${lista}" var="errore">
								<c:if test="${errore.campoValidato=='email'}" > ${errore.descrizioneErrore}</c:if>
							</c:forEach></td></tr>
		
		<tr height="50">
			<td width="20%">Telefono</td>
			<td width="40%"><input type="text" name="telefono"></td>
			<td width="40%"><c:forEach items="${lista}" var="errore">
								<c:if test="${errore.campoValidato=='telefono'}" > ${errore.descrizioneErrore}</c:if>
							</c:forEach></td></tr>
		<tr height="50">
			<th colspan="3" valign="middle"><input type="submit" value="registra" ><br></th>
		</tr>
	</table>
   </form>
  </body>
</html>

