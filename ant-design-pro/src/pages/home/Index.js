import React,{ Component } from 'react';
import { Carousel } from 'antd';
import styles from './style.less';

class Index extends Component{
    state={

    }

    componentDidMount() {

    }

    render(){
      return (
        <Carousel autoplay className={styles.carousel}>
          <div>
            <h3>1</h3>
          </div>
          <div>
            <h3>2</h3>
          </div>
          <div>
            <h3>3</h3>
          </div>
          <div>
            <h3>4</h3>
          </div>
        </Carousel>
      )
    }
}
export default Index;

