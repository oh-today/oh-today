<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
    <title>登录 &mdash; Spring Cloud Sample</title>

    <!-- General CSS Files -->
    <link rel="stylesheet" href="assets/modules/bootstrap/css/bootstrap.min.css">
    <!-- Template CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/components.css">
</head>

<body>
<div id="app">
    <section class="section">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
                    <div class="login-brand">
<#--                        <img src="assets/img/stisla-fill.svg" alt="logo" width="100" class="shadow-light rounded-circle">-->
                        <h1>Oh Today</h1>
                    </div>

                    <div class="card card-primary">
                        <div class="card-header"><h4>登录</h4></div>

                        <div class="card-body">

                            <div id="error" class="alert alert-warning alert-dismissible show fade" style="display: none">
                                <div class="alert-body">
                                    <button class="close" data-dismiss="alert">
                                        <span>×</span>
                                    </button>
                                   用户名或密码不正确
                                </div>
                            </div>
                            <div id="logout" class="alert alert-info alert-dismissible show fade" style="display: none">
                                <div class="alert-body">
                                    <button class="close" data-dismiss="alert">
                                        <span>×</span>
                                    </button>
                                    已退出登录请重新登录
                                </div>
                            </div>
                            <form method="POST" action="/login" class="needs-validation" novalidate="">

                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="form-group">
                                    <label for="username">用户名</label>
                                    <input id="username" type="text" class="form-control" name="username" tabindex="1" required autofocus>
                                    <div class="invalid-feedback">
                                        请输入您的用户名
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="d-block">
                                        <label for="password" class="control-label">密码</label>
                                        <div class="float-right">
                                            <a href="auth-forgot-password.html" class="text-small">
                                                忘记密码?
                                            </a>
                                        </div>
                                    </div>
                                    <input id="password" type="password" class="form-control" name="password" tabindex="2" required>
                                    <div class="invalid-feedback">
                                        请输入您的用密码
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" name="remember" class="custom-control-input" tabindex="3" id="remember-me">
                                        <label class="custom-control-label" for="remember-me">记住我</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block" tabindex="4">
                                        登录
                                    </button>
                                </div>
                            </form>


                        </div>
                    </div>
                    <div class="mt-5 text-muted text-center">
                        没有帐户? <a href="auth-register.html">注册</a>
                    </div>
                    <div class="simple-footer">
                        Copyright &copy; Oh Today 2019
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- General JS Scripts -->
<script src="assets/modules/jquery.min.js"></script>
<script src="assets/modules/bootstrap/js/bootstrap.min.js"></script>


<!-- Template JS File -->
<script src="assets/js/scripts.js"></script>
<script>
    $(function () {
        var searchString = "?";
        if(location.href.indexOf(searchString)>0){
            var alertName = location.href.split("?")[1];
            $("#"+alertName).css({'display':'block'})
        }
    })
</script>
</body>
</html>
