import React from 'react';
import {Component} from "react";
import "./App.css"
class Calculator extends Component {
  constructor(props) {
    super(props);
    // Trạng thái (state) là một đối tượng chứa dữ liệu mà component có thể thay đổi và render lại khi cần.
    this.state = {
      firstNum: "",
      secondNum: "",
      result: ""
    };
  }

  // e: là đối tượng sự kiện được truyền vào hàm khi sự kiện xảy ra.
  // setState: dùng để cập nhật trạng thái của component.
  handleFirstNum = (e) => {
    this.setState({ firstNum: e.target.value });
  }

  handleSecondNum = (e) => {
    this.setState({ secondNum: e.target.value });
  }

  // chuyển đổi thành số bằng hàm Number trước khi thực hiện phép tính.
  add = () => {
    this.setState({ result: Number(this.state.firstNum) + Number(this.state.secondNum) });
  }

  sub = () => {
    this.setState({ result: Number(this.state.firstNum) - Number(this.state.secondNum) });
  }

  mul= () => {
    this.setState({ result: Number(this.state.firstNum) * Number(this.state.secondNum) });
  }

  div = () => {
    this.setState({ result: Number(this.state.firstNum) / Number(this.state.secondNum) });
  }

  delete = () => {
    this.setState({ firstNum: "", secondNum: "", result: "" });
  }

  render() {
    return (
        <div className="container">
          <form>
            <input type="text" value={this.state.firstNum} onChange={this.handleFirstNum} placeholder="First Number " /><br/>
            <input type="text" value={this.state.secondNum} onChange={this.handleSecondNum} placeholder="Second Number " />
            <p>Result: {this.state.result}</p>
          </form>

          <div className="keypad">
            <button onClick={this.add} id="add">+</button>
            <button onClick={this.sub} id="subtract">-</button>
            <button onClick={this.mul} id="multiply">*</button>
            <button onClick={this.div} id="divide">/</button>
            <button onClick={this.delete} id="clear">Delete</button>
          </div>
        </div>
    );
  }
}

export default Calculator;
