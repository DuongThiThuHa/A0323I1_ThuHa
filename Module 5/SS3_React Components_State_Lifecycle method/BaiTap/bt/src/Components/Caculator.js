import React, {Component} from "react";

class Calculator extends Component {
    constructor(props) {
        super(props);
        this.state = {
            first: "",
            second: "",
            result: ""
        }
    }

    // handle event : dung de bat su kien
    handleFirst = (e) => {
        this.setState({first: e.target.value});
    }

    handleSecond = (e) => {
        this.setState({second: e.target.value});
    }

    addNum = () => {
        this.setState({result: Number(this.state.first) + Number(this.state.second)});
    }

    subNum = () => {
        this.setState({result: Number(this.state.first) - Number(this.state.second)});
    }

    mulNum = () => {
        this.setState({result: Number(this.state.first) * Number(this.state.second)});
    }

    divNum = () => {
        this.setState({result: Number(this.state.first) / Number(this.state.second)});
    }

    delete = () => {
        this.setState({first: "", second: "", result: ""});
    }

    render() {
        return (
            <>
                <input type="number" value={this.state.first} onChange={this.handleFirst}>First Number</input>
                <input type="number" value={this.state.second} onChange={this.state.handleSecond}>Second Number</input>
                <h3>Result: {this.state.result}</h3>
                <br/>
                <button onClick={this.addNum} id="add">+</button>
                <button onClick={this.subNum} id="sub">-</button>
                <button onClick={this.mulNum} id="mul">*</button>
                <button onClick={this.divNum} id="div">/</button>
                <button onClick={this.delete} id="clear">Del</button>
            </>
        );
    }
}
export default Calculator;