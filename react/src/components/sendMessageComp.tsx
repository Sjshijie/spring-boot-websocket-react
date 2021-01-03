import React from 'react'
import style from './sendMessageComp.module.scss'


interface IMessage{
    isSelf:boolean,//是否是自己发的消息
    content:string //消息内容
  }

interface IProps{
    list:IMessage[]
}

class SendMessageComp extends React.Component<IProps>{
    constructor(props:IProps){
        super(props);
    }
    render(){
        console.log('this.props.list',this.props.list)
        return (
            <div className={style.container}>
                {
                    this.props.list.map((item,index)=>{
                        return <div className={item.isSelf?style.selfMessage:style.unSelfMessage} key={index}>{item.content}</div>
                    })
                }
            </div>
        )
    }
}

export default SendMessageComp;