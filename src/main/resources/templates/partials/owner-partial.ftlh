<#macro ownerList owners>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>AFM</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <#list owners as owner>
            <tr>
                <td>
                    <a href="/admin/owners/${owner.id}">${owner.id}
                    </a>
                </td>
                <td>${owner.afm?c}</td>
                <td>${owner.email}</td>
                <td>${owner.firstName}</td>
                <td>${owner.lastName}</td>
                <td>${owner.address}</td>
                <td>${owner.phoneNumber?c}</td>
                <td>
                    <a href="/admin/owners/edit/${owner.id}">
                        <span data-feather="tool"></span>
                    </a>
                </td>
                <td>
                    <a href="/admin/owners/delete${owner.id}">
                        <span data-feather="x"></span>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</#macro>

<#macro ownerSingle owner>
    <table class="table table-dark table-striped">
        <tbody>
        <tr>
            <td class="font-weight-bold">#</td>
            <td>${owner.id}</td>
        </tr>
        <tr>
            <td class="font-weight-bold">Afm</td>
            <td>${owner.afm?c}</td>
        </tr>
        <tr>
            <td class="font-weight-bold">Email</td>
            <td>${owner.email}</td>
        </tr>
        <tr>
            <td class="font-weight-bold">First Name</td>
            <td>${owner.firstName}</td>
        </tr>
        <tr>
            <td class="font-weight-bold">Last Name</td>
            <td>${owner.lastName}</td>
        </tr>
        <tr>
            <td class="font-weight-bold">Address</td>
            <td>${owner.address}</td>
        </tr>
        <tr>
            <td class="font-weight-bold">Phone Number</td>
            <td>${owner.phoneNumber?c}</td>
        </tr>
    </table>
    <table style="width: 100%">
        <tr>
            <td>
            <form action="/admin/owners/edit/${owner.id}">
                <input type="submit" class="btn-primary btn-block btn-lg" value="Edit"></input>
            </form>
            </td>

            <td>
            <form action="/admin/owners/delete/${owner.id}" method="post">
                <input type="submit" class="btn-danger btn-block btn-lg" value="Delete"></input>
            </form>
            </td>
        </tr>
        </tbody>
    </table>
</#macro>