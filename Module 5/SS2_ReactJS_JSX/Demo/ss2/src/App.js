import logo from './logo.svg';
import React from "react";
import './App.css';

function App() {
    const id = " a03"
    const students = [
        {
            id: 1,
            name: "HaiTT",
            classroom: {
                id: 1,
                nameClass: "A03"
            },
            gender: true
        },
        {
            id: 2,
            name: "HaiTT",
            classroom: {
                id: 1,
                nameClass: "A03"
            },
            gender: false
        }
    ]
    return (
        // React.createElement("h1", {id: "a03", name:"a03", className: "abc"}, "A03")
        <>
            <h1 id={id}>A03</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Classname</th>
                    <th>Gender</th>
                </tr>
                </thead>
                <tbody>
                {
                    students.map((item, index) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.classroom.nameClass}</td>
                            <td>{item.gender ? "Nam" : "Nữ"}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    );
}

export default App;
