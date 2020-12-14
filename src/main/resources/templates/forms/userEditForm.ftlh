<#ftl output_format="HTML" strip_whitespace=true>
<#import "/spring.ftl" as spring />
<script src="static/js/lib/jquery/owner_validator.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<div class="container-fluid">

    <div class="row">
        <div class="col">
            <h1>Edit Owner</h1>
            <#if errorMessage??>
                <h3 style="color: #dc3545">${errorMessage!""}</h3>
            </#if>
        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <form id="userForm" name="userForm" action="/admin/owners/edit/" method="post">
                <@spring.bind path="userForm.id"/>
                <input type="hidden" id="id" name="id" value="${owner.id}">
                <div class="form-group">
                    <label for="email">Email</label>
                    <@spring.bind path="userForm.email"/>
                    <input type="email" class="form-control" id="email" name="email" value="${owner.email!""}">
                    <#if spring.status.error??>
                        <ul>
                            <#list spring.status.errorMessages as error>
                                <li style="color: #dc3545">${error}</li>
                            </#list>
                        </ul>
                    </#if>
                </div>

                <div class="form-group">
                    <label for="afm">Afm</label>
                    <@spring.bind "userForm.afm"/>
                    <input type="text" class="form-control" id="afm" name="afm" value="${owner.afm?c!""}">
                    <#if spring.status.error??>
                        <ul>
                            <#list spring.status.errorMessages as error>
                                <li style="color: #dc3545">${error}</li>
                            </#list>
                        </ul>
                    </#if>
                </div>

                <div class="form-group">
                    <label for="first_name">First Name</label>
                    <@spring.bind "userForm.firstName"/>
                    <input type="text" class="form-control" id="first_name" name="firstName" value="${owner.firstName!""}">
                    <#if spring.status.error??>
                        <ul>
                            <#list spring.status.errorMessages as error>
                                <li style="color: #dc3545">${error}</li>
                            </#list>
                        </ul>
                    </#if>
                </div>


                <div class="form-group">
                    <label for="last_name">Last Name</label>
                    <@spring.bind "userForm.lastName"/>
                    <input type="text" class="form-control" id="last_name" name="lastName" value="${owner.lastName!""}">
                    <#if spring.status.error??>
                        <ul>
                            <#list spring.status.errorMessages as error>
                                <li style="color: #dc3545">${error}</li>
                            </#list>
                        </ul>
                    </#if>
                </div>


                <div class="form-row">
                    <div class="col-12 col-md-6">
                        <div class="form-group">
                            <@spring.bind "userForm.address"/>
                            <label for="address">Address</label>
                            <input type="text" class="form-control" id="address" name="address" value="${owner.address!""}">
                            <#if spring.status.error??>
                                <ul>
                                    <#list spring.status.errorMessages as error>
                                        <li style="color: #dc3545">${error}</li>
                                    </#list>
                                </ul>
                            </#if>
                        </div>
                    </div>

                    <div class="col-12 col-md-6">
                        <div class="form-group">
                            <label for="phone_number">Phone Number</label>
                            <@spring.bind "userForm.phoneNumber"/>
                            <input type="text" class="form-control" id="phone_number" name="phoneNumber" value="${owner.phoneNumber?c!""}">
                            <#if spring.status.error??>
                                <ul>
                                    <#list spring.status.errorMessages as error>
                                        <li style="color: #dc3545">${error}</li>
                                    </#list>
                                </ul>
                            </#if>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label for="password">Password</label>
                    <@spring.bind "userForm.password"/>
                    <input type="password" class="form-control" id="password" name="password" value="${owner.password}">
                    <#if spring.status.error??>
                        <ul>
                            <#list spring.status.errorMessages as error>
                                <li style="color: #dc3545">${error}</li>
                            </#list>
                        </ul>
                    </#if>
                </div>


                <div class="form-group">
                    <label for="house_type">House Type</label>
                    <@spring.bind "userForm.houseType"/>
                    <select id="house_type" name="houseType" class="custom-select d-block w-100">
                        <option>Select a type</option>
                        <#if HOUSE_TYPE??>
                            <#list HOUSE_TYPE as type>
                                <option value="${type}"
                                        <#if owner.houseType??>
                                            <#if owner.houseType == type>
                                                selected
                                            </#if>
                                        </#if>
                                >${type}</option>
                            </#list>
                        </#if>
                    </select>
                    <#if spring.status.error??>
                        <ul>
                            <#list spring.status.errorMessages as error>
                                <li style="color: #dc3545">${error}</li>
                            </#list>
                        </ul>
                    </#if>
                </div>
                <button class="btn btn-primary btn-lg mt-4" type="submit">Update</button>
            </form>
        </div>
    </div>
</div>
