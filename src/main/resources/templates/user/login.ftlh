<html>
    <head>
        <title>Login</title>
        <#include "../partials/head.ftlh" />
        <link rel="stylesheet" type="text/css" href="/css/login.css">
      </head>

      <body class="bg">
          <section class="container-fluid ">
            <section class="row justify-content-center">
                <section class="col-12 col-sm-6 col-md-3">
                    <form class="form-login" action="/login" method="post">
                        <div class="mb-4 mt-2 form-group">
                          <label for="exampleInputEmail1" class="form-label">Email address</label>
                          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
                        </div>
                        <div class="mb-4 form-group">
                          <label for="exampleInputPassword1" class="form-label">Password</label>
                          <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                        </div>
                        <#if RequestParameters.error??>
                            <#if RequestParameters.error == "true">
                                <label class="text-center h5" style="width: 100%; color: #be0f0f;">Wrong username or password.<br />Please Try again</label>
                            </#if>
                        </#if>
                        <button  type="submit" class="btn btn-block bg-dark text-white mt-2 mb-4">Sign in</button>
                        <a class="back-button " href="/">
                           <span data-feather="arrow-left-circle" style="width: 35px; height: 35px; stroke-width: 1.4px"></span>
                        </a>
                        </form>
                </section>
            </section>
          </section>
          <#include "../partials/scripts.ftlh">
      </body>
</html>