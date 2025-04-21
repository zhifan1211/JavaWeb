<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Guestbook</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
	</head>
	<body style="padding: 20px">
		<div>
			<h2>訪客留言板</h2>
			<form class="pure-form" method="POST" action"/JavaWeb/Guestbook">
				<fieldset>
					<legend>Guestbook Form</legend>
					<label>留言:</label>
					<input name="message" type="text" required />
					<p />
					<button type="submit" class="pure-button pure-button-primary">送出</button>
				</fieldset>
			
			</form>
		</div>
	</body>
</html>