<template>
  <!-- Footer -->
  <mdb-footer color="stylish-color-dark" class="font-small pt-1 mt-1">
    <mdb-container class="text-center text-md-left">
      <mdb-row class="text-center text-md-left mt-1 pb-1">
        <mdb-col md="3" lg="3" xl="3" class="mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">桂林理工大学鲲鹏素拓协会</h6>
          <p>用汗水续写青春||奔跑吧！辅导员。 用汗水续写青春||奔跑吧！辅导员。 </p>
        </mdb-col>
        <hr class="w-100 clearfix d-md-none" />
        <mdb-col md="2" lg="2" xl="2" class="mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">人事</h6>
          <p><a href="#!">街舞大象</a></p>
          <p><a href="#!">木头军事</a></p>

        </mdb-col>
        <hr class="w-100 clearfix d-md-none" />
        <mdb-col md="3" lg="2" xl="2" class="mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">友情链接</h6>
          <p><a href="https://www.weibo.com/u/5171450505?refer_flag=1005055013_&is_all=1#_rnd1602662510676"> 微博</a></p>
          <p><a href="#!">成为一个鲲鹏素拓人！</a></p>

        </mdb-col>
        <hr class="w-100 clearfix d-md-none" />
        <mdb-col md="4" lg="3" xl="3" class="mx-auto mt-3">
          <h6 class="text-uppercase mb-4 font-weight-bold">联系我们</h6>
          <p><i class="fas fa-home mr-3"></i>桂林雁山区319号</p>
          <p><i class="fas fa-envelope mr-3"></i> kunpeng.info@gmail.com</p>

        </mdb-col>
      </mdb-row>
      <hr />
      <mdb-row class="d-flex align-items-center">
        <mdb-col md="8" lg="8">
          <p class="text-center text-md-left grey-text">&copy; 2020 Copyright: <a href="https://www.MDBootstrap.com">
            kunpeng.com </a></p>
        </mdb-col>
        <mdb-col md="4" lg="4" class="ml-lg-0">
          <div class="text-center text-md-right">
            <ul class="list-unstyled list-inline">
              <li class="list-inline-item"><a class="btn-floating btn-sm rgba-white-slight mx-1"><i class="fab "><a-icon type="weibo-circle" /></i></a></li>
              <li class="list-inline-item"><a class="btn-floating btn-sm rgba-white-slight mx-1"><i class="fab "><a-icon type="wechat" /></i></a></li>
              <li class="list-inline-item"><a class="btn-floating btn-sm rgba-white-slight mx-1"><i class="fab fa-google-plus"></i></a></li>
              <li class="list-inline-item"><a class="btn-floating btn-sm rgba-white-slight mx-1"><i class="fab "><a-icon type="qq" /></i></a></li>
            </ul>
          </div>
        </mdb-col>
      </mdb-row>
    </mdb-container>
  </mdb-footer>
  <!-- Footer -->
</template>

<script>
import { mdbFooter, mdbContainer, mdbRow, mdbCol } from 'mdbvue'
require('bootstrap-css-only/css/bootstrap.min.css')
require('mdbvue/lib/css/mdb.min.css')
require('@fortawesome/fontawesome-free/css/all.min.css')

export default {
  name: 'FooterPage',
  components: {
    mdbFooter,
    mdbContainer,
    mdbRow,
    mdbCol
  }
}
</script>
