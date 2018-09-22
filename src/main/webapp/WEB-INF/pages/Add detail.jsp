<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add detail</title>
</head>
<body>
<h1>Add Detail to DataBase</h1>
<form name="detail" action="/addDetail" method="post">
    <p>Type</p>
    <select name="type">
        <option value="Case">Case</option>
        <option value="CPU">CPU</option>
        <option value="GPU">GPU</option>
        <option value="HDD">HDD</option>
        <option value="Illumination">Illumination</option>
        <option value="Motherboard">Motherboard</option>
        <option value="RAM">RAM</option>
        <option value="Soundcard">Soundcard</option>
        <option value="SSD">SSD</option>
    </select>
    <p>Count</p>
    <input title="count" type="number" min="1" max="999" name="count">
    <p>Necessity</p>
    <input type="radio" name="necessity" value="1" title="YES">YES
    <input type="radio" name="necessity" value="0" title="NO">NO
    <p>Name</p>
    <input title="name" type="text" name="name">
    <input type="submit" value="OK">
</form>

<a href="/">
    <p><button>HOME</button>
</a>

</body>
</html>