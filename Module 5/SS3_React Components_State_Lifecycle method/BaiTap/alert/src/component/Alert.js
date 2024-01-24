import React from "react";
import {Component} from "react";

class Alert extends Component {
    componentDidMount() {
        alert("Hello")
    }

    render() {
        return <Alert text="Cảnh báo! Tài nguyên bạn vừa truy cập không tồn tại."/>
    }
}

export default Alert