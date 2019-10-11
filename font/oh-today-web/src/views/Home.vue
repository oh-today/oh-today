<template>
    <Layout>
      <router-view/>
    </Layout>  
</template>

<script>
// @ is an alias to /src
import Layout from '@/components/Layout.vue'

export default {
  name: 'home',
  components: {
    Layout
  },
  created(){
     window.initLayout()
  }
}
</script>
