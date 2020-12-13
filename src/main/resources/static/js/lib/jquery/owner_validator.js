jQuery(function ($) {
    $("form[name='userForm']").validate({
        rules: {
            email:{
                required: true,
                email: true
            },
            afm:{
                required: true,
                minLength: 9,
                maxLength: 9,
                digits: true
            },
            firstName:{
                required: true,
                minLength: 4,
                maxLength: 25
            },
            lastName:{
                required: true,
                minLength: 5,
                maxLength: 25
            },
            address:{
                required: true
            },
            phoneNumber:{
                required: true,
                digits: true,
                minLength: 10,
                maxLength: 10
            },
            password:{
                required: true,
                minLength: 5,
                maxLength: 25
            },
            houseType:{
                required: true
            }
        },
        messages: {
            email: {
                required: "Please enter your Email",
                email: "Please use a real Email"
            },
            afm: {
                required: "Please enter your Afm",
                minLength: "Only 9 characters",
                maxLength: "Only 9 characters",
                digits: "Please use only numbers"
            },
            firstName: {
                required: "Please enter your first name",
                minLength: "Between 4-25 characters",
                maxLength: "Between 4-25 characters",
            },
            lastName: {
                required: "Please enter your last name",
                minLength: "Between 5-25 characters",
                maxLength: "Between 5-25 characters"
            },
            address: {
                required: "Please enter your address"
            },
            phoneNumber: {
                required: "Please enter your phone number",
                digits: "",
                minLength: "Only 10 characters",
                maxLength: "Only 10 characters"
            },
            password: {
                required: "Please enter your password",
                minLength: "Between 5-25 characters",
                maxLength: "Between 5-25 characters",
            },
            houseType: {
                required: "Please select one of the above"
            }
        },
        function(form){
            form.submit();
        }
    })
});