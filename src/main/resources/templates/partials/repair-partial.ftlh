<#macro repairList repairs>
    <h3>Repairs List (macro call repairList)</h3>
    <table class="table table-dark table-striped">
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
        <#list repairs as repair>
            <tr>
                <td>${repair_index + 1}</td>
                <td>${repair.date}</td>
                <td>${repair.address}</td>
                <td>${repair.state}</td>
                <td>${repair.user.id}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</#macro>

<#macro repairSingle repair>
    <h3>Repair Single (macro call repairSingle)</h3>
    <table class="table table-dark table-striped">
        <tbody>
            <tr>
                <td class="font-weight-bold">ID</td>
                <td>${repair.id}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Date</td>
                <td>${repair.date}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Address</td>
                <td>${repair.address}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">State</td>
                <td>${repair.state}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">User ID</td>
                <td>${repair.user.id}</td>
            </tr>
        </tbody>
    </table>
</#macro>