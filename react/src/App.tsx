import React, { useState,useEffect } from 'react';
import logo from './logo.svg';
import SendMessageComp from './components/sendMessageComp'
import Message from './components/message'
import Header from './components/Header'
import './App.css';
import { w3cwebsocket } from 'websocket'
var ws = new w3cwebsocket('ws://192.168.1.6:8080/chat');
interface IMessage{
  isSelf:boolean,//是否是自己发的消息
  content:string //消息内容
}


function App() {

  ws.onopen = function(){
    console.log('链接成功')
  }

  const [list,setList] = useState<IMessage[]>([]);


  
  
  ws.onmessage =function (e){
    setList([...list,{
      isSelf:false,
      content:e.data as string
    }])

  }
  function getInputContent(value:string){
    console.log(value)
    ws.send(value)
    setList([...list,{
      isSelf:true,
      content:value
    }])

  }
  return (
    <div className="App">
      <Header />
      <SendMessageComp list={list}/>
      <Message getInputContent={getInputContent}/>
    </div>
  );
}

export default App;
