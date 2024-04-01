import {ErrorMessage, Field, Form, Formik} from "formik";
import {useState} from "react";
import * as Yup from "yup"
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as studentService from "../../services/StudentService"

function StudentCreate() {
    //Điều hướng đường đi
    const navigate =useNavigate();
    const student = {
        id: "2",
        name: "",
        gender: ""
    }
    const validationStudent = {
        id: Yup.number()
            .required("Id không được để trống")
            .min(0, "Id không được nhỏ hơn 0")
            .max(2000000),
        name: Yup.string()
            .required("Name không được để trống")
            .matches(/^[a-zA-Z ]{3,100}$/, "Tên không đúng định dạng")
    }
    const addNewStudent = (value) => {
        // Thêm mới dữ liệu thành công
        console.log(value)
        value.id = +value.id;
        value.gender = +value.gender;
        studentService.add(value);
        toast.success("Thêm mới thành công")
        navigate("/student")
    }
    return (
        <>
            <Formik initialValues={student} onSubmit={addNewStudent} validationSchema={Yup.object(validationStudent)}>
                <Form>
                    Id: <Field name="id"/>
                    <ErrorMessage name="id" component="span"></ErrorMessage>
                    Name: <Field name="name"/>
                    <ErrorMessage name="name" component="p"></ErrorMessage>
                    gender: <Field name="gender" required/>
                    <button type="submit">Thêm mới</button>
                </Form>
            </Formik>

        </>
    )

}

export default StudentCreate;