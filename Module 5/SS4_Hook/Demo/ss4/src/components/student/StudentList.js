// Sử dụng Class Component
// import {Component} from "react";
//
// class StudentList extends Component {
//     students;
//     id = " a03"
//     constructor(props) {
//         super(props);
//         this.students = [
//             {
//                 id: 1,
//                 name: "HaiTT",
//                 classroom: {
//                     id: 1,
//                     nameClass: "A03"
//                 },
//                 gender: true
//             },
//             {
//                 id: 2,
//                 name: "HaiTT",
//                 classroom: {
//                     id: 1,
//                     nameClass: "A03"
//                 },
//                 gender: false
//             }
//         ]
//     }
//     render() {
//         return (
//             <>
//                 <h1>Danh sách học sinh lớp {this.props.nameClass}</h1>
//                 <h1 id={this.id}>A03</h1>
//                 <table>
//                     <thead>
//                     <tr>
//                         <th>ID</th>
//                         <th>Name</th>
//                         <th>Classname</th>
//                         <th>Gender</th>
//                     </tr>
//                     </thead>
//                     <tbody>
//                     {
//                         this.students.map((item, index) => (
//                             <tr key={item.id}>
//                                 <td>{item.id}</td>
//                                 <td>{item.name}</td>
//                                 <td>{item.classroom.nameClass}</td>
//                                 <td>{item.gender ? "Nam" : "Nữ"}</td>
//                             </tr>
//                         ))
//                     }
//                     </tbody>
//                 </table>
//             </>
//         )
//     }
// }
//
// export default StudentList;


import {useEffect, useState} from "react";
function StudentList(props) {
    const id = " a03"
    const [student, setStudent] = useState({})
    const [students, setStudents] = useState([]);

    // Sử dụng để xử lý side effect (call API, bất đồng bộ, random,... )
    useEffect(() => {

        // Kiểm tra dữ liệu có tồn tại hay chưa. Nếu không useEffect sẽ chạy liên tục
        if(students.length === 0 ) {
            // Call API giả lập
            setStudents(
                [
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
            )
        }
        console.log(1);
        return (
        //     Clean up <=> willUnMount
            console.log("C09")
        )
    })

    // useEffect(() => {
    // //     Search
    // }, [name, age, address])

    const changeStudent = (evt, properties) => {
// Ghi đè lại DL trên state
        setStudent(prev => {
            return {
                //Sao chép DL của mảng students
                ...prev,
                // truy cập vào giá trị (value) của phần tử đã kích hoạt sự kiện (event).
                [properties]: evt.target.value
                // evt là đối tượng sự kiện.
                // target là thuộc tính của đối tượng sự kiện, trả về phần tử đã kích hoạt sự kiện.
                // value là thuộc tính của phần tử đó, thường được sử dụng với các phần tử nhập liệu như <input>, <select>, và <textarea>.
            }
        })
    }

    const addNewStudent = () => {
        // Spread Operator
        setStudents(prev => {
            return [
                ...prev, student
            ]
        })
        setStudent({id: "", name: "", gender: ""})
    }

    return (
        <>
            <h1>Danh sách học sinh lớp {props.nameClass}</h1>
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
                            <td>{item.gender ? "Nam" : "Nữ"}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            Id: <input value={student.id} onChange={(evt) => changeStudent(evt, "id")}/>
            Name: <input value={student.name} onChange={(evt) => changeStudent(evt, "name")}/>
            gender: <input value={student.gender} onChange={(evt) => changeStudent(evt, "gender")}/>
            <button onClick={addNewStudent}>Thêm mới</button>
        </>
    )
}

export default StudentList;