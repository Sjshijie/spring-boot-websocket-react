import React from 'react'
import { Button,Input } from 'antd';
import style from  './message.module.scss'

interface IProps{
    getInputContent:(value:string)=>void
}

class Message extends React.Component<IProps>{
    constructor(props:IProps){
        super(props);
    }
    state={value:""}
    inputChange(e:React.ChangeEvent<HTMLInputElement>){
        this.setState({
            value:e.target.value
        })
    }
    render(){
        return (
            <div className={style.message}>
                <Input
                  onChange={ (e)=>this.inputChange(e) }
                  maxLength={25}
                />
                <Button onClick={ ()=>{this.props.getInputContent(this.state.value)} }>点击</Button>
            </div>
        )
    }
}

export default Message;