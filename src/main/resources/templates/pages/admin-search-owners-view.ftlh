<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <title>Search</title>
</head>

<body>

<#include "../partials/navbar.ftlh">

<div class="container-fluid">
    <div class="row">

        <#include "../partials/sidebar.ftlh">

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
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

</body>
</html>