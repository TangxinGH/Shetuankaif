import moment from 'moment'
const newsData = [
  {
    title: '发布时间',
    dataIndex: 'Act_Publish_Time',
    sorter: (a, b) => moment(a.Act_Publish_Time) - moment(b.Act_Publish_Time), // arr.sort(function(a, b){return a < b ? 1 : -1;  }); ? 1 : -1  转为日期才能排
    width: '20%',
    scopedSlots: { customRender: 'Act_Publish_Time' }
  },
  {
    title: '文章作者',
    dataIndex: 'Act_Author',
    filters: [
      { text: 'Male', value: 'male' },
      { text: 'Female', value: 'female' }
    ],
    width: '10%'
  },
  {
    title: '标题',
    dataIndex: 'Act_Title',
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
    dataIndex: 'Nt_Publish_Time',
    sorter: (a, b) => moment(a.Act_Publish_Time) - moment(b.Act_Publish_Time), // arr.sort(function(a, b){return a < b ? 1 : -1;  }); ? 1 : -1  转为日期才能排
    width: '20%',
    scopedSlots: { customRender: 'Act_Publish_Time' }
  },
  {
    title: '公告作者',
    dataIndex: 'Nt_Author',
    filters: [
      { text: 'Male', value: 'male' },
      { text: 'Female', value: 'female' }
    ],
    width: '10%'
  },
  {
    title: '公告标题',
    dataIndex: 'Nt_Title',
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
    dataIndex: 'Cmt_Date',
    sorter: (a, b) => moment(a.Act_Publish_Time) - moment(b.Act_Publish_Time), // arr.sort(function(a, b){return a < b ? 1 : -1;  }); ? 1 : -1  转为日期才能排
    width: '10%',
    scopedSlots: { customRender: 'Act_Publish_Time' }
  },
  {
    title: '学号',
    dataIndex: 'Sno',
    filters: [
      { text: 'Male', value: 'male' },
      { text: 'Female', value: 'female' }
    ],
    width: '10%'
  },
  {
    title: '文章ID',
    dataIndex: 'ActID',
    width: '20%'
  },
  {
    title: '评论内容',
    dataIndex: 'Cmt_Content',
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
