import moment from 'moment'
const newsData = [
  {
    title: '发布时间',
    dataIndex: 'actPublishTime',
    sorter: (a, b) => moment(a.actPublishTime) - moment(b.actPublishTime), // arr.sort(function(a, b){return a < b ? 1 : -1;  }); ? 1 : -1  转为日期才能排
    width: '20%',
    scopedSlots: { customRender: 'actPublishTime' }
  },
  {
    title: '文章作者',
    dataIndex: 'actAuthor',
    filters: [
      { text: 'Male', value: 'male' },
      { text: 'Female', value: 'female' }
    ],
    width: '10%'
  },
  {
    title: '标题',
    dataIndex: 'actTitle',
    scopedSlots: { customRender: 'aHref' }
  },
  {
    title: '操作',
    key: 'action',
    scopedSlots: { customRender: 'action' }
  }
]
/* ----------------------------- */
const Notices = [
  {
    title: '发布时间',
    dataIndex: 'ntPublishTime',
    sorter: (a, b) => moment(a.ntPublishTime) - moment(b.ntPublishTime), // arr.sort(function(a, b){return a < b ? 1 : -1;  }); ? 1 : -1  转为日期才能排
    width: '20%',
    scopedSlots: { customRender: 'actPublishTime' }
  },
  {
    title: '公告作者',
    dataIndex: 'ntAuthor',
    filters: [
      { text: 'Male', value: 'male' },
      { text: 'Female', value: 'female' }
    ],
    width: '10%'
  },
  {
    title: '公告标题',
    dataIndex: 'ntTitle',
    scopedSlots: { customRender: 'aHref' }
  },
  {
    title: '操作',
    key: 'action',
    scopedSlots: { customRender: 'action' }
  }
]

/* ------------=--------------- */
const AllComments = [
  {
    title: '评论时间',
    dataIndex: 'cmtDate',
    sorter: (a, b) => moment(a.actPublishTime) - moment(b.actPublishTime), // arr.sort(function(a, b){return a < b ? 1 : -1;  }); ? 1 : -1  转为日期才能排
    width: '10%',
    scopedSlots: { customRender: 'actPublishTime' }
  },
  {
    title: '学号',
    dataIndex: 'sno',
    filters: [
      { text: 'Male', value: 'male' },
      { text: 'Female', value: 'female' }
    ],
    width: '10%'
  },
  {
    title: '文章ID',
    dataIndex: 'actID',
    width: '20%'
  },
  {
    title: '评论内容',
    dataIndex: 'cmtContent',
    ellipsis: true
  },
  {
    title: '操作',
    key: 'action',
    scopedSlots: { customRender: 'action' }
  }
]

export default {
  newsData,
  AllComments,
  Notices
}
