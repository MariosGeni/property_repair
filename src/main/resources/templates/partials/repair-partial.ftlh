<#macro repairList repairs>
    <table class="table table-dark table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Date</th>
                <th>Address</th>
                <th>State</th>
                <th>Repair Type</th>
                <th>Cost</th>
                <th>Owner</th>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
        <#list repairs as repair>
            <tr>
                <td>
                    <a href="/admin/repairs/${repair.id}">${repair.id}
                    </a>
                </td>
                <td>${repair.date}</td>
                <td>${repair.address}</td>
                <td>${repair.state}</td>
                <td>${repair.repairType}</td>
                <td>${repair.cost} &euro;</td>
                <td>${repair.user}</td>
                <td>${repair.description}</td>
                <td>
                    <a href="/admin/repairs/edit/${repair.id}">
                        <span data-feather="tool"></span>
                    </a>
                </td>
                <td>
                    <a href="/admin/repairs/delete/${repair.id}">
                        <span data-feather="x"></span>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</#macro>

<#macro repairSingle repair>
    <table class="table table-dark table-striped">
        <tbody>
        <tr>
            <td class="font-weight-bold">#</td>
            <td>${repair.id}</td>
        </tr>
        <tr>
            <td class="font-weight-bold">Date</td>
            <td>${repair.date}</td>
        </tr>
            <tr>
                <td class="font-weight-bold">State</td>
                <td>${repair.state}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Repair Type</td>
                <td>${repair.repairType}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Cost</td>
                <td>${repair.cost} &euro;</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Owner</td>
                <td>${repair.user}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Description</td>
                <td>${repair.description}</td>
            </tr>
        </tbody>
    </table>
    <table style="width: 100%">
        <tr>
            <td>
                <form action="/admin/repairs/edit/${repair.id}">
                    <input type="submit" class="btn-primary btn-block btn-lg" value="Edit"></input>
                </form>
            </td>

            <td>
                <form action="/admin/repairs/delete/${repair.id}" method="post">
                    <input type="submit" class="btn-danger btn-block btn-lg" value="Delete"></input>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</#macro>