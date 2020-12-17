<#import "../partials/owner-partial.ftlh" as ownerComponent>
<#include "../partials/top-design.ftlh">
        <title>Admin - Owners</title>
    </head>
    <body>
        <!-- header here -->
        <#include "../partials/navbar.ftlh">
        <#include "../partials/beginContainerWithSidebar.ftlh">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <#--<#if owners?has_content>-->
                    <#if owners?has_content>
                    <h1>Owners</h1>
                    <#else>
                    <h3>There are no Owners</h3>
                    </#if>
                </div>
            </div>

            <div class="row">
                <div class="col" style="overflow-x: auto;">
                    <#if owners?has_content && owners.getContent()?is_sequence>
                        <@ownerComponent.ownerList owners.getContent(), owners.totalPages, owners.getNumber() + 1, owners.totalElements, owners.getSize()/>
                    </#if>
                </div>
            </div>

        <!-- footer here -->

            <#-- scrips -->
            <#include "../partials/scripts.ftlh">
    </body>
</html>