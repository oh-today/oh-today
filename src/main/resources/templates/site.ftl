<#include "layout/layout.ftl">
<@layout title=title activeId=activeId  sites=sites>
    <div class="row">
        <div class="col-12 col-md-12 col-lg-12">
            <div class="card">
                <div class="card-body">
                    <ul class="list-group">
                        <#list articles as ariticle>
                        <li class="list-group-item"><a href="${ariticle.resourceUrl}" target="_blank" title="${ariticle.title}"> ${ariticle.title}</a></li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-12  mb-4">
            <div class="hero bg-primary text-white">
                <div class="hero-inner">
                    <h2>${title}</h2>
<#--                    <p class="lead">發現更大的世界.</p>-->
                    <div class="mt-4">
                        <a href="#" class="btn btn-outline-white btn-lg btn-icon icon-left"><i class="far fa-user"></i>
                            订阅</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@layout>
