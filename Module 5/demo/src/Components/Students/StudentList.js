// Sử dụng Class Component

// import {Component} from "react";
// import "bootstrap/dist/css/bootstrap.css";
// class StudentList extends Component {
// ------Cung cấp dữ liệu mẫu cho việc hiển thị danh sách sinh viên.
//     constructor(props) {
//         super(props);
//         this.students = [
// ------Dữ liệu cho database (Danh sách học sinh)
//             {
//                 id: 1,
//                 name: "Thu Ha",
//                 classroom: {
//                     id: 1,
//                     nameClass: "A12"
//                 },
//                 age: 24,
//                 address: "Quang Nam",
//                 gender: true
//             },
//             {
//                 id: 2,
//                 name: "Yen Nhi",
//                 classroom: {
//                     id: 1,
//                     nameClass: "A03"
//                 },
//                 age: 24,
//                 address: "Da Nang",
//                 gender: false
//             }, {
//                 id: 3,
//                 name: "Anh Thu",
//                 classroom: {
//                     id: 1,
//                     nameClass: "A05"
//                 },
//                 age: 21,
//                 address: "Da Nang",
//                 gender: false
//             }
//         ]
//     }
// -------Phương thức render() là phương thức bắt buộc của mọi component React, nó trả về các phần tử JSX để hiển thị
//     render() {
//         return (
//             <>
//                 <h1 style={{color: 'red', textAlign: 'center', fontSize: '36px'}}>Danh sách học sinh lớp {this.props.nameClass} </h1>
//                 <table className="table table-striped">
//                     <thead>
//                     <tr>
//                         <th>ID</th>
//                         <th>Name</th>
//                         <th>Class Room</th>
//                         <th>Age</th>
//                         <th>Address</th>
//                         <th>Gender</th>
//                     </tr>
//                     </thead>
//----- Sử dụng một vòng lặp map() để tạo ra một <tr> cho mỗi sinh viên trong danh sách
//                     <tbody>
//                     {
//                         this.students.map((item, index) => (
//                             <tr key={item.id}>
//                                 <td>{item.id}</td> {/* Corrected */}
//                                 <td>{item.name}</td>
//                                 <td>{item.classroom.nameClass}</td>
//                                 <td>{item.age}</td>
//                                 <td>{item.address}</td>
//                                 <td>{item.gender ? "Nam" : "Nu"}</td>
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


// Sử dụng Function Component

// import {useEffect, useState} from "react";
// import "bootstrap/dist/css/bootstrap.css";
// function StudentList(props) {
// // Danh sách sinh viên
//     const [students, setStudents] = useState([]);
//     // Một sinh viên mới
//     const [student, setStudent] = useState({id: "", name: "", nameClass: "", age: "", address: "", gender: ""});
//
// // Sử dụng useEffect để cung cấp dữ liệu mẫu cho danh sách sinh viên khi component được render lần đầu tiên. Nếu danh sách sinh viên là một mảng rỗng, dữ liệu mẫu sẽ được thêm vào students.
//     useEffect(() => {
// // Kiem tra dữ liệu có tồn tại hay chưa. Nếu không useEffect sẽ chạy liên tục
//         if (Array.isArray(students) && students.length === 0) {
//             setStudents([
//                 {
//                     id: 1,
//                     name: "Thu Ha",
//                     nameClass: "A12",
//                     age: 24,
//                     address: "Quang Nam",
//                     gender: true
//                 },
//                 {
//                     id: 2,
//                     name: "Yen Nhi",
//                     nameClass: "A03",
//                     age: 24,
//                     address: "Da Nang",
//                     gender: false
//                 },
//                 {
//                     id: 3,
//                     name: "Anh Thu",
//                     nameClass: "A05",
//                     age: 21,
//                     address: "Da Nang",
//                     gender: false
//                 }
//             ]);
//         }
//     }, [students]);
// // Cập nhật thông tin của sinh viên mới khi người dùng thay đổi
//     const changeStudent = (event, property) => {
//         const value = event.target.value;
//         setStudent(prevStudent => ({
//             ...prevStudent,
//             [property]: value
//         }));
//     };
// // Thêm sinh viên mới vào danh sách sinh viên khi người dùng nhấn nút "Add". Sau đó, reset thông tin của sinh viên mới về trạng thái rỗng.
//     const addStudent = () => {
//         setStudents(prevStudents => [...prevStudents, student]);
//         setStudent({id: "", name: "", nameClass: "", age: "", address: "", gender: ""});
//     };
// // Hiển thị thông tin chi tiết của từng sinh viên trong danh sách.
//     return (
//         <>
//             <h1 style={{color: 'red', textAlign: 'center', fontSize: '36px'}}>Danh sách học sinh lớp {props.nameClass}</h1>
//             <table>
//                 <tr>
//                     <td>
//                         ID:
//                     </td>
//                     <td>
//                         <input value={student.id} onChange={(event) => changeStudent(event, "id")}/> <br/>
//                     </td>
//                 </tr>
//
//                 <tr>
//                     <td>
//                         Name:
//                     </td>
//                     <td>
//                         <input value={student.name} onChange={(event) => changeStudent(event, "name")}/>
//                     </td>
//                 </tr>
//
//                 <tr>
//                     <td>Class Room:</td>
//                     <td>
//                         <input value={student.nameClass} onChange={(event) => changeStudent(event, "nameClass")}/>
//                     </td>
//                 </tr>
//                 <tr>
//                     <td>Age:</td>
//                     <td>
//                         <input value={student.age} onChange={(event) => changeStudent(event, "age")}/>
//                     </td>
//                 </tr>
//                 <tr>
//                     <td>Address:</td>
//                     <td>
//                         <input value={student.address} onChange={(event) => changeStudent(event, "address")}/>
//                     </td>
//                 </tr>
//                 <tr>
//                     <td>Gender:</td>
//                     <td>
//                         <input value={student.gender} onChange={(event) => changeStudent(event, "gender")}/>
//                     </td>
//                 </tr>
//                 <br/>
//                 <button onClick={addStudent}>Add</button>
//             </table>
//             <br/>
//
//             <table className="table table-striped" style={{textAlign: 'center'}}>
//                 <thead>
//                 <tr>
//                     <th>ID</th>
//                     <th>Name</th>
//                     <th>Class Room</th>
//                     <th>Age</th>
//                     <th>Address</th>
//                     <th>Gender</th>
//                 </tr>
//                 </thead>
//                 <tbody>
//                 {students.map((item, index) => (
//                     <tr key={index}>
//                         <td>{item.id}</td>
//                         <td>{item.name}</td>
//                         <td>{item.nameClass}</td>
//                         <td>{item.age}</td>
//                         <td>{item.address}</td>
//                         <td>{item.gender ? "Nam" : "Nu"}</td>
//                     </tr>
//                 ))}
//                 </tbody>
//             </table>
//
//         </>
//     );
// }
// export default StudentList;


// Sử dụng useState và useEffect

// import {useEffect, useState} from "react";
// import {Link} from "react-router-dom";
// import * as StudentService from "../Service/StudentService";
// import "bootstrap/dist/css/bootstrap.css";
//
//
// function StudentList(props) {
//     const [students, setStudents] = useState([]);
//
//     useEffect(() => {
//         if (students.length === 0) {
//             const temp = StudentService.getAll();
//             setStudents(temp);
//         }
//     }, [students.length]);
//
//     return (
//         <>
//             <h1>Danh sach hoc sinh lop {props.nameClass}</h1>
//             <table>
//                 <thead>
//                 <tr>
//                     <th>ID</th>
//                     <th>Name</th>
//                     <th>Class Room</th>
//                     <th>Age</th>
//                     <th>Address</th>
//                     <th>Gender</th>
//                 </tr>
//                 </thead>
//                 <tbody>
//                 {students.map((item, index) => (
//                     <tr key={item.id}>
//                         <td>{item.id}</td>
//                         <td>{item.name}</td>
//                         <td>{item.nameClass}</td>
//                         <td>{item.age}</td>
//                         <td>{item.address}</td>
//                         <td>{item.gender}</td>
//                     </tr>
//                 ))}
//                 </tbody>
//             </table>
//             <button>
//                 <Link to="/student/create">Them moi</Link>
//             </button>
//         </>
//     );
// }
//
// export default StudentList;

// SS6
// import {useEffect, useState} from "react";
// import {Link} from "react-router-dom";
// import * as studentService from "../Service/StudentService";
// import "bootstrap/dist/css/bootstrap.css";
//
//
// function StudentList(props) {
//
//     const [students, setStudents] = useState();
//     useEffect(() => {
//         getAll();
//     }, []);
//
//     const getAll = async () => {
//         const temp = await studentService.getAll();
//         console.log(temp)
//         setStudents(temp);
//     }
//
//     if (!students) return null
//
//     console.log(students)
//
//     return (
//         <>
//             <h1 style={{color: "gray" , textAlign: "center"}}>Danh sach hoc sinh lop {props.nameClass}</h1>
//             <table class="table table-striped">
//                 <thead>
//                 <tr>
//                     <th>ID</th>
//                     <th>Name</th>
//                     <th>Class Room</th>
//                     <th>Age</th>
//                     <th>Address</th>
//                     <th>Gender</th>
//                     <th>Action</th>
//                 </tr>
//                 </thead>
//                 <tbody>
//                 {students.map((item, index) => (
//                     <tr key={item.id}>
//                         <td>{item.id}</td>
//                         <td>{item.name}</td>
//                         <td>{item.classroom}</td>
//                         <td>{item.age}</td>
//                         <td>{item.address}</td>
//                         <td>{item.gender}</td>
//                         <td>
//                             <button type="button" className="btn btn-outline-primary">
//                                 <Link to="/student/edit">Edit</Link>
//                             </button>
//                         </td>
//                         <td>
//                             <button type="button" className="btn btn-outline-primary">
//                                 <Link to="/student/delete">Delete</Link>
//                             </button>
//                         </td>
//                     </tr>
//                 ))}
//                 </tbody>
//             </table>
//             <button type="button" class="btn btn-outline-primary">
//                 <Link to="/student/create">Create</Link>
//             </button>
//         </>
//     )
// }

// export default StudentList;


// import { useEffect, useState } from "react";
// import { Link } from "react-router-dom";
// import * as studentService from "../Service/StudentService";
// import "bootstrap/dist/css/bootstrap.css";
//
// function StudentList(props) {
//     const [students, setStudents] = useState([]);
//
//     useEffect(() => {
//         getAll();
//     }, []);
//
//     const getAll = async () => {
//         const temp = await studentService.getAll();
//         setStudents(temp);
//     }
//
//     const deleteStudent = async (id) => {
//         try {
//             await studentService.remove(id);
//             setStudents(students.filter(student => student.id !== id));
//             alert("Xoa hoc sinh thanh cong");
//         } catch (error) {
//             alert("Loi khong the xoa hoc sinh: ", error);
//         }
//     }
//
//     return (
//         <>
//             <h1 style={{color: "gray", textAlign: "center"}}>Danh sách học sinh lớp {props.nameClass}</h1>
//             <div className="search">
//                 <input type="text" placeholder="Search...." className="prompt"/>
//                 <i className="search icon"></i>
//             </div>
//             <button type="button" className="btn btn-outline-primary">
//                 <Link to="/student/create">Create</Link>
//             </button>
//             <table className="table table-striped">
//                 <thead>
//                 <tr>
//                     <th>ID</th>
//                     <th>Name</th>
//                     <th>Class Room</th>
//                     <th>Age</th>
//                     <th>Address</th>
//                     <th>Gender</th>
//                     <th>Action</th>
//                 </tr>
//                 </thead>
//                 <tbody>
//                 {students.map((item, index) => (
//                     <tr key={item.id}>
//                         <td>{item.id}</td>
//                         <td>{item.name}</td>
//                         <td>{item.classroom}</td>
//                         <td>{item.age}</td>
//                         <td>{item.address}</td>
//                         <td>{item.gender}</td>
//                         <td>
//                             <button type="button" className="btn btn-outline-primary">
//                                 <Link to={`/student/update/${item.id}`}>Edit</Link>
//                             </button>
//                         </td>
//                         <td>
//                             <button type="button" className="btn btn-outline-primary"
//                                     onClick={() => deleteStudent(item.id)}>Delete
//                             </button>
//                         </td>
//                     </tr>
//                 ))}
//                 </tbody>
//             </table>
//
//         </>
//     )
// }
//
// export default StudentList;

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import * as studentService from "../Service/StudentService";
import { deburr } from "lodash";
import "bootstrap/dist/css/bootstrap.css";

function StudentList(props) {
    const [students, setStudents] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        getAll();
    }, []);

    const getAll = async () => {
        const temp = await studentService.getAll();
        setStudents(temp);
    }

    const deleteStudent = async (id) => {
        try {
            await studentService.remove(id);
            setStudents(students.filter(student => student.id !== id));
            alert("Xóa học sinh thành công");
        } catch (error) {
            alert("Lỗi không thể xóa học sinh: " + error);
        }
    }

    // Hàm để lọc danh sách học sinh dựa trên giá trị tìm kiếm
    const filteredStudents = students.filter(student => {
        const normalizedSearchTerm = deburr(searchTerm.toLowerCase()); // Loại bỏ dấu và chuyển thành chữ thường
        const normalizedName = deburr(student.name.toLowerCase()); // Loại bỏ dấu và chuyển thành chữ thường
        return normalizedName.includes(normalizedSearchTerm);
    });

    return (
        <>
            <h1 style={{color: "navy", textAlign: "center"}}>Danh sách học sinh lớp {props.className}</h1>
            <div className="search">
                <input
                    type="text"
                    placeholder="Search...."
                    className="prompt"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    style={{WebkitBorderRadius: "15px", width: "30%", float: "right"}}
                />
            </div>

            <button type="button" className="btn btn-outline-primary" style={{float: "left"}}>
                <Link to="/student/create">Create</Link>
            </button>


            <table className="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Class Room</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>Gender</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {filteredStudents.map((item, index) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.classroom}</td>
                        <td>{item.age}</td>
                        <td>{item.address}</td>
                        <td>{item.gender}</td>
                        <td>
                            <button type="button" className="btn btn-outline-primary">
                                <Link to={`/student/update/${item.id}`}>Edit</Link>
                            </button>
                        </td>
                        <td>
                            <button type="button" className="btn btn-outline-primary"
                                    onClick={() => deleteStudent(item.id)}>Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </>
    )
}

export default StudentList;

