import './App.css';
import {Component} from "react"
import React from "react";
import "bootstrap/dist/css/bootstrap.css";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            studentList: [],
            form: {name: "", phone: "", email: ""},
            isValid: false,
            indexSelected: -1
        };
    }

    handleSelect = (studentSelected, index) => {
        this.setState({
            ...this.state,
            form: {...studentSelected},
            indexSelected: index,
        })
    }

    checkInvalidForm = () => {
        const {name, phone, email} = this.state.form
        const value = !!(name && phone && email)
        this.setState({
            ...this.state,
            isValid: value
        })
    }

    handleChange = (event) => {
        this.setState((state) => {
            const form = state.form
            form[event.target.name] = event.target.value
            return {form}
        }, () => this.checkInvalidForm())
    }


    handleSubmit = () => {
        if (this.state.isValid) {
            if (this.state.indexSelected > -1) {
                //Tạo mảng mới
                const arr = [...this.state.studentList].map((elm, index) => {
                    //Nếu vị trí trong form === vị trí hiện tại
                    if (index === this.state.indexSelected) {
                        //trả v ds trong form
                        return {...this.state.form}
                    } else {
                        return elm
                    }
                })
                //Tạo mảng mới, state:lấy ds hiện tại, form: form = rỗng, indexSelected: trả về vị trí ban đầu
                this.setState({
                    ...this.state,
                    studentList: [...arr],
                    form: {name: "", phone: "", email: ""},
                    indexSelected: -1
                })
            } else {
                //Tạo mảng sửa, state:ghi đè ds mới trong form vào ds hiện tại, form: form = rỗng,
                this.setState({
                    ...this.state,
                    studentList: [...this.state.studentList, this.state.form],
                    form: {name: "", phone: "", email: ""}
                })
            }
        }
    }

    handleDelete = (index) => {
        this.setState((state) => {
            const studentList = state.studentList;
            studentList.splice(index, 1)
            return {studentList}
        })
    }

    render() {
        const {studentList} = this.state
        return (
            <div>
                <div>
                    <h1>Student List</h1>
                    <div>
                        <label>Name: </label>
                        <input name="name" value={this.state.form.name} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <div>
                        <label>Phone: </label>
                        <input type="number" name="phone" value={this.state.form.phone}
                               onChange={(evt) => this.handleChange(evt)}/></div>
                    <div>
                        <label>Email: </label>
                        <input name="email" value={this.state.form.email} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <button onClick={this.handleSubmit}>Submit</button>

                    <table className="table table-success table-striped">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Action</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                        {studentList.map((student, index) => (
                            <tr key={index}>
                                <td>{student.name}</td>
                                <td>{student.phone}</td>
                                <td>{student.email}</td>
                                <td>
                                    <button onClick={(e) => this.handleSelect(student, index)}>Edit</button>
                                </td>
                                <td>
                                    <button onClick={(index) => this.handleDelete(index)}>Delete</button>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default App;
