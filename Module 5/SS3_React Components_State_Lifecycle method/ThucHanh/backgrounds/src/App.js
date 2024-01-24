import React from "react";
import {Component} from "react";
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            color: '#6495ED'
        };
    }

    componentDidMount() {
        setTimeout(() => {
            this.setState({color: '#FFC0CB'});
        }, 1000);
    }

    render() {
        return (
            <div>
                <div style={{
                    backgroundColor: this.state.color
                }}></div>
            </div>
        );
    }
}

export default App;