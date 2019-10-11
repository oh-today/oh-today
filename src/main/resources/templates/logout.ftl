<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
    <title>退出 &mdash; Spring Cloud Sample</title>

    <!-- General CSS Files -->
    <link rel="stylesheet" href="assets/modules/bootstrap/css/bootstrap.min.css">
    <!-- Template CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
<div id="app">
    <section class="section">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
                    <div class="login-brand">
                        <h1>Oh Today</h1>
                    </div>

                    <div class="card card-primary">
                        <div class="card-header"><h4>退出登录</h4></div>

                        <div class="card-body">
                            <p class="text-muted">你确定要退出吗？</p>
                            <form method="POST" action="/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block" tabindex="4">
                                       退出登录
                                    </button>
                                </div>
                            </form>
                        </div>
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


</body>
</html>
