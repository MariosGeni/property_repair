<#import "/spring.ftl" as spring />
<html>

<head></head>

<body>

<form id="createForm" action="/admin/owner/create" method="get">

    <label for="email">Email</label>
    <div class="input-group">
        <input type="email" class="form-control" id="email" name="email">
    </div>

    <label for="afm">Afm</label>
    <div class="input-group">
        <input type="text" class="form-control" id="afm" name="afm">
    </div>

    <label for="first_name">First Name</label>
    <div class="input-group">
        <input type="text" class="form-control" id="first_name" name="first_name">
    </div>

    <label for="last_name">Last Name</label>
    <div class="input-group">
        <input type="text" class="form-control" id="last_name" name="last_name">
    </div>

    <label for="address">Address</label>
    <div class="input-group">
        <input type="text" class="form-control" id="address" name="address">
    </div>

    <label for="phone_number">Phone Number</label>
    <div class="input-group">
        <input type="text" class="form-control" id="phone_number" name="phone_number">
    </div>

    <label for="password">Password</label>
    <div class="input-group">
        <input type="text" class="form-control" id="password" name="password">
    </div>

    <label for="house_type">House Type</label>
    <div class="input-group">
        <select class="custom-select d-block w-100" id="house_type" name="house_type">
            <#if booksCategories??>
                <#list house_typeCategories as category>
                    <option value="${category}">${category}</option>
                </#list>
            </#if>
        </select>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
</form>

</body>
</html>