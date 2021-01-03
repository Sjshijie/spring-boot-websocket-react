import React from 'react'

class Header extends React.Component{
    constructor(props:any){
        super(props);
    }
    render(){
        return (
            <div style={{fontSize:"18px",height:"5vh"}}>
                群聊列表
            </div>
        )
    }
}

export default Header;