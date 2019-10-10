<#include "layout/layout.ftl">
<@layout title="发现" activeId="home" sites=sites>
    <div class="row">
        <#list sites as site>


        <div class="col-12 col-lg-6 mb-4">
            <div class="hero bg-primary text-white">
                <div class="hero-inner">
                    <h2><img src="${site.icon}" style="width: 32px" alt="">${site.name}!</h2>
                    <p class="lead">${site.host}</p>
                    <div class="mt-4">
                        <a href="#" class="btn btn-outline-white btn-lg btn-icon icon-left"><i class="far fa-user"></i> 订阅</a>
                        <a href="/site/${site.id}" class="btn btn-outline-white btn-lg btn-icon icon-left"><i class="far fa-user"></i> 查看</a>
                    </div>
                </div>
            </div>
        </div>
        </#list>
        <#--<div class="col-12 col-lg-6 mb-4">
            <div class="hero bg-primary text-white">
                <div class="hero-inner">
                    <h2>知乎!</h2>
                    <p class="lead">發現更大的世界.</p>
                    <div class="mt-4">
                        <a href="#" class="btn btn-outline-white btn-lg btn-icon icon-left"><i class="far fa-user"></i> 订阅</a>
                    </div>
                </div>
            </div>
        </div>-->
    <#--    <div class="col-12 mb-4">
            <div class="hero text-white hero-bg-image hero-bg-parallax" style="background-image: url('assets/img/unsplash/andre-benz-1214056-unsplash.jpg');">
                <div class="hero-inner">
                    <h2>Welcome, Ujang!</h2>
                    <p class="lead">You almost arrived, complete the information about your account to complete registration.</p>
                    <div class="mt-4">
                        <a href="#" class="btn btn-outline-white btn-lg btn-icon icon-left"><i class="far fa-user"></i> Setup Account</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12 mb-4">
            <div class="hero text-white hero-bg-image" style="background-image: url('assets/img/unsplash/eberhard-grossgasteiger-1207565-unsplash.jpg');">
                <div class="hero-inner">
                    <h2>Welcome, Ujang!</h2>
                    <p class="lead">You almost arrived, complete the information about your account to complete registration.</p>
                    <div class="mt-4">
                        <a href="#" class="btn btn-outline-white btn-lg btn-icon icon-left"><i class="far fa-user"></i> Setup Account</a>
                    </div>
                </div>
            </div>
        </div>-->
    </div>
</@layout>
