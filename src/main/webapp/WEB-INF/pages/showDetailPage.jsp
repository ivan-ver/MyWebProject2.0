<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Details Info</title>

    <style type="text/css">
        table{
            margin-left: 20px;
            margin-right: 20px;
            border: thin solid black;
            caption-side: bottom;
            text-align: center;
        }
        td,th{
            border: thin solid black;
            padding: 5px;
            text-align: center;
        }
    </style>

</head>
<body>
    <h1>Details Info</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Count</th>

            </tr>
            <#list details as d>
                <tr>
                    <td>${d.id}</td>
                    <td>${d.name}</td>
                    <td>${d.count}</td>

                </tr>
            </#list>
        </table>

    <a href="/types">
        <p><button>BACK</button>
    </a>
</body>
</html>