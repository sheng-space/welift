import React,{ Component } from 'react';
import { connect } from 'dva';
import router from 'umi/router';
import { Card, Form, Icon, Input, Button, Checkbox, message } from 'antd';
import styles from './style.less';

@Form.create()
@connect(({ login, loading }) => ({
  login,
  submitting: loading.effects['login/submit'],
}))
class Index extends Component{
    state={

    }

    componentDidMount() {

    }

    // 登录提交
    handleSubmit = e => {
      e.preventDefault();
      const {form} = this.props;
      form.validateFields((err, values) => {
        if (!err) {
          const { dispatch } = this.props;
          dispatch({
            type: 'login/submit',
            payload: {
              ...values,
              token_group: '0',
              url:"api/user/login"
            },
            callback:(res)=>{
              if(res.code === "0"){
                // 缓存登录人数据
                localStorage.setItem("token",res.data.token)
                localStorage.setItem("userId",res.data.id);
                localStorage.setItem("userInfo",res.data);
                // 跳转首页
                router.push({pathname: "/system",query: {}});
              }else{
                message.error(res.msg);
              }
            }
          });
        }
      });
    };

    render(){
      const { form:{getFieldDecorator} } = this.props;
      return (
        <Card title="管理员登录" className={styles.loginCard}>
          <Form onSubmit={this.handleSubmit} className={styles.loginForm}>
            <Form.Item>
              {getFieldDecorator('phone', {
                rules: [{ required: true, message: 'Please input your username!' }],
              })(
                <Input
                  prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
                  placeholder="Username"
                />,
              )}
            </Form.Item>
            <Form.Item>
              {getFieldDecorator('password', {
                rules: [{ required: true, message: 'Please input your Password!' }],
              })(
                <Input
                  prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                  type="password"
                  placeholder="Password"
                />,
              )}
            </Form.Item>
            <Form.Item>
              {getFieldDecorator('remember', {
                valuePropName: 'checked',
                initialValue: true,
              })(<Checkbox>记住密码</Checkbox>)}
              <a className={styles.forget} href="">
                忘记密码
              </a>
              <Button type="primary" htmlType="submit" className={styles.button}>
                Log in
              </Button>
              <a href="">立即注册</a>
            </Form.Item>
          </Form>
        </Card>
      )
    }
}
export default Index;

