<#macro repairList repairs totalPages=0 currentPage=0 totalElements=0 pageSize=0>
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
                <td>${repair.cost?c} &euro;</td>
                <td>${repair.user}</td>
                <td>${repair.description}</td>
                <td>
                    <a class="btn btn-link" href="/admin/repairs/edit/${repair.id}">
                        <span data-feather="tool"></span>
                    </a>
                </td>
                <td>
                    <button class="feather-hover btn btn-link trash-style" data-toggle="modal" data-target="#exampleModalCenter"
                            data-id="${repair.id}">
                        <span  data-feather="trash-2"></span>
                    </button>
                    <#include "delete-repair-modal.ftlh">
                </td>
            </tr>
        </#list>
            <#if (totalPages > 1)>
                <tr>
                     <td colspan="3">
                        <i>Showing ${(currentPage * pageSize) - (pageSize - 1)} to <#if currentPage  < totalPages>${currentPage * pageSize}<#else>${totalElements}</#if> of ${totalElements}</i>
                     </td>
                    <td colspan="7" class="text-right">
                        <#list 1..totalPages as i>
                            <a class="page-number-link ml-1 px-3 btn btn-outline-info<#if currentPage == i> active</#if>" href="/admin/repairs?page=${i}" style="color: white;">${i}</a>
                        </#list>
                    </td>
                </tr>
            </#if>
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
                <td class="font-weight-bold">Address</td>
                <td>${repair.address}</td>
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
                <td>${repair.cost?c} &euro;</td>
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
                <form>
                    <input type="button" class="btn-danger btn-block btn-lg" data-toggle="modal" data-target="#exampleModalCenter" data-id="${repair.id}" value="Delete"></input>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
    <#include "../partials/delete-repair-modal.ftlh">
</#macro>