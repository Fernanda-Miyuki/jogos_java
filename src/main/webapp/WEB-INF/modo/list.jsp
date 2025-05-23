<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Modos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>Modos</h1>
            <a href="/modos/insert" class="btn btn-primary">Novo Modo</a>
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>descricao</th>
                </tr>
                <c:forEach var="m" items="${modos}">
                    <tr>
                        <td>${m.id}</td>
                        <td>${m.descricao}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>