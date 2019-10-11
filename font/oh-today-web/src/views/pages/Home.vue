<template>
  <div class="row">
    <div class="col-12 col-lg-6 mb-4" v-for="(site,index) in sites" :key="index">
      <div class="hero bg-primary text-white">
        <div class="hero-inner">
          <h2>
            <img src="${site.icon}" style="width: 32px" alt />
            {{site.name}}!
          </h2>
          <p class="lead" v-text="site.host">zhihu.com</p>
          <div class="mt-4">
            <router-link :to="'/site/'+site.id" class="btn btn-outline-white btn-lg btn-icon icon-left">
              <i class="far fa-user"></i> 订阅
            </router-link>
            <router-link to="/site/" class="btn btn-outline-white btn-lg btn-icon icon-left">
              <i class="far fa-user"></i> 查看
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { listSiteAll } from "@/api/home";
export default {
  data() {
    return {
      sites: []
    };
  },
  mounted() {
    listSiteAll().then(res => {
      this.sites = res.data.content;
    });
  }
};
</script>