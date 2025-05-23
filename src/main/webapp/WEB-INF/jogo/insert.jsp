<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Novo Jogo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>Novo Jogo</h1>
            <form action="/jogos/insert" method="post">
                <div>
                    <label class="form-label">Título</label>
                    <input type="text" class="form-control" name="titulo" />
                </div>
                <div>
                    <label class="form-label">Modo</label>
                    <select class="form-select" name="id_modo">
                        <c:forEach var="m" items="${modos}">
                            <option value="${m.id}">${m.descricao}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label class="form-label">Gêneros</label>
                    <c:forEach var="g" items="${generos}">
                        <div class="form-check">
                            <input type="checkbox" name="generos" value="${g.id}" class="form-check-input" />
                            <label class="form-check-label">${g.nome}</label>
                        </div>
                    </c:forEach>
                </div>
                <div>
                    <label class="form-label">Plataformas</label>
                    <c:forEach var="p" items="${plataformas}">
                        <div class="form-check">
                            <input type="checkbox" name="plataformas" value="${p.id}" class="form-check-input" />
                            <label class="form-check-label">${p.descricao}</label>
                        </div>
                    </c:forEach>
                </div>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>

