<template>
    <div id="container">
      <a class="card-link" href="#">
        <article class="blog-card">
          <img class="post-image" v-bind:src="image" />
          <div class="article-details">
            <h4 class="post-category">{{ category }}</h4>
            <h3 class="post-title">{{ name }}</h3>
            <p class="post-description">{{ desc }}</p>
            <p class="post-author">By {{ author }}</p>
          </div>
        </article>
      </a>
    </div>
</template>
<script>
export default {
  data: () => ({
    name: '10 Best Things to Do in Seattle',
    category: 'Travel',
    image: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1159990/pike-place.jpg',
    author: 'Katherine Kato',
    desc: 'Seattle is a seaport city on the west coast of the United States...'
  })
}
</script>

<style  scoped>

@import url("../assets/css/fontgoogle.css");
@import url("../assets/css/CardUI.css");
</style>
