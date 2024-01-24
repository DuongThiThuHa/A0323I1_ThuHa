import React from 'react';
import {Component} from "react";
import "./App.css"
import "bootstrap/dist/css/bootstrap.css";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            students: [
                { id: 1, name: 'Thu Ha', age: 23, address: 'Quang Nam' },
            ]
        };
    }

    render() {
        const { students } = this.state;
        return (
            <div>
                <h1>List Student</h1>
                <ul>
                    <table className="table table-success table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Address</th>
                            </tr>
                        </thead>

                        <tbody>
                            {students.map(student => (
                                <tr key={student.id}>
                                    <td>{student.id}</td>
                                    <td>{student.name}</td>
                                    <td>{student.age}</td>
                                    <td>{student.address}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </ul>
            </div>
        );
    }
}

export default App;
