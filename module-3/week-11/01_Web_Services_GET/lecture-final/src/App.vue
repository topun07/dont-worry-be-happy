<template>
  <div class="container">
    <router-view />
  </div>
</template>

<script>
export default {};
</script>

<style>
body {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
.container {
  width: 100%;
  max-width: 1100px;
  margin: 0 auto;
}
.loading {
  display: flex;
  justify-content: center;
  align-items: center;
}
.board-actions a:link,
.board-actions a:visited {
  color: blue;
  text-decoration: none;
}
.board-actions a:hover {
  text-decoration: underline;
}
</style>
