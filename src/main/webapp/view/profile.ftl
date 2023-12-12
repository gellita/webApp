<#-- @ftlvariable name="user" type="ru.itis.go_standup.dto.UserDTO" -->

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./resources/styles/index.css">
    <title>Profile</title>
</head>
<body>
<header>
</header>
<#include "header.ftl">
<section>
    <div class="img__container">
        <img src="./resources/images/avatar.png" alt="avatar">
    </div>
    <div class="user__container">
        <div class="user__inf">
            <div class="user__bio">${user.firstName}</div>
            <div class="user__bio">${user.lastName}</div>
            <div class="user__bio">${user.email}</div>
        </div>
        <p><a href="sign-out">Выйти из аккаунта</a></p>
    </div>

</section>

</body>
</html>