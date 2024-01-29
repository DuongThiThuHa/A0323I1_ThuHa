import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            list: [],
            item: ""
        }
    }

    handleChange = (value) => {
        this.setState({
            item: value
        })
    }

    handleAddItem = () => {
        this.setState((index) => {
            return {
                list: [...index.list, index.item]
            }
        })
    }

    render() {
        return (
            <div>
                <h1>Todo List</h1>
                <div className="input-group">
                    <input type="text" placeholder="Nhap cong viec can lam..."
                           onChange={(element) => this.handleChange(element.target.value)}/>
                    <button onClick={() => this.handleAddItem()} type="submit">Them</button>
                </div>
                <table className="table" border={2}>
                    <tr>
                        <th>STT</th>
                        <th>Cong viec</th>
                    </tr>
                    {
                        this.state.list.map((value, index) => {
                                return (
                                    <tr>
                                        <td>{index + 1}</td>
                                        <td>{value}</td>
                                    </tr>
                                )
                            }
                        )}
                </table>
            </div>
        )
    }

}

export default App;
