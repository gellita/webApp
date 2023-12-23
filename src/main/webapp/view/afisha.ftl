
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./resources/styles/index.css">
    <link rel="stylesheet" href="./resources/styles/afisha.css">
    <title>Afisha</title>
</head>
<body>
<header></header>
<#include "header.ftl">
<h1>Свежие события</h1>
<#list events as event>
    <div class="events">
        <div class="event">
            <img src="${event.photo}" alt="event img">
            <div class="description">
                <p>${event.name}</p>
                <p>${event.date}</p>
                <a href="${event.link}" target="_blank">
                    <button class="buy__ticket__btn">Купить билет</button>
                </a>
                <button class="favorite-btn" onclick="toggleFavorite()">️</button>
            </div>
        </div>
    </div>

</#list>

<script src="./resources/js/script.js" ></script>
</body>
</html>