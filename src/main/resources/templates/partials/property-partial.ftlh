<#macro propertyList properties totalPages=0 currentPage=0 totalElements=0 pageSize=0>
    <table class="table table-dark table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Property ID</th>
                <th>Address</th>
                <th>House Type</th>
                <th>Year of construction</th>
                <th>Owner</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
        <#list properties as property>
            <tr>
                <td>
                    <a href="/admin/properties/${property.id}">${property.id}
                    </a>
                </td>
                <td>${property.propertyID</td>
                <td>${property.address}</td>
                <td>${property.houseType}</td>
                <td>${property.yearOfConstruction?c}</td>
                <td>${property.user}</td>
                <td>
                    <a class="btn btn-link" href="/admin/properties/edit/${repair.id}">
                        <span data-feather="tool"></span>
                    </a>
                </td>
                <td>
                    <button class="feather-hover btn btn-link trash-style" data-toggle="modal" data-target="#exampleModalCenter"
                            data-id="${property.id}">
                        <span  data-feather="trash-2"></span>
                    </button>
                    <#include "delete-property-modal.ftlh">
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
                            <a class="page-number-link ml-1 px-3 btn btn-outline-info<#if currentPage == i> active</#if>" href="/admin/properties?page=${i}" style="color: white;">${i}</a>
                        </#list>
                    </td>
                </tr>
            </#if>
        </tbody>
    </table>
</#macro>

<#macro propertySingle property>
    <table class="table table-dark table-striped">
        <tbody>
            <tr>
                <td class="font-weight-bold">#</td>
                <td>${property.id}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Property ID</td>
                <td>${property.propertyID}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Address</td>
                <td>${property.address}</td>
            </tr>

            <tr>
                <td class="font-weight-bold">House Type</td>
                <td>${property.houseType}</td>
            </tr>
            <tr>
                <td class="font-weight-bold">Year of construction</td>
                <td>${property.yearOfConstruction?c} </td>
            </tr>
            <tr>
                <td class="font-weight-bold">Owner</td>
                <td>${repair.user}</td>
            </tr>
        </tbody>
    </table>
    <table style="width: 100%">
        <tr>
            <td>
                <form action="/admin/properties/edit/${property.id}">
                    <input type="submit" class="btn-primary btn-block btn-lg" value="Edit"></input>
                </form>
            </td>
            <td>
                <form>
                    <input type="button" class="btn-danger btn-block btn-lg" data-toggle="modal" data-target="#exampleModalCenter" data-id="${property.id}" value="Delete"></input>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
    <#include "../partials/delete-property-modal.ftlh">
</#macro>