import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import sichuanContent from '../../src/pages/Sichuan/module/sichuanContent.'
describe('sichuanContent.vue', () => {
  it('renders props.msg when passed', () => {
    const msg = 'new message'
    const wrapper = shallowMount(sichuanContent, {
      propsData: { msg }
    })
    expect(wrapper.text()).to.include(msg)
  })
})
