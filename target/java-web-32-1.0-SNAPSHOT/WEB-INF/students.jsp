<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resourses/css/styles.css">
    <script src="../resourses/js/functions.js"></script>
    <title>Система управления студентами и их успеваемостью</title>
</head>

<body>
<div>
    <div class="header">
        <div class="left-side"></div>
        <div id="title"><h1>Система управления студентами и их успеваемостью</h1></div>
        <div class=" right-side blue-button logout"><span><a href="">Logout</a></span></div>
    </div>
    <div class="main">
        <div class="left-side"><div class="blue-button"><a href="/">На главную</a></div><div class="blue-button"></div></div>
        <div class="center">
            <div class="center-top-buttons">
                <div><input type="submit" value="Просмотреть успеваемость выбранных студентов" class="grey-button-top"/></div>
                <div>
                    <form action="/student-create" method="get">
                    <input type="submit" value="Создать студента..." class="grey-button-top"/>
                    </form>
                </div>
            </div>
            <div class="center-top-buttons">
                <div><input type="submit" onclick="modifyStudent()" value="Модифицировать выбранного студента" class="grey-button-top"/></div>
                <div><input type="submit" onclick="deleteStudents()" value="Удалить выбранных студентов..." class="grey-button-top"/></div>
            </div>

            <div><b class="text">Список студентов</b></div>
            <div>
                <form method="get">
                    <table>
                        <thead class="thead">
                        <tr>
                            <th></th>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Группа</th>
                            <th>Дата поступления</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${students}" var="s">
                        <tr>
                            <td><input type="checkbox" value="${s.id}" name="idStud"></td>
                            <td>${s.surname}</td>
                            <td>${s.name}</td>
                            <td>${s.group}</td>
                            <td><f:formatDate value="${s.date}" pattern="dd/MM/yyyy"/></td>
                        </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </form>
            </div>
        </div>
        <div class="right-side blue-button"><span></span></div>
    </div>
</div>

<form action="/student-delete" method="post" id="formDelete">
    <input type="hidden" value="" name="hiddenDelete" id="hiddenDelete">
</form>

<form action="/student-modify" method="get" id="formModify">
    <input type="hidden" value="" name="hiddenModify" id="hiddenModify">
</form>

</body>