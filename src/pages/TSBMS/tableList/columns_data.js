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
    title: '作者',
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
const columns2 = [
  {
    title: '发布时间',
    dataIndex: 'Act_Publish_Time',
    sorter: (a, b) => moment(a.Act_Publish_Time) - moment(b.Act_Publish_Time), // arr.sort(function(a, b){return a < b ? 1 : -1;  }); ? 1 : -1  转为日期才能排
    width: '20%',
    scopedSlots: { customRender: 'Act_Publish_Time' }
  },
  {
    title: '作者',
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

export default {
  newsData,
  columns2
}
