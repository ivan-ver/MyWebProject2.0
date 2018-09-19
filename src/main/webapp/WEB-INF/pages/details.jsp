<!DOCTYPE html>
<html lang="java">
<head>
    <meta charset="UTF-8">
    <title>Detail List</title>

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
    <h1>Add Detail</h1>
    <a href="/addDetail">
        <p><button>Add Detail</button>
    </a>
    <h1>Search details</h1>
    <form name="search" action="/search" method="get">
        <input title="detailSearch" type="text" name="detailSearch">
        <input type="submit" value="SEARCH">
    </form>
    <a href="/">
        <p><button>BACK</button>
    </a>
    <h1>Details list</h1>
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




</body>
</html>