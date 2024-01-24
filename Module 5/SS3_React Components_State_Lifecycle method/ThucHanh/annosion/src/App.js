import React from "react";
import {Component} from "react";
import Hello from "./Hello";
import "./App.css"

class App extends Component{
  constructor(props) {
    super(props);
    this.state = {
      display: true
    };
  }

  delete = () =>{
    this.setState({display: false});
  };

  render() {
    let comp;
    if (this.state.display){
      comp = <Hello></Hello>
    }
    return(
        <div>{comp}
        <button onClick={this.delete}> Delete the component</button>
        </div>
    );
  }
}
export default App;