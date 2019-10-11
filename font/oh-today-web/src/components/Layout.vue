<template>
  <div>
    <div class="main-wrapper main-wrapper-1">
        <div class="navbar-bg"></div>
        <nav class="navbar navbar-expand-lg main-navbar">
            <form class="form-inline mr-auto">
                <ul class="navbar-nav mr-3">
                    <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="fas fa-bars"></i></a>
                    </li>
                    <li><a href="#" data-toggle="search" class="nav-link nav-link-lg d-sm-none"><i
                                    class="fas fa-search"></i></a></li>
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
                                <img class="mr-3 rounded" width="30" src="/static/img/products/product-3-50.png"
                                     alt="product">
                                知乎
                            </a>
                        </div>
                        <div class="search-item">
                            <a href="#">
                                <img class="mr-3 rounded" width="30" src="/static/img/products/product-2-50.png"
                                     alt="product">
                                v2ex
                            </a>
                        </div>

                    </div>
                </div>
            </form>
            <ul class="navbar-nav navbar-right">

                <li class="dropdown"><a href="#" data-toggle="dropdown"
                                        class="nav-link dropdown-toggle nav-link-lg nav-link-user">
                        <img alt="image" src="/static/img/avatar/avatar-1.png" class="rounded-circle mr-1">
                        <div class="d-sm-none d-lg-inline-block">Hi, Ujang Maman</div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <div class="dropdown-title">您好</div>
                        <a href="#" class="dropdown-item has-icon">
                            <i class="far fa-user"></i> 个人信息
                        </a>
                        <a href="#" class="dropdown-item has-icon">
                            <i class="fas fa-cog"></i> 设置
                        </a>
                        <div class="dropdown-divider"></div>
                        <a href="/logout" class="dropdown-item has-icon text-danger">
                            <i class="fas fa-sign-out-alt"></i> 退出
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
        <div class="main-sidebar sidebar-style-2">
            <aside id="sidebar-wrapper">
                <div class="sidebar-brand">
                    <router-link to="/">Oh Today</router-link>
                </div>
                <div class="sidebar-brand sidebar-brand-sm">
                    <router-link to="/">OT</router-link>
                </div>
                <ul class="sidebar-menu">
                    <li class="menu-header ">home</li>
                    <li id="home"><router-link class="nav-link" to="/"><i class="fas fa-fire"></i><span>发现</span></router-link></li>
                    <li class="menu-header">Starter</li>
                    <li class="dropdown">
                        <a href="#" class="nav-link has-dropdown"><i class="fas fa-th"></i> <span>我的订阅</span></a>
                        <ul class="dropdown-menu">
                            <li ><router-link class="nav-link" to="/site">site</router-link></li>
                        </ul>
                    </li>
                </ul>

                <div class="mt-4 mb-4 p-3 hide-sidebar-mini">
                    <a href="#" class="btn btn-primary btn-lg btn-block btn-icon-split">
                        <i class="fas fa-rocket"></i> 建议
                    </a>
                </div>
            </aside>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            <section class="section">
                <div class="section-header">
                    <h1>知乎</h1>
                    <div class="section-header-breadcrumb">
                       
                            <div class="breadcrumb-item active"><a href="#">我的订阅</a></div>
                        <div class="breadcrumb-item">知乎</div>
                    </div>
                </div>

                <div class="section-body">
                    <slot></slot>
                </div>
            </section>
        </div>
        <footer class="main-footer">
            <div class="footer-left">
                Copyright &copy; Oh Today 2019
            </div>
            <div class="footer-right">

            </div>
        </footer>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Layout'
}
</script>