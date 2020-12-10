<html lang="en">
    <head>
        <#include "partials/html-header-partial.ftlh">
        <title>Admin - Repairs</title>
    </head>
    <body>
        <!-- header here -->

        <!-- content here -->
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Repairs</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <#if repairs?has_content && repairs?is_sequence>
                        <table class="table table-dark table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Date</th>
                                    <th>Address</th>
                                    <th>Type</th>
                                    <th>State</th>
                                    <th>Owner</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#list repairs as repair>
                                <tr>
                                    <td>${repair.id}</td>
                                    <td>${repair.date}</td>
                                    <td>${repair.address}</td>
                                    <td>${repair.repairType}</td>
                                    <td>${repair.state}</td>
                                    <td>${repair.user.firstName}, ${repair.user.lastName}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </#if>
                </div>
            </div>
        </div>

        <!-- footer here -->
    </body>
</html>