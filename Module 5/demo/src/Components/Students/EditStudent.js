// import {ErrorMessage, Field, Form, Formik} from "formik";
// import {useState, useEffect} from "react";
// import * as Yup from 'yup';
// import {useNavigate, useParams} from 'react-router-dom';
// import {toast} from "react-toastify";
// import * as studentService from "../Service/StudentService";
// import * as classroomService from "../Service/ClassroomService";
//
// export function EditStudent() {
//     const navigate = useNavigate();
//     const {id} = useParams();
//
//     const [classrooms, setClassrooms] = useState([]);
//     const [student, setStudent] = useState({
//         name: "",
//         classroom: "",
//         age: "",
//         address: "",
//         gender: ""
//     });
//
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
//         async function fetchData() {
//             try {
//                 const studentDetails = await studentService.getById(id);
//                 setStudent(studentDetails);
//
//                 const classroomsData = await classroomService.getAll();
//                 setClassrooms(classroomsData);
//             } catch (error) {
//                 console.log("Lỗi khi lấy thông tin: ", error);
//             }
//         }
//
//         fetchData();
//     }, [id]);
//
//     const updateStudent = async (values) => {
//         try {
//             await studentService.update(id, values);
//             toast.success("Cập nhật thông tin thành công !");
//             navigate("/student");
//         } catch (error) {
//             alert("Lỗi cập nhật thông tin học sinh: ", error);
//             toast.error("Đã có lỗi xảy ra khi cập nhật thông tin học sinh");
//         }
//     }
//
//     if (!classrooms.length || !student) return null;
//
//     return (
//         <>
//             <Formik initialValues={student} onSubmit={updateStudent} validationSchema={validationStudent}>
//                 <Form>
//
//                     Name: <Field type="text" name="name"/>
//                     <ErrorMessage name="name" component="p"/>
//                     Classroom:
//                     <Field as="select" name="classroom">
//                         <option value="" disabled>--Chọn lớp học--</option>
//                         {classrooms.map(classroom => (
//                             <option value={classroom.nameClass} key={classroom.id}> {classroom.nameClass}</option>
//                         ))}
//
//                         {/*{*/}
//                         {/*    classroom.map(classroom => (*/}
//                         {/*        <option value={classroom.nameClass} key={classroom.id}> {classroom.nameClass}</option>*/}
//                         {/*    ))*/}
//                         {/*}*/}
//                     </Field>
//                     <ErrorMessage name="classroom" component="p"/>
//                     Age: <Field type="number" name="age"/>
//                     <ErrorMessage name="age" component="p"/>
//                     Address: <Field type="text" name="address"/>
//                     <ErrorMessage name="address" component="p"/>
//                     Gender: <Field type="text" name="gender"/>
//                     <ErrorMessage name="gender" component="p"/>
//                     <br/>
//                     <button type="submit">Update</button>
//                 </Form>
//             </Formik>
//         </>
//     )
// }

import { ErrorMessage, Field, Form, Formik } from "formik";
import { useState, useEffect } from "react";
import * as Yup from 'yup';
import { useNavigate, useParams } from 'react-router-dom';
import { toast } from "react-toastify";
import * as studentService from "../Service/StudentService";
import * as classroomService from "../Service/ClassroomService";

export function EditStudent() {
    const navigate = useNavigate();
    const { id } = useParams();

    const [classrooms, setClassrooms] = useState([]);
    const [student, setStudent] = useState(null); // Initialize as null

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
        async function fetchData() {
            try {
                const studentDetails = await studentService.getById(id);
                if (studentDetails) {
                    setStudent(studentDetails);
                }

                const classroomsData = await classroomService.getAll();
                setClassrooms(classroomsData);
            } catch (error) {
                console.log("Lỗi khi lấy thông tin: ", error);
            }
        }

        fetchData();
    }, [id]);

    const updateStudent = async (values) => {
        try {
            await studentService.update(id, values);
            toast.success("Cập nhật thông tin thành công !");
            navigate("/student");
        } catch (error) {
            console.error("Lỗi cập nhật thông tin học sinh: ", error); // Changed to console.error for better logging
            toast.error("Đã có lỗi xảy ra khi cập nhật thông tin học sinh");
        }
    }

    if (!classrooms.length || !student) return null; // Handle initial loading state

    return (
        <>
            <Formik initialValues={student} onSubmit={updateStudent} validationSchema={validationStudent}>
                <Form>
                    Name: <Field type="text" name="name"/>
                    <ErrorMessage name="name" component="p"/>
                    Classroom:
                    <Field as="select" name="classroom">
                        <option value="" disabled>--Chọn lớp học--</option>
                        {classrooms.map(classroom => (
                            <option value={classroom.nameClass} key={classroom.id}> {classroom.nameClass}</option>
                        ))}
                    </Field>
                    <ErrorMessage name="classroom" component="p"/>
                    Age: <Field type="number" name="age"/>
                    <ErrorMessage name="age" component="p"/>
                    Address: <Field type="text" name="address"/>
                    <ErrorMessage name="address" component="p"/>
                    Gender: <Field type="text" name="gender"/>
                    <ErrorMessage name="gender" component="p"/>
                    <br/>
                    <button type="submit">Update</button>
                </Form>
            </Formik>
        </>
    )
}
