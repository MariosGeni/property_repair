<#import "partials/repair-partial.ftlh" as repairComponent />
<html lang="en">
    <head>
        <#include "partials/html-header-partial.ftlh">
        <title>Admin - Home</title>
    </head>
    <body>
        <a href="/admin/owners">Owners</a>
        <a href="/admin/repairs">Repairs</a>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Today's Repairs</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <#if activeRepairs?has_content && activeRepairs?is_sequence>
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
                            <#list activeRepairs as repair>
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
                    </#if>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12" style="overflow: auto">
                    <@repairComponent.repairList repairs=activeRepairs />
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <@repairComponent.repairSingle repair=activeRepairs[0] />
                </div>
            </div>
        </div>
    </body>
</html>