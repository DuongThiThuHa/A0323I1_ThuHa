import React from "react";
import "bootstrap/dist/css/bootstrap.css";

function App() {
    const id = "A03";
    const students = [
        {
            id: 1,
            name: "Thu Ha",
            classroom: {
                id: 1,
                nameClass: "A12"
            },
            gender: true
        },
        {
            id: 1,
            name: "Yen Nhi",
            classroom: {
                id: 1,
                nameClass: "A03"
            },
            gender: false
        }
    ]
    return (
        <>
            <h1>Students List</h1>
            <h3 id={id}>A03</h3>
            <table className="table table-success table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Class Room</th>
                    <th>Gender</th>
                </tr>
                </thead>

                <tbody>
                {
                    students.map((item, index) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.classroom}</td>
                            <td>{item.gender}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    )
        ;
}

export default App;