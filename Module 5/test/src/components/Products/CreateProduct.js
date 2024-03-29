import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import * as Yup from 'yup';
import * as typeBookService from "../Service/TypeBookService";
import {toast} from "react-toastify";
import * as bookService from "../Service/BookService";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {type} from "@testing-library/user-event/dist/type";

function CreateBook() {
    const navigate = useNavigate();
    const [typeBook, setTypeBook] = useState();
    const book = {
        id: "",
        name: "",
        author: "",
        quantity: "",
        type: ""
    }


    const validate = Yup.object().shape({
        name: Yup.string()
            .required("Name not null"),
        author: Yup.string()
            .required("Author not null"),
        quantity: Yup.number()
            .min(0, "Quantity must not be less than 0 ")
            .max(100, "Quantity must not be than 100")
            .required("Quantity not null"),
        type: Yup.string()
            .required("Type not null")
    });

    useEffect(() => {
        getAllTypeBook();
    }, []);

    const getAllTypeBook = async () => {
        const temp = await typeBookService.getAll();
        setTypeBook(temp);
        alert(temp);
    }


    const addNewBook = async (value) => {
        try {
            console.log(value);
            value.id = +value.id;
            value.name = value.name;
            value.author = value.author;
            value.quantity = +value.quantity;
            await bookService.add(value);
            toast.success("Add success!");
            navigate("/book");
        } catch (error) {
            console.log()("Error new add book ", error);
            toast.error("Error add book");
        }
    }

    if (!typeBook) return null;

    return (
        <>
            <Formik initialValues={book} onSubmit={addNewBook} validationSchema={validate}>
                <Form>
                    Name:
                    <Field name="name"/>
                    <ErrorMessage name="id" component="span"/>

                    Author:
                    <Field name="author"/>
                    <ErrorMessage name="author" component="span"/>

                    Quantity:
                    <Field name="quantity"/>
                    <ErrorMessage name="quantity" component="span"/>

                    Type:
                    <Field as="select" name="typeBook">
                        <option value="" selected disabled>--Select Type Book--</option>
                        {
                            type.map(type => (
                                <option value={type.typeBook} key={type.id}>{type.typeBook} </option>
                            ))
                        }
                    </Field>
                    <ErrorMessage name="type" component="span"></ErrorMessage>

                    <button type="submit">Add a book</button>
                </Form>
            </Formik>
        </>
    )
}

export default CreateBook;