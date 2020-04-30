<!DOCTYPE HTML>

<head>
    <title>current exchange rates</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="shortcut icon" type="image/x-icon"
          href="https://cdn4.iconfinder.com/data/icons/money-transaction/100/Untitled-1-03-512.png">
</head>
<body>
    <form action="/addNewUser" method="POST">

        <#if (exceptionMsg != "OK")>
            you entered the following error while entering: ${exceptionMsg}
        </#if>

        <table>
            <tr>
                <td>username:</td>
                <td><input type="text" name="username" value="username"></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email" value="email"></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </td>
                <td><input type="submit" value="add user" /></td>
            </tr>

        </table>
    </form>
    <table>
        <tr>
            <td>id</td>
            <td>user</td>
            <td>email</td>
        </tr>

        <#foreach user in userList>
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getEmail()}</td>

        </tr>
        </#foreach>
    </table>
    <form action="/" method="GET">
        <input type="submit" value="Go to home page">
    </form>

</body>