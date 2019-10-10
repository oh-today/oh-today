<#macro layout title activeId sites>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
    <title>oh-today</title>

    <!-- General CSS Files -->
    <link rel="stylesheet" href="/assets/modules/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/modules/fontawesome/css/all.min.css">

    <!-- Template CSS -->
    <link rel="stylesheet" href="/assets/css/style.css">
    <link rel="stylesheet" href="/assets/css/components.css">
    <style>
        .sidebar-menu li li{
            width: 80%;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            display: block;
        }
    </style>
</head>
<body>
<div id="app">
    <div class="main-wrapper main-wrapper-1">
        <div class="navbar-bg"></div>
        <nav class="navbar navbar-expand-lg main-navbar">
            <form class="form-inline mr-auto">
                <ul class="navbar-nav mr-3">
                    <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="fas fa-bars"></i></a></li>
                    <li><a href="#" data-toggle="search" class="nav-link nav-link-lg d-sm-none"><i class="fas fa-search"></i></a></li>
                </ul>
                <div class="search-element">
                    <input class="form-control" type="search" placeholder="搜索" aria-label="Search" data-width="250">
                    <button class="btn" type="submit"><i class="fas fa-search"></i></button>
                    <div class="search-backdrop"></div>
                    <div class="search-result">
                        <div class="search-header">
                            搜索历史
                        </div>
                        <div class="search-item">
                            <a href="#">知乎</a>
                            <a href="#" class="search-close"><i class="fas fa-times"></i></a>
                        </div>
                        <div class="search-item">
                            <a href="#">v2ex</a>
                            <a href="#" class="search-close"><i class="fas fa-times"></i></a>
                        </div>
                        <div class="search-header">
                            搜索结果
                        </div>
                        <div class="search-item">
                            <a href="#">
                                <img class="mr-3 rounded" width="30" src="assets/img/products/product-3-50.png" alt="product">
                                知乎
                            </a>
                        </div>
                        <div class="search-item">
                            <a href="#">
                                <img class="mr-3 rounded" width="30" src="assets/img/products/product-2-50.png" alt="product">
                                v2ex
                            </a>
                        </div>

                    </div>
                </div>
            </form>
            <!--<ul class="navbar-nav navbar-right">

               <li class="dropdown"><a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle nav-link-lg nav-link-user">
                 <img alt="image" src="assets/img/avatar/avatar-1.png" class="rounded-circle mr-1">
                 <div class="d-sm-none d-lg-inline-block">Hi, Ujang Maman</div></a>
                 <div class="dropdown-menu dropdown-menu-right">
                   <div class="dropdown-title">Logged in 5 min ago</div>
                   <a href="features-profile.html" class="dropdown-item has-icon">
                     <i class="far fa-user"></i> Profile
                   </a>
                   <a href="features-activities.html" class="dropdown-item has-icon">
                     <i class="fas fa-bolt"></i> Activities
                   </a>
                   <a href="features-settings.html" class="dropdown-item has-icon">
                     <i class="fas fa-cog"></i> Settings
                   </a>
                   <div class="dropdown-divider"></div>
                   <a href="#" class="dropdown-item has-icon text-danger">
                     <i class="fas fa-sign-out-alt"></i> Logout
                   </a>
                 </div>
               </li>
             </ul>-->
        </nav>
        <div class="main-sidebar sidebar-style-2">
            <aside id="sidebar-wrapper">
                <div class="sidebar-brand">
                    <a href="/">Oh Today</a>
                </div>
                <div class="sidebar-brand sidebar-brand-sm">
                    <a href="/">OT</a>
                </div>
                <ul class="sidebar-menu">
                    <li class="menu-header " >home</li>
                    <li id="home"><a class="nav-link" href="/"><i class="fas fa-fire"></i><span>发现</span></a></li>
                    <li class="menu-header">Starter</li>
                    <li class="dropdown">
                        <a href="#" class="nav-link has-dropdown"><i class="fas fa-th"></i> <span>我的订阅</span></a>
                        <ul class="dropdown-menu">
                            <#list sites as site>
                                <li id="${site.id}"><a class="nav-link" href="/site/${site.id}">${site.name}</a></li>
                            </#list>
                        </ul>
                    </li>
                </ul>

                <div class="mt-4 mb-4 p-3 hide-sidebar-mini">
                    <a href="#" class="btn btn-primary btn-lg btn-block btn-icon-split">
                        <i class="fas fa-rocket"></i> 建议
                    </a>
                </div>        </aside>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            <section class="section">
                <div class="section-header">
                    <h1>${title}</h1>
                    <div class="section-header-breadcrumb">
                        <#if title!='发现'><div class="breadcrumb-item active"><a href="#">我的订阅</a></div></#if>
                        <div class="breadcrumb-item">${title}</div>
                    </div>
                </div>

                <div class="section-body">
                    <#nested>
                </div>
            </section>
        </div>
        <footer class="main-footer">
            <div class="footer-left">
                Copyright &copy; 2019
            </div>
            <div class="footer-right">

            </div>
        </footer>
    </div>
</div>

<!-- General JS Scripts -->
<script src="/assets/modules/jquery.min.js"></script>
<script src="/assets/modules/popper.js"></script>
<script src="/assets/modules/tooltip.js"></script>
<script src="/assets/modules/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/modules/nicescroll/jquery.nicescroll.min.js"></script>


<!-- Template JS File -->
<script src="/assets/js/scripts.js"></script>
<script>
    var activeId = '${activeId}'
    $("#"+activeId).addClass('active')
    $("#"+activeId).parent().parent().addClass('active')
</script>
</body>
</html>
</#macro>
