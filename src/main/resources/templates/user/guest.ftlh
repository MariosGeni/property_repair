<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/user.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body style="background-color:#2b2b2b;">

<div id="snow"></div>

<#-- Head of the Body -->

<div>
    <nav class="navbar sticky-top navbar-expand-lg navbar-light" style="background-color:#EE9600">
       <a href="/"> <img src="/images/OBOBOMASTORAS.png" class="navbar-brand" alt="logo"> </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"></ul>

        <form class="form-inline" id="guestForm"  name="guestForm" action="" method="post">
            <button type="submit" style="margin-right: auto" class="btn btn-lg btn-dark">
                Sign-In
            </button>
        </form>
        </div>
    </nav>
</div>

<#-- Head of the Body -->


<#-- Main Body -->

<div class="container mt-lg-5">
    <div class="row">
        <div class="col">
            <div id="card"  >
                <img class="card-img-top" src="/images/why_us.png"  alt="Card image cap" id="images">
                <div class="card-body">
                    <h4 id="h4" class="card-title">Why Us</h4>
                        <p class="card-text text-center">We are in the business for 25 years, we use eco-friendly materials and the most important? We see satisfaction in our customers' faces</p>
                </div>
            </div>
        </div>

        <div class="col">
            <div id="card" >
                <img class="card-img-top" src="/images/low_price.png"  alt="Card image cap" id="images">
                <div class="card-body">
                    <h4 id="h4" class="card-title">Low Cost</h4>
                    <p class="card-text text-center">We promptly and responsibly cover any house repair. We use premium materials with low cost, we fix your home and we do not drain your wallet</p>
                </div>
            </div>
        </div>

        <div class="col">
            <div id="card" >
                <img class="card-img-top" src="/images/tools.jpg"   alt="Card image cap" id="images">
                <div class="card-body">
                    <h4 id="h4" class="card-title">Range of Services</h4>
                    <p class="card-text text-center">We provide a complete range of services, from changing a light bulb and giving advice to small or large renovations, in order to meet all your needs.</p>
                </div>
            </div>
        </div>

    </div>
</div>

<#-- Main Body -->


<#-- Footer -->

<footer class="footer fixed-bottom">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-md-6">
            </div>
        </div>
    </div>
    <div id="footer-text" class="footer-copyright text-center py-3">Copyright © 2020:
        Obobomastoras.com All Rights Reserved
    </div>
</footer>

<#-- Footer -->

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<#include "../partials/scripts.ftlh">
</body>

</html>