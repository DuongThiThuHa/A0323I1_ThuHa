import React from "react";
import {Component} from "react";
import Home from "./Home";
import "./App.css"

class App extends Component{
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn : false
    };
  }

  handleLogIn = () => {
    this.setState({isLoggedIn: true})
  }

  handleLogOut = () => {
    this.setState({isLoggedIn: false})
  }

  render() {
    const {isLoggedIn} = this.state
    if (isLoggedIn) return (<Home onLogOut={this.handleLogOut}></Home>)
    return (
        <div>
          <h1>Please Log In</h1>
          <button onClick={this.handleLogIn}>Log In</button>
        </div>
    )
  }
}

export default App