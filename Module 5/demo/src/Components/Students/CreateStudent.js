// // SS4
//
// // import {ErrorMessage, Field, Form, Formik} from "formik";
// // import * as Yup from "yup";
// // import {useNavigate} from "react-router-dom";
// // import {toast} from "react-toastify";
// // import * as StudentService from "../Service/StudentService";
// // import "bootstrap/dist/css/bootstrap.css";
// //
// //
// // function CreateStudent() {
// //     const navigate = useNavigate();
// //     const student = {
// //         id: "",
// //         name: "",
// //         nameClass: "",
// //         age: "",
// //         address: "",
// //         gender: ""
// //     };
// //
// //     // Validate cac truong hop trong o input
// //     const validationStudent = Yup.object().shape({
// //         id: Yup.number()
// //             .required("ID không được để trống")
// //             .min(0, "ID không được nhỏ hơn 0")
// //             .max(2000000),
// //         name: Yup.string()
// //             .required("Name không được để trống")
// //             .matches(/^[a-zA-Z ]{3,100}$/, "Tên không đúng định dạng"),
// //         age: Yup.number()
// //             .required("Age không được để trống")
// //             .min(0, "Age không được nhỏ hơn 0 tuổi")
// //             .max(200, "Tuổi không được quá 200 tuổi"),
// //         address: Yup.string()
// //             .required("Address không được để trống")
// //             .matches(/^[a-zA-Z ]{3,100}$/, "Tên không đúng định dạng"),
// //         nameClass: Yup.string()
// //             .required("Class Room không được để trống"),
// //         gender: Yup.string()
// //             .required("Gender khong duoc de trong"),
// //     });
// //
// //     const addStudent = (values) => {
// //         console.log(values);
// //         StudentService.add(values);
// //         toast.success("Thêm thành công");
// //         navigate("/student");
// //     };
// //
// //     return (
// //         <>
// //             <Formik
// //                 initialValues={student}
// //                 onSubmit={addStudent}
// //                 validationSchema={validationStudent}
// //             >
// //                 <Form>
// //                     <table className="table table-striped table-hover">
// //                         <tr style={{width: "50px", textAlign: "center"}}>
// //                             <tr>
// //                                 <td>
// //                                     Id: <Field name="id"/>
// //                                 </td>
// //                                 <td>
// //                                     <ErrorMessage name="id" component="p"/>
// //                                 </td>
// //                             </tr>
// //                             <tr>
// //                                 <td>
// //                                     Name: <Field name="name"/>
// //                                 </td>
// //                                 <td>
// //                                     <ErrorMessage name="name" component="p"/>
// //                                 </td>
// //                             </tr>
// //                             <tr>
// //                                 <td>
// //                                     Age: <Field name="age"/>
// //                                 </td>
// //                                 <td>
// //                                     <ErrorMessage name="age" component="p"/>
// //                                 </td>
// //                             </tr>
// //                             <tr>
// //                                 <td>
// //                                     Address: <Field name="address"/>
// //                                 </td>
// //                                 <td>
// //                                     <ErrorMessage name="address" component="p"/>
// //                                 </td>
// //                             </tr>
// //                             <tr>
// //                                 <td>
// //                                     ClassRoom: <Field name="nameClass"/>
// //                                 </td>
// //                                 <td>
// //                                     <ErrorMessage name="nameClass" component="p"/>
// //                                 </td>
// //                             </tr>
// //                             <tr>
// //                                 <td>
// //                                     Gender:
// //                                 </td>
// //                                 <td>
// //                                     <label>
// //                                         <Field type="radio" name="gender" value="Nam"/>
// //                                         Nam
// //                                     </label>
// //                                     <label>
// //                                         <Field type="radio" name="gender" value="Nu"/>
// //                                         Nu
// //                                     </label>
// //                                     <label>
// //                                         <Field type="radio" name="gender" value="Khac"/>
// //                                         Khac
// //                                     </label>
// //                                     <ErrorMessage name="gender" component="p"/>
// //                                 </td>
// //                             </tr>
// //                         </tr>
// //                     </table>
// //                     <button type="submit">Them moi</button>
// //                 </Form>
// //             </Formik>
// //         </>
// //     );
// // }
// //
// // export default CreateStudent;

// // SS5
//
// // import {ErrorMessage, Field, Form, Formik} from "formik";
// // import * as Yup from "yup";
// // import {useNavigate} from "react-router-dom";
// // import {toast} from "react-toastify";
// // import * as StudentService from "../Service/StudentService";
// //
// // function CreateStudent() {
// //     const navigate = useNavigate();
// //     const student = {
// //         id: "",
// //         name: "",
// //         nameClass: "",
// //         age: "",
// //         address: "",
// //         gender: ""
// //     };
// //
// //     // Validate các trường hợp trong ô input
// //     const validationStudent = Yup.object().shape({
// //         id: Yup.number()
// //             .required("** ID không được để trống")
// //             .min(0, "ID không được nhỏ hơn 0")
// //             .max(2000000),
// //         name: Yup.string()
// //             .required("** Name không được để trống")
// //             .matches(/^[a-zA-Z ]{3,100}$/, "Tên không đúng định dạng"),
// //         age: Yup.number()
// //             .required("** Age không được để trống")
// //             .min(0, "Age không được nhỏ hơn 0 tuổi")
// //             .max(200, "** Tuổi không được quá 200 tuổi"),
// //         address: Yup.string()
// //             .required("** Address không được để trống")
// //             .matches(/^[a-zA-Z ]{3,100}$/, "** Tên không đúng định dạng"),
// //         nameClass: Yup.string().required("** Class Room không được để trống"),
// //         gender: Yup.string().required("** Gender khong duoc de trong")
// //     });
// //
// //     const addStudent = (values) => {
// //         console.log(values);
// //         StudentService.add(values);
// //         toast.success("Thêm thành công");
// //         navigate("/student");
// //     };
// //
// //     return (
// //         <>
// //             <Formik
// //                 initialValues={student}
// //                 onSubmit={addStudent}
// //                 validationSchema={validationStudent}
// //             >
// //                 <Form>
// //                     <table>
// //                         <tbody>
// //                         <tr>
// //                             <td>
// //                                 Id: <Field name="id"/>
// //                                 <ErrorMessage name="id" component="p" style={{color: "red"}}/>
// //                             </td>
// //                             <td>
// //                                 Name: <Field name="name"/>
// //                                 <ErrorMessage name="name" component="p" style={{color: "red"}}/>
// //                             </td>
// //                             <td>
// //                                 Age: <Field name="age"/>
// //                                 <ErrorMessage name="age" component="p" style={{color: "red"}}/>
// //                             </td>
// //                             <td>
// //                                 Address: <Field name="address"/>
// //                                 <ErrorMessage name="address" component="p" style={{color: "red"}}/>
// //                             </td>
// //                             <td>
// //                                 ClassRoom: <Field name="nameClass"/>
// //                                 <ErrorMessage name="nameClass" component="p" style={{color: "red"}}/>
// //                             </td>
// //                             <br/>
// //                             <td>
// //                                 Gender:
// //                                 <Field as="select" name="gender">
// //                                     <option value="">--Chon gioi tinh--</option>
// //                                     <option value="Nam">Nam</option>
// //                                     <option value="Nu">Nu</option>
// //                                     <option value="Khac">Khac</option>
// //                                 </Field>
// //                                 <ErrorMessage name="gender" component="p" style={{color: "red"}}/>
// //                             </td>
// //                         </tr>
// //                         </tbody>
// //                     </table>
// //                     <button type="submit">Thêm mới</button>
// //                 </Form>
// //             </Formik>
// //         </>
// //     );
// // }
// // export default CreateStudent;

// // SS6
// import {ErrorMessage, Field, Form, Formik} from "formik";
// import {useState, useEffect} from "react";
// import * as Yup from 'yup';
// import {useNavigate} from 'react-router-dom';
// import {toast} from "react-toastify";
// import * as studentService from "../Service/StudentService";
// import * as classroomService from "../Service/ClassroomService";
//
// function CreateStudent() {
//     const navigate = useNavigate();
//     const [classroom, setClassroom] = useState();
//     const student = {
//         name: "",
//         classroom: "",
//         age: "",
//         address: "",
//         gender: ""
//     }
//
//     // Validate thong tin o input
//     const validationStudent = Yup.object().shape({
//         name: Yup.string()
//             .required("** Name không được để trống"),
//         age: Yup.number()
//             .required("** Age không được để trống")
//             .min(0, "Age không được nhỏ hơn 0 tuổi")
//             .max(200, "** Tuổi không được quá 200 tuổi"),
//         address: Yup.string()
//             .required("** Address không được để trống"),
//         classroom: Yup.string().required("** Class Room không được để trống"),
//         gender: Yup.string().required("** Gender khong duoc de trong")
//     });
//
//     useEffect(() => {
//         getAllClassroom();
//     }, [])
//
//     const getAllClassroom = async () => {
//         const temp = await classroomService.getAll();
//         setClassroom(temp)
//         console.log(temp);
//     }
//
//     const addNewStudent = async (value) => {
//         try {
//             console.log(value);
//             value.id = +value.id;
//             value.age = +value.age;
//             value.address = value.address;
//             value.gender = value.gender;
//             await studentService.add(value);
//             toast.success("Them moi thanh cong !");
//             navigate("/student");
//         } catch (error) {
//             console.log("Loi them moi hoc sinh : ", error);
//             toast.error("Da co loi xay ra khi them moi hoc sinh")
//         }
//     }
//
//     if (!classroom) return null
//
//     return (
//         <>
//             <Formik initialValues={student} onSubmit={addNewStudent} validationSchema={validationStudent}>
//                 <Form>
//                     Name: <Field name="name"/>
//                     <ErrorMessage name="id" component="p"/>
//                     Classroom: <Field as="select" name="classroom">
//                     <option value="" selected disabled>--Chon lop hoc--</option>
//
//                     {
//                         classroom.map(classroom => (
//                             <option value={classroom.nameClass} key={classroom.id}> {classroom.nameClass}</option>
//                         ))
//                     }
//                 </Field>
//                     <ErrorMessage name="classroom" component="p"/>
//
//                     Age: <Field name="age"/>
//                     <ErrorMessage name="age" component="p"/>
//                     Address: <Field name="address"/>
//                     <ErrorMessage name="address" component="p"/>
//                     Gender: <Field name="gender"/>
//                     <ErrorMessage name="gender" component="p"/>
//                     <br></br>
//
//                     <button type="submit">Them moi</button>
//                 </Form>
//             </Formik>
//         </>
//     )
// }
//
// export default CreateStudent;

import { ErrorMessage, Field, Form, Formik } from "formik";
import { useState, useEffect } from "react";
import * as Yup from 'yup';
import { useNavigate } from 'react-router-dom';
import { toast } from "react-toastify";
import * as studentService from "../Service/StudentService";
import * as classroomService from "../Service/ClassroomService";

function CreateStudent() {
    const navigate = useNavigate();
    const [classroom, setClassroom] = useState();
    const student = {
        id: "", // Thêm id vào giá trị ban đầu của student
        name: "",
        classroom: "",
        age: "",
        address: "",
        gender: ""
    }

    // Validate thong tin o input
    const validationStudent = Yup.object().shape({
        name: Yup.string()
            .required("** Name không được để trống"),
        age: Yup.number()
            .required("** Age không được để trống")
            .min(0, "Age không được nhỏ hơn 0 tuổi")
            .max(200, "** Tuổi không được quá 200 tuổi"),
        address: Yup.string()
            .required("** Address không được để trống"),
        classroom: Yup.string().required("** Class Room không được để trống"),
        gender: Yup.string().required("** Gender khong duoc de trong")
    });

    useEffect(() => {
        getAllClassroom();
    }, [])

    const getAllClassroom = async () => {
        const temp = await classroomService.getAll();
        setClassroom(temp)
        console.log(temp);
    }

    const addNewStudent = async (value) => {
        try {
            console.log(value);
            value.id = +value.id;
            value.age = +value.age;
            value.address = value.address;
            value.gender = value.gender;
            await studentService.add(value);
            toast.success("Them moi thanh cong !");
            navigate("/student");
        } catch (error) {
            console.log("Loi them moi hoc sinh : ", error);
            toast.error("Da co loi xay ra khi them moi hoc sinh")
        }
    }

    if (!classroom) return null

    return (
        <>
            <Formik initialValues={student} onSubmit={addNewStudent} validationSchema={validationStudent}>
                <Form>
                    Name: <Field name="name"/>
                    <ErrorMessage name="id" component="p"/>

                    Classroom: <Field as="select" name="classroom">
                    <option value="" selected disabled>--Chon lop hoc--</option>
                    {
                        classroom.map(classroom => (
                            <option value={classroom.nameClass} key={classroom.id}> {classroom.nameClass}</option>
                        ))
                    }
                </Field>
                    <ErrorMessage name="classroom" component="p"/>

                    Age: <Field name="age"/>
                    <ErrorMessage name="age" component="p"/>
                    Address: <Field name="address"/>
                    <ErrorMessage name="address" component="p"/>
                    Gender: <Field name="gender"/>
                    <ErrorMessage name="gender" component="p"/>
                    <br></br>

                    <button type="submit">Them moi</button>
                </Form>
            </Formik>
        </>
    )
}

export default CreateStudent;
