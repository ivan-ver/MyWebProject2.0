<!DOCTYPE html>
<html>
<head>
    <title>Type list</title>
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
<h1>Type list</h1>
<table>
    <tr>
        <th>Type</th>
        <th>Count</th>
        <th>Necessity</th>
    </tr>
    <#list types as t>
        <tr>
            <td><a href="/type/${t.typeName}">${t.typeName}</a></td>
            <td>${t.count}</td>
            <td>${t.necessity}</td>
        </tr>
    </#list>
        <tr>
            <th>It is possible to assemble</th>
            <th>${compNumbers}</th>
            <th>computer(s)</th>
        </tr>
</table>
<a href="/">
    <p><button>HOME</button>
</a>
</body>
</html>
