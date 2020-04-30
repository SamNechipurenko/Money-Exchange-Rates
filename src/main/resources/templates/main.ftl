<!DOCTYPE HTML>

<head>
    <title>current exchange rates</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="shortcut icon" type="image/x-icon"
          href="https://cdn4.iconfinder.com/data/icons/money-transaction/100/Untitled-1-03-512.png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
    <h1>main page</h1>
    Hello, ${username}

        <table class="table">
            <tr>
                <form name='f' action="/account" method='GET'>
                    <input type="hidden" name="exceptionMsg" value="OK"/>
                    <input type="submit" value="account"/>
                </form>
            </tr>
            <tr>
                <form name='f' action="/users" method='GET'>
                    <input type="hidden" name="exceptionMsg" value="OK"/>
                    <input type="submit" value="users"/>
                </form>
            </tr>
            <tr>
                <form name='f' action="/currents" method='GET'>
                    <input type="submit" value="currents"/>
                </form>
            </tr>
        </table>


</body>