<!DOCTYPE HTML>

<head>
    <title>current exchange rates</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="shortcut icon" type="image/x-icon"
          href="https://cdn4.iconfinder.com/data/icons/money-transaction/100/Untitled-1-03-512.png">
</head>
<body>
    my username: ${username}

    <form name='f' action="changeData" method='POST'>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <table>
            <tr>
                <td>email: </td>
                <td>${email}</td>
                <td>

                </td>
            </tr>
            <tr>
                <td>password: </td>
                <td>hidden</td>
                <td>
                    <input type="text" name="password" value="password">
                </td>
                <td>
                    <input type="submit" value="change my password"/>
                </td>
            </tr>
        </table>
    </form>
    <#if (exceptionMsg != "OK")>
        you made the following error while entering: ${exceptionMsg}
    </#if>
</body>