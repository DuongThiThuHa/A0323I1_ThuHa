import React from "react";
import {Component} from "react";
import Alert from "./component/Alert";
import "./App.css"

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            display: true
        };
    }

    render() {
        let com;
        if (this.state.display) {
            com = <Alert></Alert>
            com = <div className="alert alert-warning" role="alert">
                Cảnh báo! Tài nguyên bạn vừa truy cập không tồn tại.
            </div>
        }
        return (
            <div>{com}</div>
        )
    }
}

export default App