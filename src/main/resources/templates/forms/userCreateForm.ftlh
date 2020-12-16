<#ftl output_format="HTML" strip_whitespace=true>
<#import "/spring.ftl" as spring />
<div class="container-fluid">

    <div class="row">
        <div class="col">
            <h1>Create Owner</h1>
            <#if errorMessage??>
                <h3 style="color: #dc3545">${errorMessage!""}</h3>
            </#if>
        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <form id="userForm" name="userForm" action="/admin/owners/create" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <@spring.bind "userForm.email"/>
                    <input type="email" class="form-control" id="email" name="email" placeholder="email@address.com" value="${spring.status.value!""}">
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
                    <input type="text" class="form-control" id="afm" name="afm" placeholder="123456789" value="${spring.status.value!""}">

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
                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="John" value="${spring.status.value!""}">
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
                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Smith" value="${spring.status.value!""}">
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
                            <input type="text" class="form-control" id="address" name="address" placeholder="Kavalas St. 105, Athens" value="${spring.status.value!""}">
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
                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Must contain 10 digits" value="${spring.status.value!""}">
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
                    <input type="password" class="form-control" id="password" placeholder="Choose a password" name="password">
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
                                        <#if spring.status.value??>
                                            <#if type == spring.status.value>
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
                <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
            </form>
        </div>
    </div>
</div>