

<html>
<head>
    <title>Detail</title>

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
<h1>Search Result</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Count</th>
        <th>Necessity</th>
        <th>Name</th>
    </tr>
    <#list details as det>
    <tr>
        <td>${det.id}</td>
        <td>${det.type}</td>
        <td>${det.count}</td>
        <td>${det.necessity}</td>
        <td>${det.name}</td>
    </tr>
</#list>

</table>
<a href="/details">
    <p><button>BACK</button>
</a>
</body>
</html>
