<template>
 <span>
      <a-divider type="vertical"/>
      <a-button icon="edit" /> <!--跳转到相应文章编辑-->
      <a-divider type="vertical"/>
   <a-select default-value="lucy" style="width: 120px" @change="handleChangeSelect">
      <a-select-option value="jack">
        Jack
      </a-select-option>
      <a-select-option value="lucy">
        Lucy
      </a-select-option>
      <a-select-option value="disabled" disabled>
        Disabled
      </a-select-option>
      <a-select-option value="Yiminghe">
        yiminghe
      </a-select-option>
   </a-select>
      <a class="ant-dropdown-link"> More actions <a-icon type="down"/> </a>
      <a-divider type="vertical"/>
      <a-button type="danger">Delete</a-button>
    </span>
</template>

<script>
export default {
  name: 'newsOperation',
  methods: {
    onChangeSwitch: function () {

    },
    handleChangeSelect: function () {

    }
  }
}
</script>

<style scoped>

</style>
