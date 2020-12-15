<#import "/spring.ftl" as spring />
<#import "../partials/owner-partial.ftlh" as ownerComponent />
    <#include "../partials/top-design.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <title>Admin - Create Owner</title>
</head>

<body>
<!-- header here -->
<#include "../partials/navbar.ftlh">
<#include "../partials/beginContainerWithSidebar.ftlh">
<div class="container-fluid">
    <div class="row">
        <main role="main" class="col-md-12 ml-xsm-auto col-lg-12 pt-3 px-4">
            <div class="row">
                <div class="col-md-12 order-md-1">
                    <#include "../forms/userCreateForm.ftlh">
                </div>
            </div>
        </main>
    </div>
</div>
<#include "../partials/endContainerWithSidebar.ftlh">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
<script src="/js/lib/jquery/owner_validator.js"></script>
</body>
</html>

