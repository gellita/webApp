<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./resources/styles/index.css">

    <title>Sign Up</title>
</head>
<body>
<header>
    <h1>РЕГИСТРАЦИЯ</h1>
</header>

<form method="post">
    <div class="box">
    <label>
        <input name="firstName" type="text" placeholder="введите имя">
    </label>
    </div>
    <div class="box">
    <label>
        <input name="lastName" type="text" placeholder="введите фамилию">
    </label>
    </div>

    <div class="box">
        <label>
            <input name="email" type="email" placeholder="введите email">
        </label>
    </div>
    <div class="box">
        <label>
            <input name="password"  type="password" placeholder="введите пароль">
        </label>
    </div>
<#--    <div class="box">-->
<#--        <label>-->
<#--            <input type="date" placeholder="введите дату рождения">-->
<#--        </label>-->
<#--    </div>-->
    <p>Уже есть аккаунт?
        <a href="sign-in">Войти</a>
    </p>
    <#if errorMessage??>
        <div class="error_message">${errorMessage}</div>
    </#if>
    <input class="login-button" type="submit">
</form>
</body>
</html>