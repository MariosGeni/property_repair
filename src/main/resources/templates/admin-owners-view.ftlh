<html lang="en">
    <head>
        <#include "partials/html-header-partial.ftlh">
        <title>Admin - Owners</title>
    </head>
    <body>
        <!-- header here -->

        <!-- content here -->
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Owners</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-12" style="overflow: auto;">
                    <#if owners?has_content && owners?is_sequence>
                        <table class="table table-dark table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>AFM</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Phone Number</th>
                                    <th>Property Type</th>
                                </tr>
                            </thead>
                            <tbody>
                            <#list owners as owner>
                                <tr>
                                    <td>${owner.id}</td>
                                    <td>${owner.afm?String}?c</td>
                                    <td>${owner.firstName}</td>
                                    <td>${owner.lastName}</td>
                                    <td>${owner.email}</td>
                                    <td>${owner.address}</td>
                                    <td>${owner.phoneNumber}?c</td>
                                    <td>${owner.houseType}</td>
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