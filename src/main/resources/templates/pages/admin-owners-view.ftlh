<#import "../partials/owner-partial.ftlh" as ownerComponent>
<html lang="en">
    <head>
        <#include "../partials/html-header-partial.ftlh">
        <title>Admin - Owners</title>
    </head>
    <body>
        <!-- header here -->
        <#include "../partials/beginContainerWithSidebar.ftlh">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Owners</h1>
                </div>
            </div>

            <div class="row">
                <div class="col" style="overflow: auto;">
                    <#if owners?has_content && owners?is_sequence>
                        <@ownerComponent.ownerList owners />
                    </#if>
                </div>
            </div>
        </div>
        <#include "../partials/endContainerWithSidebar.ftlh">

        <!-- footer here -->

            <#-- scrips -->
            <#include "../partials/scripts.ftlh">
    </body>
</html>