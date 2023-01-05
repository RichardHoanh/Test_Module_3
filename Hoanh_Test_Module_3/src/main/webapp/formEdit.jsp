<%--
  Created by IntelliJ IDEA.
  User: TEO
  Date: 12/26/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Customer</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Edit Form</h2>
    <form action="/edit" method="post">
        <div class="form-group">
            <label>ID:</label>
            <input  class="form-control" placeholder="Enter id" name="id" value="${edit.id}" readonly>
        </div>
        <div class="form-group">
            <label>Name:</label>
            <input  class="form-control" placeholder="Enter name" name="name" value="${edit.name}" >
        </div>
        <div class="form-group">
            <label>Email address:</label>
            <input  class="form-control"  placeholder="Enter email" name="email" value="${edit.email}">
        </div>

        <div class="form-group">
            <label>Date of birth:</label>
            <input  class="form-control" placeholder="Enter date" name="date" value="${edit.date}">
        </div>
        <div class="form-group">
            <label>Address:</label>
            <input  class="form-control"  placeholder="Enter address" name="address" value="${edit.address}">
        </div>

        <div class="form-group">
            <label>Phone Number:</label>
            <input  class="form-control" placeholder="Enter phone" name="phone" value="${edit.phone}">
        </div>

        <div class="form-group">
            <label>Class:</label>
            <input  class="form-control"  placeholder="Enter classroom" name="class" value="${edit.classroom}">
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>