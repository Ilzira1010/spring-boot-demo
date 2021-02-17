<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <section class="mt-5 mb-4">
        <div class="row">
            <div class="col"></div>
            <div class="col-8 align-self-center">
                <div class="card wish-list mb-4">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="mb-4 text-black-80 mt-0 font-weight-bold">Registration</h3>
                            <div class="alert alert-danger fade show" role="alert">
                            </div>
                            <form action="/signUp" autocomplete="off" method="post" id="form">
                                <div class="form-group">
                                    <span class="text-black-50">Nickname</span>
                                    <input id="nickname-signup" type="text" class="form-control" name="nickname" required>
                                </div>
                                <div class="form-group">
                                    <span class="text-black-50">Email</span>
                                    <input id="email-signup" type="email" data-verify="email" class="form-control"
                                           name="email"
                                           required>
                                </div>
                                <div class="form-group">
                                    <span class="text-black-50">Password</span>
                                    <input id="password-signup" type="password" class="form-control" name="password"
                                           title="Password should consist of latin alphabet and must contains letter with capital case and at list one num"
                                           required>
                                </div>
                                <div class="form-group">
                                    <span class="text-black-50">Repeat password</span>
                                    <input id="password-rep-signup" type="password" class="form-control"
                                           name="password-repeat"
                                           required>
                                </div>
                                <button class="btn btn-primary btn-lg btn-block waves-effect waves-light" id="submit" type="submit">
                                    Sign Up
                                </button>
                            </form>
                            <hr>
                            <p><a href="/signIn" class="text-secondary">Sign In?</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </section>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<#--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bo.." integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<#--<script src="${pageContext.request.contextPath}/views/static/bootstrap.bundle.js"></script>-->
</body>
</html>
