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
        </tr>
        </thead>
        <tbody>
        <#list owners as owner>
            <tr>
                <td>${owner.id!""}</td>
                <td>${owner.afm?c}</td>
                <td>${owner.email}</td>
                <td>${owner.firstName}</td>
                <td>${owner.lastName}</td>
                <td>${owner.address}</td>
                <td>${owner.phoneNumber?c}</td>
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
        </tbody>
    </table>
</#macro>