<!DOCTYPE html>
<html lang="java">
<head>
    <meta charset="UTF-8">
    <title>Detail list</title>

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
        .page{
            display: inline-block;
        }
    </style>


</head>
<body>

    <h1>Search detail</h1>
    <form name="search" action="/search" method="get">
        <input title="detailSearch" type="text" name="detailSearch">
        <input type="submit" value="SEARCH">
    </form>

    <h1>Detail list</h1>
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
                <td><a href="/delete/${det.id}"><p><button>Delete</button></a></td>
                <td><a href="/update/${det.id}"><p><button>Update</button></a></td>
            </tr>
        </#list>
    </table>
    <div>
        <#list pageNumb as p>
            <div class="page"><td><a href="/details/${p}"><p><button>${p}</button></a></td></div>
        </#list>
    </div>


        <a href="/">
            <p><button>HOME</button>
        </a>
</body>
</html>