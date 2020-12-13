<#import "/spring.ftl" as spring />
<#import "../partials/owner-partial.ftlh" as ownerComponent />
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">
    <#include "../partials/navbar.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <title>Search</title>
</head>

<body>


<div class="container-fluid">
    <div class="row">

        <#include "../partials/beginContainerWithSidebar.ftlh">

        <main role="main" class="col-md-12 ml-xsm-auto col-lg-12 pt-3 px-4">
            <div class="row">
                <div class="col-md-12 order-md-1">
                    <#include "../forms/searchByEmailForm.ftlh">
                </div>
            </div>
        </main>
    </div>
</div>

<#include "../partials/scripts.ftlh">
<#include "../partials/script-datepicker.ftlh">
<#include "../partials/endContainerWithSidebar.ftlh">
</body>
</html>