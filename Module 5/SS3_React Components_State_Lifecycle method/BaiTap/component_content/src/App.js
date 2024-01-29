import './App.css';
import React from "react";
import {Component} from "react";


class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isExpand: false
        }
    }

    handleUpdate = () => {
        this.setState(flag => {
            return {isExpand: !flag.isExpand}
        });
    }


    render() {
        return (
            <div>
                <h1>Conditional Rendering</h1>
                {this.state.isExpand ?
                    (
                        <div>
                            <button onClick={this.handleUpdate}>Xem gioi thieu</button>
                        </div>) : (
                        <div>
                            <button onClick={this.handleUpdate}> Dong gioi thieu</button>
                            <br></br><br></br>
                            <b>Gioi thieu</b>
                            <p>Trong react, doi khi ban co mot so component va tuy thuoc vao tung dieu kien vi du nhu
                                trang thai cua state, props,... ma ban muon hien thi mot hoac mot so componen nao do.
                                Khi do ban co the su dung Conditional Rendering de render ra component ma ban mon
                                muon</p>
                        </div>)
                }
            </div>
        )
    };
}

export default App;
