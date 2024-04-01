import React from "react";
import ReactDOM from 'react-dom/client';
import "bootstrap/dist/css/bootstrap.css";
import './index.css';

// Bảng thông tin các sinh viên trong lớp học
// const students = [
//     {
//         company: 'Luong Thuy Linh',
//         age: '22',
//         country: 'Viet Nam'
//     },
//     {
//         company: 'Nguyen Thuc Thuy Tien',
//         age: '24',
//         country: 'Viet Nam'
//     },
//     {
//         company: 'Huynh Nguyen Mai Phuong',
//         age: '25',
//         country: 'Viet Nam'
//     },
//     {
//         company: 'Tran Tieu Vy',
//         age: '23',
//         country: 'Viet Nam'
//     }
// ];
//
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//     <div>
//         <table class="table table-striped">
//             <thead>
//             <tr>
//                 <th>Company</th>
//                 <th>Age</th>
//                 <th>Country</th>
//             </tr>
//             </thead>
//             <tbody>
//             {students.map(student => (
//                 <tr>
//                     <td>{student.company}</td>
//                     <td>{student.age}</td>
//                     <td>{student.country}</td>
//                 </tr>
//             ))}
//             </tbody>
//         </table>
//     </div>
// );

// Profile Card
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <div>
        <div className="card">
            <img className="card-img-top" src="https://webdamn.com/demo/forum-php-mysql-demo/images/user-avatar.png"/>
            <div className="card-body">
                <h5 className="card-title">Profile Card</h5>
                <p className="card-text">Hello world </p>
                <button>Sign In</button>
            </div>
        </div>
    </div>
);



