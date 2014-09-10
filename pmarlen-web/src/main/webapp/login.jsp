<%@ page pageEncoding="UTF-8" %>

<html>
    <head>
		<title>MAIN_SHORT_TITLE</title>
    </head>

    <body style="background-color: #DCEBF2;">	
		<br/>
		<br/>		
        <form action="j_security_check" method="post" id="loginForm">

			<table class="login_table_panel" border="0">
				<tr>
					<td colspan="3" valign="middle" align="center" style="background-color:gray;">
						MAIN_SYSTEM_ACCESS
					</td>
				</tr>
				<tr>
					<td width="20%" rowspan="6" valign="middle" align="center" >
						IMG-SECURE
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td width="40%" align="right">
						<span style="font-size : 10px;">LOGIN_USER :</span>
					</td>
					<td align="left">
						<input type="text" name="j_username" value="" size="8"/>
					</td>
				</tr>
				<tr>
					<td width="40%" align="right">
						<span style="font-size : 10px;">LOGIN_PASSWORD :</span>
					</td>
					<td align="left">
						<input type="password" name="j_password" value="" size="8"/>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<%
							if (request.getParameter("error") != null) {
						%>
							ERROR AUTHENTICATE
						<%
							} else {
						%>
						<%    
							}
						%>									
					</td>
				</tr>												

				<tr>
					<td colspan="3" width="100%" align="center">										
						<input type="submit" value="COMMON_OK" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>	
</html>
