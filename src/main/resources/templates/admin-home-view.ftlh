<html>
    <head>

        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width initial-scale=1.0" />
        <title>Admin - Home</title>
    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Date</th>
                    <th>Address</th>
                    <th>State</th>
                    <th>User ID</th>
                </tr>
            </thead>

            <tbody>
                <#list activeRepairs as repair>
                    <tr>
                        <td>${repair.id}}</td>
                        <td>${repair.date}</td>
                        <td>${repair.address}</td>
                        <td>${repair.state}</td>
                        <td>${repair.user.id}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </body>

</html>