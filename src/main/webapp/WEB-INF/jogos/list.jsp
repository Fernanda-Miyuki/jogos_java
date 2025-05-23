<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Jogos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Jogos</h1>
        <a href="/jogos/insert" class="btn btn-primary mb-3">Novo Jogo</a>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Modo</th>
                    <th>Plataformas</th>
                    <th>Gêneros</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="j" items="${jogos}">
                    <tr>
                        <td>${j.id}</td>
                        <td>${j.titulo}</td>
                        <td>${j.modo.descricao}</td>
                        <td>
                            <c:forEach var="p" items="${j.plataformas}">
                                ${p.descricao}<br />
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="g" items="${j.generos}">
                                ${g.nome}<br />
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/jogos/update/${j.id}" class="btn btn-primary btn-sm">Editar</a>
                            <a href="/jogos/delete/${j.id}" class="btn btn-danger btn-sm">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
