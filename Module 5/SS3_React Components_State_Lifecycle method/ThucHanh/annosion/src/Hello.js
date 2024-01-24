import React from "react";
import {Component} from "react";

class Hello extends Component{
    componentDidMount() {
        alert("The component is going to be unmounted");
    }

    render() {
        return <h1>Hello U</h1>;
    }
}

export default Hello;