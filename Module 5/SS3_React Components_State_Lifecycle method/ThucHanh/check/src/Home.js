import React from "react";
import {Component} from "react";
import "./App.css"

class Home extends Component{
    render() {
        return(
            <div>
                <h1>Welcome</h1>
                <button onClick={this.props.onLogout}>Log out</button>
            </div>
        )
    }
}

export default Home